package com.example.Project_App_Files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.Project_App_Files.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button startBtn,
            aboutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intervalAPICall();

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

    public void openGamePage()
    {
        // Goes to next page
        gotToGamePage();
    }

    public void openSettingPage() {

        Intent intent = new Intent(this, setting_page.class);
        startActivity(intent);

    }

    public void openAboutPage() {

        Intent intent = new Intent(this, about_page.class);
        startActivity(intent);
    }

    public void intervalAPICall() {
        // Get current Unix timestamp
        Long tsLong = System.currentTimeMillis()/1000;
        // Get timestamp for one day prior, and two hours before that
        Long tsLongEnd = tsLong - 172800;
        Long tsLongBegin = tsLongEnd -7200;

        // Convert time stamps to strings
        String tsStringBegin = tsLongBegin.toString();
        String tsStringEnd = tsLongEnd.toString();

        // Establish website string for data collection
        String url = "https://opensky-network.org/api/flights/all?begin=" + tsStringBegin + "&end=" + tsStringEnd;

        // Set up Request Queue
        RequestQueue queue = Volley.newRequestQueue(this);
        // Get JSON structure
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        // Save stuff
                        Globals g = (Globals)getApplicationContext();
                        g.setStartData(response);
                        String data = "Response" + response.toString();
                        trackAPICall();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(arrayRequest);
    }

    public void trackAPICall()
    {
        // Retrieve Midtime and Flight data
        Globals g = (Globals) getApplicationContext();
        JSONArray startData = g.getStartData();

        // Parse JSON Array for icao and times
        try {
            // Establish strings for the loop and onwards
            String arr = "null";
            String dep = "null";

            // Ensure data has Airport Lists
            do {
                g.incPlaneIt();
                JSONObject planeData = startData.getJSONObject(g.getPlaneIt());
                arr = planeData.getString("estArrivalAirport");
                dep = planeData.getString("estDepartureAirport");
            } while (arr.equals("null") || dep.equals("null"));

            // More permanently declare working plane data
            JSONObject planeData = startData.getJSONObject(g.getPlaneIt());

            // Get airport codes
            arr = planeData.getString("estArrivalAirport");
            dep = planeData.getString("estDepartureAirport");

            // Save airport codes
            g.setArrival(arr);
            g.setDepart(dep);

            // Get flight designator
            String code = planeData.getString("icao24");

            // Assemble midtime for url request
            Long startTime = planeData.getLong("firstSeen");
            Long endTime = planeData.getLong("lastSeen");
            Long preMidTime = (startTime + endTime) / 2;
            String midTime = preMidTime.toString();

            // Assemble new url
            String newUrl = "https://opensky-network.org/api/tracks/all?icao24=" + code + "&time=" + midTime;

            g.planeData = newUrl;///////////////////

            // Make a request
            RequestQueue newQueue = Volley.newRequestQueue(this);

            // Get JSON structure
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                    newUrl,
                    null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            // Parse
                            getPlaneCoordinates(response);

                            // Optional
                            Globals g = (Globals)getApplicationContext();
                            g.setPlaneParse(response);

                            // Other API calls
                            g.airportInfoAPICall(g.getArrival());
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error

                        }
                    });
            newQueue.add(objectRequest);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getPlaneCoordinates(JSONObject response) {
        try{
            // Parse response for mid-flight coordinates
            JSONArray wayPts = response.getJSONArray("path");
            int midPt = wayPts.length()/2;
            JSONArray midPtInfo = wayPts.getJSONArray(midPt);
            double planeLat = midPtInfo.getDouble(1);
            double planeLong = midPtInfo.getDouble(2);

            // Parse response for origin coordinates
            JSONArray depInfo = wayPts.getJSONArray(1);
            double depLat = depInfo.getDouble(1);
            double depLong = depInfo.getDouble(2);

            // Save midflight coordinates to global
            Globals g = (Globals)getApplicationContext();
            g.setPlaneLat(planeLat);
            g.setPlaneLong(planeLong);

            // Save departure coordinates to global
            g.setAirDepLat(depLat);
            g.setAirDepLong(depLong);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void gotToGamePage()
    {
        Intent intent = new Intent(this, game_page.class);
        startActivity(intent);
    }
}
