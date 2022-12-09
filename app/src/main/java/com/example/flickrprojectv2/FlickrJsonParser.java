package com.example.flickrprojectv2;

import android.util.Log;

import com.example.flickrprojectv2.model.Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlickrJsonParser {

//    static final String base_url = "https://www.flickr.com/services/rest/";
//    static final String api_key = "8d631d93dffe231943be1a16eeacd3a6";
//    static final String TAG = "Flickr";
//    int count;
//    static String resultJson;
//
//    public void urlToString(){
//        String url = constructPhotoListURL();
//
////        System.out.println(url);
////        Log.d(TAG, "fetchPhotos: " + url);
//
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
//                    InputStream urlConnectionInputStream = httpURLConnection.getInputStream();
//                    resultJson = convertToString(urlConnectionInputStream);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    private String convertToString(InputStream inputStream) throws IOException{
//        StringBuilder builder = new StringBuilder();
//        String oneLine = "";
//        count = 0;
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        try {
//            while ((oneLine = br.readLine()) != null) {
//                builder.append(oneLine);
//            }
//        } catch (Exception e) {
//        }
//        return builder.toString();
//    }
//
//    private String constructPhotoListURL() {
//        String url = base_url;
//        url += "?method=flickr.interestingness.getList";
//        url += "&api_key=" + api_key;
//        url += "&extras=url_h%2Cdate_taken";
//        url += "&format=json";
//        url += "&nojosncallback=1";
//
//        return url;
//    }
//
//    public static ArrayList<Photo> JsonToData (String resultJson) {
//        ArrayList<Photo> photoArrayList = new ArrayList<>();
//        try {
//            JSONObject jsonObject = new JSONObject(resultJson);
//            JSONArray jsonArray = jsonObject.optJSONObject("photos").optJSONArray("photo");
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject oneImage = jsonArray.getJSONObject(i);
//                String id = oneImage.getString("id");
//                String title = oneImage.getString("title");
//                String datetaken = oneImage.getString("datetaken");
//                String url_h = oneImage.getString("url_h");
//
//                Photo currentPhoto = new Photo(id, title, datetaken, url_h);
//                System.out.println(currentPhoto);
//                photoArrayList.add(currentPhoto);
//            }
//        } catch (JSONException ex) {
//            ex.printStackTrace();
//        }
//        return photoArrayList;
//    }
}