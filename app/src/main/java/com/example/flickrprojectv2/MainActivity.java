package com.example.flickrprojectv2;

import static com.example.flickrprojectv2.DataCollection.PhotoDataCollection.photoArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.flickrprojectv2.DataCollection.JsonManagement;
import com.example.flickrprojectv2.DataCollection.PhotoDataCollection;
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

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public static final String url = "https://www.flickr.com/services/rest/?method=flickr.interestingness.getList&api_key=5de29ae780a909d5a7be32df62d6a683&extras=url_h%2Cdate_taken&format=json&nojsoncallback=1";
    int count;
    String resultJson;
    Handler handlerForDisplayJson = new Handler();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processThread();
//        initializeRecyclerView();
    }

    private void initializeRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new recyclerViewAdapter();
        recyclerView.setAdapter(mAdapter);
    }

    private void processThread() {
        Thread threadForXml = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                    InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    resultJson = convertToString(inputStream);
                } catch (IOException e) {
                }
                JsonManagement.processJSONData(resultJson);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                PhotoDataCollection.photoArrayList = photoArrayList;
                handlerForDisplayJson.post(new Runnable() {
                    @Override
                    public void run() {
                        initializeRecyclerView();
                    }
                });
            }
        });
        threadForXml.start();
        threadForXml = null;
    }

    private String convertToString(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        String oneLine = "";
        count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while ((oneLine = br.readLine()) != null){
            builder.append(oneLine);
            count++;
        }
        return builder.toString();
    }
}