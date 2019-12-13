package com.example.Project_App_Files;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Globals extends Application {

    // Plane Stuff
    public String planeData;
    // Airport Stuff
    public String departData;
    public String departBiggus = "Hey";
    public String arriveData;
    public String arriveBiggus = "Hey";
    public Context Cxt;

    // Start Data
    private JSONArray startData;
    // Getters and Setters
    public JSONArray getStartData(){
        return this.startData;
    }
    public void setStartData(JSONArray in){
        startData = in;
    }

    // Plane Iterator
    int planeIt = 0;
    // Functions
    public int getPlaneIt() {
        return planeIt;
    }
    public void incPlaneIt() {
        planeIt++;
    }

    // Departure Airport
    String depart;
    double airDepLong;
    double airDepLat;
    // Functions
    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }
    public double getAirDepLong() {
        return airDepLong;
    }
    public double getAirDepLat() {
        return airDepLat;
    }
    public void setAirDepLong(double longitude) {
        this.airDepLong = longitude;
    }
    public void setAirDepLat(double latitude) {
        this.airDepLat = latitude;
    }

    // Plane Coordinates
    double planeLong;
    double planeLat;
    // Functions
    public double getPlaneLong() {
        return planeLong;
    }
    public double getPlaneLat() {
        return planeLat;
    }
    public void setPlaneLong(double longitude) {
        this.planeLong = longitude;
    }
    public void setPlaneLat(double planeLat) {
        this.planeLat = planeLat;
    }

    // Airport1 (Destination/Arrival airport) Coordinates
    String arrival;
    double airOneLong;
    double airOneLat;
    // Functions
    public String getArrival() {
        return arrival;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public double getAirOneLong() {
        return airOneLong;
    }
    public double getAirOneLat() {
        return airOneLat;
    }
    public void setAirOneLong(double longitude) {
        this.airOneLong = longitude;
    }
    public void setAirOneLat(double latitude) {
        this.airOneLat = latitude;
    }

    // Airport2 Coordinates
    double airTwoLong;
    double airTwoLat;
    // Functions
    public double getAirTwoLong() {
        return airTwoLong;
    }
    public double getAirTwoLat() {
        return airTwoLat;
    }
    public void setAirTwoLong(double longitude) {
        this.airTwoLong = longitude;
    }
    public void setAirTwoLat(double latitude) {
        this.airTwoLat = latitude;
    }

    // Airport3 Coordinates
    double airThreeLong;
    double airThreeLat;
    // Functions
    public double getAirThreeLong() {
        return airThreeLong;
    }
    public double getAirThreeLat() {
        return airThreeLat;
    }
    public void setAirThreeLong(double longitude) {
        this.airThreeLong = longitude;
    }
    public void setAirThreeLat(double latitude) {
        this.airThreeLat = latitude;
    }

    // Airport4 Coordinates
    Long airFourLong;
    Long airFourLat;
    // Functions
    public Long getAirFourLong() {
        return airFourLong;
    }
    public Long getAirFourLat() {
        return airFourLat;
    }
    public void setAirFourLong(Long longitude) {
        this.airFourLong = longitude;
    }
    public void setAirFourLat(Long latitude) {
        this.airFourLat = latitude;
    }

    // Streak counter
    int streak = 0;
    // Functions
    public String getStreak() {
        Integer temp = Integer.valueOf(streak);
        return temp.toString();
    }
    public void incStreak(){
        streak++;
    }
    public void resetStread(){
        streak = 0;
    }

    // Optional Waypoint info checker
    String trackURL;
    JSONObject planeParse;
    public void setPlaneParse(JSONObject planeParse) {
        this.planeParse = planeParse;
    }
    public JSONObject getPlaneParse() {
        return planeParse;
    }
    public void setTrackURL(String trackURL) {
        this.trackURL = trackURL;
    }
    public String getTrackURL() {
        return trackURL;
    }


    ///////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////     FUNCTIONS BLOCK     /////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    // Thes API requests are included here due to conflicts between the Volley and OKHttp
    // API request methods. This is not ideal, but a necessary evil

    public void airportInfoAPICall(String inPort, int code)
    {
        // Format URL
        String newURL = "https://airport-info.p.rapidapi.com/airport?icao=" + inPort;

        // Make parser final for airport determnations
        final int id = code;

        if (id == 0) {
            departData = newURL;
        }
        else if (id == 1) {
            arriveData = newURL;
        }

        // Make Call
        OkHttpClient client = new OkHttpClient();

        Request request_info = new Request.Builder()
                .url(newURL)
                .get()
                .addHeader("x-rapidapi-host", "airport-info.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7f7aee40f2mshc8d7b84684cb6f4p190104jsn938a02e43ad2")
                .build();

        client.newCall(request_info).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    final String myResponse = response.body().string();
                    try {
                        JSONObject reader = new JSONObject(myResponse);
                        final String airport = reader.getString("city");
                        Double latitude = reader.getDouble("latitude");
                        Double longitude = reader.getDouble("longitude");

                        if (id == 0) {
                            depart = airport;
                            airDepLat = latitude;
                            airDepLong = longitude;
                            departBiggus = reader.toString();
                        }
                        else if (id == 1) {
                            arrival = airport;
                            airOneLat = latitude;
                            airOneLong = longitude;
                            arriveBiggus = reader.toString();
                        }
                    } catch (Exception e) {
                        arriveBiggus = "IDIOT YOU DUMB";
                    }
            }
        });
    }
}
