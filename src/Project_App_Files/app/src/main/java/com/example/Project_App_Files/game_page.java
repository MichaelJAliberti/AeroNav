//package com.example.Project_App_Files;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.model.PolylineOptions;
//
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.location.Location;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.Project_App_Files.R;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.libraries.places.api.model.AutocompletePrediction;
//import com.google.android.libraries.places.api.net.PlacesClient;
//
//import java.util.List;
//
//public class game_page extends AppCompatActivity {
//    /////// MAP WITH MARKERS ////////////////
//    GoogleMap googleMap;
//
//
//
//
//
//
//    //////////////////////////////////////////
//    PlacesClient placesClient;
//    List<AutocompletePrediction> predictionList;
//
//    Button topLeftBtn;
//    Button bottomLeftBtn;
//    Button topRightBtn;
//    Button bottomRightBtn;
//    Button backBtn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        //GoogleMap googleMap;
//        ///////////////   MAP    /////////
//        double origLat = 40.7128;
//        double origLong = -74.0060; //-73.935242;
//
//        double locLat = 42.360;
//        double locLong = -71.058;
//
//
//        LatLng origin = new LatLng(origLat, origLong);
//        LatLng location = new LatLng(locLat, locLong);
//        //googleMap.addMarker(new MarkerOptions().position(location).title("Marker in Boston"));
//        //MarkerOptions bostonMarker = new MarkerOptions().position(boston).title("Marker in Boston");
//        //bostonMarker.icon("planeMarker2.ico");
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,14f));
//
//        // LatLng norway = new LatLng(59.913, 10.752);
//        //googleMap.addMarker(new MarkerOptions().position(norway).title("Marker in Oslo"));
//
//
//        //googleMap.addPolyline(new PolylineOptions().add(location).add(origin));
//        /////////////   End Map //////////////////////////
//
//
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game_page);
//        backBtn = findViewById(R.id.backBtn);
//        topLeftBtn = findViewById(R.id.topLeftBtn);
//        bottomLeftBtn = findViewById(R.id.bottomLeftBtn);
//        topRightBtn = findViewById(R.id.topRightBtn);
//        bottomRightBtn = findViewById(R.id.bottomRightBtn);
//
//
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openBackPage();
//
//            }
//        });
//
//        topLeftBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                topLeftBtn.setBackgroundColor(Color.GREEN);
//            }
//        });
//
//        bottomLeftBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomLeftBtn.setBackgroundColor(Color.RED);
//            }
//        });
//
//        topRightBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                topRightBtn.setBackgroundColor(Color.GREEN);
//            }
//        });
//
//        topLeftBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                topLeftBtn.setBackgroundColor(Color.RED);
//            }
//        });
//
////        bottomRightBtn.setOnClickListener((v) -> {
////            bottomRightBtn.setBackgroundColor(Color.RED);
////        });
//    }
//
//    //@Override
////    public void onMapReady(GoogleMap googleMap) {
////        //plane = createBitmap()
////        // Add a marker in Sydney, Australia,
////        // and move the map's camera to the same location.
////
////        double origLat = 40.7128;
////        double origLong = -74.0060; //-73.935242
////
////        double locLat = 42.360;
////        double locLong = -71.058;
////
////
////        LatLng origin = new LatLng(origLat, origLong);
////        LatLng location = new LatLng(locLat, locLong);
////        googleMap.addMarker(new MarkerOptions().position(location)
////                .title("Marker in Boston"));
////        //MarkerOptions bostonMarker = new MarkerOptions().position(boston).title("Marker in Boston");
////        //bostonMarker.icon("planeMarker2.ico");
////        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,14f));
////
////        // LatLng norway = new LatLng(59.913, 10.752);
////        //googleMap.addMarker(new MarkerOptions().position(norway).title("Marker in Oslo"));
////
////
////        googleMap.addPolyline(new PolylineOptions().add(location).add(origin));
////
////    }
//
//    public void openBackPage() {
//
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//
//    }
//}








/////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////       MapWithMarker                        /////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////


package com.example.Project_App_Files;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.Random;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.Button;
import android.widget.RemoteViews;
import com.example.Project_App_Files.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.PlacesClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;



public class game_page extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    //////////////////////////////////////////////////
    ///////////      Cities Markers      /////////////
    //////////////////////////////////////////////////

    // origin (departure airport)
    double origLat = 40.7128;
    double origLong = -74.0060; //-73.935242
    String originName = "New York";

    // destination (arrival airport)
    double locLat = 42.360;
    double locLong = -71.058;
    String locationName = "Correct city";

    // mid-flight
    String halfwayName = "Plane";

    // option1
    double lat1 = locLat + 2;
    double long1 = locLong + 2;
    String option1Name = "Not correct city1";

    // option2
    double lat2 = locLat +1;
    double long2 = locLong -1;
    String option2Name = "Not correct city2";

    // option3
    double lat3 = locLat -1;
    double long3 = locLong -1;
    String option3Name = "Not correct city3";


    //////////////////////////////////////////////////
    /////////      Button Initialization      ////////
    //////////////////////////////////////////////////

    // Button declarations
    Button topLeftBtn;
    Button bottomLeftBtn;
    Button topRightBtn;
    Button bottomRightBtn;
    Button backBtn;

    ////// Make a random integer //////
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_game_page);

        // Set streak counter
        final TextView textView = (TextView)findViewById(R.id.streakID);
        updateStreak();

        // Start global feed
        final Globals g = (Globals) getApplicationContext();

        // Initialize button text
        backBtn = findViewById(R.id.backBtn);
        topLeftBtn = findViewById(R.id.topLeftBtn);
        bottomLeftBtn = findViewById(R.id.bottomLeftBtn);
        topRightBtn = findViewById(R.id.topRightBtn);
        bottomRightBtn = findViewById(R.id.bottomRightBtn);

        // Initialize button names
        final int randomInt1to4 = getRandomNumberInRange(1,4);

        if (randomInt1to4 == 1) {
            topLeftBtn.setText(locationName);

        } else {
            topLeftBtn.setText(option1Name);

        }

        if (randomInt1to4 == 2) {
            bottomLeftBtn.setText(locationName);
        } else {
            bottomLeftBtn.setText(option2Name);
        }

        if (randomInt1to4 == 3) {
            topRightBtn.setText(locationName);
        } else {
            topRightBtn.setText(option3Name);
        }

        if (randomInt1to4 == 4) {
            bottomRightBtn.setText(locationName);
        } else {
            bottomRightBtn.setText(option1Name);
        }

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Set Button purposes
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delayRestart(500);
            }
        });

        topLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomInt1to4 == 1) {
                    topLeftBtn.setBackgroundColor(Color.GREEN);
                    g.incStreak();
                    updateStreak();
                    trackAPICall();
                } else {
                    topLeftBtn.setBackgroundColor(Color.RED);
                    g.resetStread();
                    updateStreak();
                }
            }
        });

        bottomLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomInt1to4 == 2) {
                    bottomLeftBtn.setBackgroundColor(Color.GREEN);
                    g.incStreak();
                    updateStreak();
                    trackAPICall();
                } else {
                    bottomLeftBtn.setBackgroundColor(Color.RED);
                    g.resetStread();
                    updateStreak();
                }
            }
        });

        topRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomInt1to4 == 3) {
                    topRightBtn.setBackgroundColor(Color.GREEN);
                    g.incStreak();
                    updateStreak();
                    trackAPICall();
                } else {
                    topRightBtn.setBackgroundColor(Color.RED);
                    g.resetStread();
                    updateStreak();
                }
            }
        });

        bottomRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomInt1to4 == 4) {
                    bottomRightBtn.setBackgroundColor(Color.GREEN);
                    g.incStreak();
                    updateStreak();
                    trackAPICall();
                } else {
                    bottomRightBtn.setBackgroundColor(Color.RED);
                    g.resetStread();
                    updateStreak();
                }
            }
        });
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Prepare to fetch from Global
        Globals g = (Globals) getApplicationContext();

        // Points
        LatLng origin = new LatLng(g.getAirDepLat(), g.getAirDepLong());
        LatLng location = new LatLng(g.getAirOneLat(), g.getAirOneLong());
        LatLng location_halfway = new LatLng(g.getPlaneLat(), g.getPlaneLong());
        LatLng option1 = new LatLng(lat1,long1);
        LatLng option2 = new LatLng(lat2,long2);
        LatLng option3 = new LatLng(lat3,long3);

        // Plot markers
        googleMap.addMarker(new MarkerOptions().position(origin)
                .title(originName));
        googleMap.addMarker(new MarkerOptions().position(location)
                .title(locationName));
        googleMap.addMarker(new MarkerOptions().position(option1)
                .title(option1Name));
        googleMap.addMarker(new MarkerOptions().position(option2)
                .title(option2Name));
        googleMap.addMarker(new MarkerOptions().position(option3)
                .title(option3Name));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location_halfway,5f));

        googleMap.addPolyline(new PolylineOptions().add(location_halfway).add(origin));
    }

    public void updateStreak() {
        // Displays updated streak

        TextView textView = (TextView)findViewById(R.id.streakID);
        Globals g = (Globals) getApplicationContext();
        /*
        String streakVal = g.getStreak();
        String streakDisp = "Streak: " + streakVal;
        textView.setText(streakDisp);
        */
        String biggues = g.planeData + "\n" + g.departData + "\n" + g.arriveData + "\n\n" + g.departBiggus + "\n\n" + g.arriveBiggus;
        textView.setText(biggues);
    }

    public void openGamePage() {
        final Intent intent = new Intent(this, game_page.class);
        startActivity(intent);
    }

    public void delayRestart(long time){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openBackPage();
            }
        }, time); // Millisecond 1000 = 1 sec
    }

    public void openBackPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void trackAPICall() {
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
            } while (arr.equals("null") || dep.equals("null") || arr.equals("dep"));

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

                            // Call next API
                            g.airportInfoAPICall(g.getDepart(), 0);
                            g.airportInfoAPICall(g.getArrival(), 1);

                            //Proceed
                            openGamePage();
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
            int midPt = wayPts.length()-1;
            JSONArray midPtInfo = wayPts.getJSONArray(midPt);
            double planeLat = midPtInfo.getDouble(1);
            double planeLong = midPtInfo.getDouble(2);

            // Save midflight coordinates to global
            Globals g = (Globals)getApplicationContext();
            g.setPlaneLat(planeLat);
            g.setPlaneLong(planeLong);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}



/*
try {
            JSONObject heyo = g.getPlaneParse();
            JSONArray wayPts = heyo.getJSONArray("path");
            int midPt = wayPts.length() / 2;
            JSONArray midPtInfo = wayPts.getJSONArray(midPt);
            String HEYP = midPtInfo.toString();
            String output = "URL: " + g.getTrackURL() + "\nDATA: " + HEYP;
            textView.setText(output);
        }
        catch (JSONException e)
        {
        }
 */
