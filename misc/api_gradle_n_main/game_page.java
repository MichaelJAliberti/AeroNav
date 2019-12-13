package com.example.Project_App_Files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Project_App_Files.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.PlacesClient;

import org.decimal4j.util.DoubleRounder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class game_page extends AppCompatActivity {

    GoogleMap mMap;
    PlacesClient placesClient;
    List<AutocompletePrediction> predictionList;

    Button topLeftBtn;
    Button bottomLeftBtn;
    Button topRightBtn;
    Button bottomRightBtn;
    Button backBtn;

    String Global_target_airport_name,
            name2,
            name3,
            name4;

    Double Global_longitude,
            Global_latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        //Buttons
        backBtn = findViewById(R.id.backBtn);
        topLeftBtn = findViewById(R.id.topLeftBtn);
        bottomLeftBtn = findViewById(R.id.bottomLeftBtn);
        topRightBtn = findViewById(R.id.topRightBtn);
        bottomRightBtn = findViewById(R.id.bottomRightBtn);




        //API Airport Info start
        OkHttpClient client = new OkHttpClient();

        Request request_info = new Request.Builder()
                .url("https://airport-info.p.rapidapi.com/airport?icao=EGKK")
                .get()
                .addHeader("x-rapidapi-host", "airport-info.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7f7aee40f2mshc8d7b84684cb6f4p190104jsn938a02e43ad2")
                .build();





        client.newCall(request_info).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();


                    try {
                        JSONObject reader = new JSONObject(myResponse);
                        final String airport = reader.getString("city");
                        Double latitude = reader.getDouble("latitude");
                        Double longitude = reader.getDouble("longitude");

                        Global_target_airport_name = airport;
                        Global_latitude = latitude;
                        Global_longitude = longitude;

                        topLeftBtn.setText(airport);


                        /*game_page.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView HeaderTxt = findViewById(R.id.HeaderTxt);
                                HeaderTxt.setText(airport);
                            }
                        });*/
                    } catch (Exception e) {

                    }

                }
            }
        });  //API airport Info concluded



        //API airport Finder
        OkHttpClient client_finder_radius = new OkHttpClient();

        Request request_finder_radius = new Request.Builder()
                .url("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-radius?radius=50&lng=-0.1820629&lat=51.153664")
                .get()
                .addHeader("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7f7aee40f2mshc8d7b84684cb6f4p190104jsn938a02e43ad2")
                .build();




        try {
            double size = 0;
            Double latitude,
                    longitude;
            String name;

            Response response = client.newCall(request_finder_radius).execute();
            final String MyResponse = response.body().string();

            JSONArray FinderArray = new JSONArray(MyResponse);




            for (int i = 0; i < 4; i++) {

                size = FinderArray.length();
                Random rand = new Random();//Math.random()*(size-1);


                JSONObject airport = (JSONObject) FinderArray.get(rand.nextInt((int) size));


                JSONObject location = airport.getJSONObject("location");

                name = airport.getString("city");
                latitude = location.getDouble("latitude");
                longitude = location.getDouble("longitude");


                TextView TestingTxt = findViewById(R.id.Land);
                TestingTxt.setText(Boolean.toString((Math.abs(Global_longitude) + 0.03 <= Math.abs(longitude) && Math.abs(Global_longitude) - 0.03 >= Math.abs(longitude))));
                TestingTxt.setText(Boolean.toString(((Math.abs(Global_longitude) + 0.03) >= Math.abs(longitude))));

                if (((Math.abs(Global_longitude) + 0.03) >= Math.abs(longitude) && Math.abs(Global_longitude) - 0.03 <= Math.abs(longitude)) && (Math.abs(Global_latitude) + 0.03 >= Math.abs(latitude) && Math.abs(Global_latitude) - 0.03 <= Math.abs(latitude) ))  {
                    airport = (JSONObject) FinderArray.get((int) (i+(size-i)/2));

                    name = airport.getString("city");
                    latitude = airport.getDouble("latitude");
                    longitude = airport.getDouble("longitude");
                }

                switch (i) {
                    case 1:
                        bottomLeftBtn.setText(name);
                        break;
                    case 2:
                        topRightBtn.setText(name);
                        break;
                    case 3:
                        bottomRightBtn.setText(name);
                        break;
                }

                switch (i) {
                    case 1:
                        name2 = name;
                        break;
                    case 2:
                        name3 = name;
                        break;
                    case 3:
                        name4 = name;
                        break;
                }


            }


            //TextView TestingTxt = findViewById(R.id.Land);
            //TestingTxt.setText("SI");
        } catch (JSONException | IOException e) {
            TextView TestingTxt = findViewById(R.id.Land);
            //TestingTxt.setText("error");
            e.printStackTrace();
        }


 //API airport Finder concluded





        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackPage();

            }
        });

        topLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeftBtn.setBackgroundColor(Color.GREEN);
            }
        });

        bottomLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomLeftBtn.setBackgroundColor(Color.RED);
            }
        });

        topRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topRightBtn.setBackgroundColor(Color.GREEN);
            }
        });

        topLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeftBtn.setBackgroundColor(Color.RED);
            }
        });
    }

    public void openBackPage() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
