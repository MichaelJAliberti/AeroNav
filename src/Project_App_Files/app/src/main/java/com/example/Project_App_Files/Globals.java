package com.example.Project_App_Files;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Globals extends Application {

    public String planeData;

    // GamePage Iterator
    private int gamePageIt = 0;
    public void incGamePage(){
        gamePageIt++;
    }
    public int getGamePageIt(){
        return gamePageIt;
    }

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
    public String arrival;
    public String airOneName;
    double airOneLong;
    double airOneLat;
    // Functions
    public String getArrival() {
        return arrival;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public String getAirOneName() {
        return airOneName;
    }
    public void setAirOneName(String airOneName) {
        this.arrival = airOneName;
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
    private String airTwoName;
    double airTwoLong;
    double airTwoLat;
    // Functions
    public String getAirTwoName(){
        return airTwoName;
    }
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
    public String airThreeName;
    double airThreeLong;
    double airThreeLat;
    // Functions
    public String getAirThreeName(){
        return airThreeName;
    }
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
    private String airFourName;
    private double airFourLong;
    private double airFourLat;
    // Functions
    public String getAirFourName(){
        return airFourName;
    }
    public double getAirFourLong() {
        return airFourLong;
    }
    public double getAirFourLat() {
        return airFourLat;
    }
    public void setAirFourLong(double longitude) {
        this.airFourLong = longitude;
    }
    public void setAirFourLat(double latitude) {
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

    public void airportInfoAPICall(String inPort)
    {
        // Format URL
        String newURL = "https://airport-info.p.rapidapi.com/airport?icao=" + inPort;

        //arriveData = newURL;

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

                        airOneName = airport;
                        airOneLat = latitude;
                        airOneLong = longitude;

                        airportFinderAPICall();

                        //arriveBiggus = reader.toString();
                    } catch (Exception e) {
                        //arriveBiggus = "IDIOT YOU DUMB";
                    }
            }
        });
    }

    public void airportFinderAPICall(){
        // Establish client
        OkHttpClient client_finder_radius = new OkHttpClient();

        // Get arrival airport lat long and convert to strings
        Double tempLat = airOneLat;
        Double tempLong = airOneLong;
        String latString = tempLat.toString();
        String longString = tempLong.toString();

        // Create url
        String newUrl = "https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-radius?radius=200&lng=" + longString + "&lat=" + latString;

        Request request_finder_radius = new Request.Builder()
                .url(newUrl)
                .get()
                .addHeader("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7f7aee40f2mshc8d7b84684cb6f4p190104jsn938a02e43ad2")
                .build();

        try {
            double size = 0;
            Double latitude,
                    longitude;
            String name;

            Response response = client_finder_radius.newCall(request_finder_radius).execute();
            final String MyResponse = response.body().string();

            JSONArray FinderArray = new JSONArray(MyResponse);

            for (int i = 0; i < 3; i++) {

                size = FinderArray.length();
                Random rand = new Random();//Math.random()*(size-1);

                JSONObject airport = (JSONObject) FinderArray.get(rand.nextInt((int) size));

                JSONObject location = airport.getJSONObject("location");

                name = airport.getString("city");
                latitude = location.getDouble("latitude");
                longitude = location.getDouble("longitude");

                if (((Math.abs(airOneLong) + 0.03) >= Math.abs(longitude) && Math.abs(airOneLong) - 0.03 <= Math.abs(longitude)) && (Math.abs(airOneLat) + 0.03 >= Math.abs(latitude) && Math.abs(airOneLat) - 0.03 <= Math.abs(latitude) ))  {
                    airport = (JSONObject) FinderArray.get((int) (i+(size-i)/2));

                    name = airport.getString("city");
                    latitude = airport.getDouble("latitude");
                    longitude = airport.getDouble("longitude");
                }

                switch (i) {
                    case 0:
                        // name1
                        airTwoName = name;
                        airTwoLat = latitude;
                        airTwoLong = longitude;
                        break;
                    case 1:
                        // name2
                        airThreeName = name;
                        airThreeLat = latitude;
                        airThreeLong = longitude;
                        break;
                    case 2:
                        // name3
                        airFourName = name;
                        airFourLat = latitude;
                        airFourLong = longitude;
                        break;
                }
            }
        }
        catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}
