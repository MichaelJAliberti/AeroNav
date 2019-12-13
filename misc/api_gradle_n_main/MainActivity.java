package com.example.Project_App_Files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Project_App_Files.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    Button startBtn,
            settingBtn,
            aboutBtn;

    //String airport;



    private TextView mTextHeader;

    Long Global_longitude,
            Global_latitude;

    /*HttpResponse<String> response = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-radius?radius=50&lng=-157.895277&lat=21.265600")
            .header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
            .header("x-rapidapi-key", "7f7aee40f2mshc8d7b84684cb6f4p190104jsn938a02e43ad2")
            .asString();*/




    //client.newCall(request).enqueue(new Callback() {
    //})



    //});




    //Response response = client.newCall(request).execute();






    //JSONObject reader = new JSONObject(myResponse);

    //String airport = reader.getString("name");


    //public MainActivity() throws JSONException, IOException {
    //}

    /*MainActivity.this.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            mTextHeader.setText(myResponse);
        }
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        OkHttpClient client_finder_radius = new OkHttpClient();

        Request request_finder_radius = new Request.Builder()
                .url("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-radius?radius=6&lng=-157.895277&lat=21.265600")
                .get()
                .addHeader("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7f7aee40f2mshc8d7b84684cb6f4p190104jsn938a02e43ad2")
                .build();


        /*if(true){

            try {
                TextView HeaderTxt = findViewById(R.id.HeaderTxt);

                Response response = client_finder_radius.newCall(request_finder_radius).execute();

                 String myResponse = response.body().string();
                //String myResponse = response.body();

                JSONArray mArrayID = new JSONArray(myResponse);

                JSONObject first = (JSONObject) mArrayID.get(0);

                String name = first.getString("name");

                System.out.println(myResponse);

                //JsonParser jsonParser = new JsonParser();

                //JSONObject jsonObject = (JSONObject) jsonParser.parse(mArrayID);



                //JSONArray mOBGJID = new mArrayID.getJSONArray("0");

                //JSONObject jsonOBJ = new JSONObject(myResponse);

                //JSONArray mArrayID = jsonOBJ.getJSONArray("0");


                //Gson gson = new Gson();//Builder().setPrettyPrinting().create();
                //JsonParser jp = new JsonParser();
                //JsonElement je = jp.parse(response.body().string());
                //String stuff = gson.toJson(je);

                //System.out.println(stuff);

                //JSONObject name = new JSONObject(stuff);

                //Finder reader = gson.fromJson(stuff, Finder.class);

                //JSONObject reader = gson.fromJson(je, JSONObject.class);//new JSONObject(stuff);

                //JsonObject obj = je.getAsJsonObject();
                //String prettyJsonString = gson.toJson(je);

                //Properties data = gson.fromJson(toExtract)

                //JsonElement je2 = je.getJ("0");


                //JSONObject reader = new JSONObject(myResponse);
                //reader.put(myResponse);
                //HeaderTxt.setText("Here");
                //JSONObject first = reader.getJSONObject("0");
                //final String airport_2 = first.getString("name");


                //TextView HeaderTxt = findViewById(R.id.HeaderTxt);
                HeaderTxt.setText(name);
            } catch (IOException | JSONException e) {
                TextView HeaderTxt = findViewById(R.id.HeaderTxt);
                //HeaderTxt.setText("HI");
                e.printStackTrace();

            }

        }*/

        client_finder_radius.newCall(request_finder_radius).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String MyResponse = response.body().string();

                    try {

                        //TextView HeaderTxt = findViewById(R.id.HeaderTxt);
                        //HeaderTxt.setText("hi");

                        //JSONObject reader = new JSONObject(myResponse);
                        //JSONObject first = reader.getJSONObject("0");
                        //final String airport_2 = first.getString("name");
                        //Long latitude = first.getLong("latitude");
                        //Long longitude = first.getLong("longitude");

                        //Global_latitude = latitude;
                        //Global_longitude = longitude;
                        //System.out.print("Successful");


                        //Response response = client_finder_radius.newCall(request_finder_radius).execute();

                        //String myResponse = response.body().string();
                        //String myResponse = response.body();

                        JSONArray mArrayID = new JSONArray(MyResponse);

                        JSONObject first = (JSONObject) mArrayID.get(0);

                        final String name = first.getString("name");




                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    } catch (Exception e) {
                        TextView HeaderTxt = findViewById(R.id.HeaderTxt);
                        HeaderTxt.setText("Error");

                    }

                }
            }
        });



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
                        final String airport = reader.getString("name");
                        Long latitude = reader.getLong("latitude");
                        Long longitude = reader.getLong("longitude");

                        Global_latitude = latitude;
                        Global_longitude = longitude;


                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView HeaderTxt = findViewById(R.id.HeaderTxt);
                                HeaderTxt.setText(airport);
                            }
                        });
                        } catch (Exception e) {

                    }

                }
            }
        });





        //TextView HeaderTxt = findViewById(R.id.HeaderTxt);
        //HeaderTxt.setText(airport);

        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView HeaderTxt = (TextView) findViewById(R.id.HeaderTxt);
                //HeaderTxt.setText("It's a Train");
                openGamePage();

            }
        });





        aboutBtn = findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutPage();

            }
        });

    }



    public void openGamePage() {

        Intent intent = new Intent(this, game_page.class);
        startActivity(intent);

    }

    public void openSettingPage() {

        Intent intent = new Intent(this, setting_page.class);
        startActivity(intent);

    }

    public void openAboutPage() {

        Intent intent = new Intent(this, about_page.class);
        startActivity(intent);

    }

    //}
}
