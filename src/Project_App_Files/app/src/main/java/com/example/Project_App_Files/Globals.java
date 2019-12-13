package com.example.Project_App_Files;
import android.app.Application;
import org.json.JSONArray;
import org.json.JSONObject;

public class Globals extends Application {

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
    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
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
}
