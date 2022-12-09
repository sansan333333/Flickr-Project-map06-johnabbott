package com.example.flickrprojectv2.DataCollection;

import static com.example.flickrprojectv2.DataCollection.PhotoDataCollection.photoArrayList;

import android.util.Log;

import com.example.flickrprojectv2.model.Photo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonManagement {

    public static void processJSONData(String data) {
//        ArrayList<Photo> photoArrayList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.optJSONObject("photos").optJSONArray("photo");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject oneImage = jsonArray.getJSONObject(i);
                String id = oneImage.getString("id");
                String title = oneImage.getString("title");
                String dateTaken = oneImage.getString("datetaken");
                String url_h = "";
                try{
                    url_h = oneImage.getString("url_h");
                } catch (Exception e) {
                }
                if (!url_h.equals("")){
                    Photo photo = new Photo(id,title,dateTaken,url_h);
                    photoArrayList.add(photo);
                }

//                Photo photo = new Photo(id,title,dateTaken);


//                Log.d("JSON", photo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return photoArrayList;
    }
}
