package com.example.happy.newsreader;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<newsItem> availNews = new ArrayList<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.load_news);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                StringRequest myRequest= new StringRequest(Request.Method.GET, "https://www.google.com/",
                        new Response.Listener<String>(){
                            @Override
                            public void onResponse(String response) {
                                Log.i("my Tag", "response"+response);
                            }
                        },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("my Tag", "error"+error);
                    }
                }
                );
                queue.add(myRequest);
            }
        });


        int imageId=0;
        availNews.add(new newsItem("newsDesc", "newsDescSmall","de", imageId, "author", "title", "url", "time"));


        ArrayAdapter<newsItem> adapter = new customeAdapter();

        ListView newsItem= (ListView) (findViewById(R.id.newsItem));
        newsItem.setAdapter(adapter);

        newsItem.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id)
            {

                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
   private class customeAdapter extends ArrayAdapter<newsItem>{
       public customeAdapter() {
           super(MainActivity.this, R.layout.my_layout, availNews);
       }

       @NonNull
       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           if(convertView==null){
               convertView=getLayoutInflater().inflate(R.layout.my_layout,parent,false);
           }
           newsItem mycurrentItem= availNews.get(position);

           ImageView myImage= (ImageView) convertView.findViewById(R.id.left_icon);
           TextView myHeading=(TextView) convertView.findViewById(R.id.heading);
           TextView myDescription=(TextView) convertView.findViewById(R.id.description);

           myImage.setImageResource(mycurrentItem.getImageId());
           myHeading.setText(mycurrentItem.getTitle());
           myDescription.setText(String.valueOf(mycurrentItem.getNewsDesc()));
           return convertView;
       }
   }

}



