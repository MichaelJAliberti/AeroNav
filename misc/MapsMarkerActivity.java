package com.example.mapwithmarker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

//import java.net.URLEncoder;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;


/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        //plane = createBitmap()
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.

        double origLat = 40.7128;
        double origLong = -74.0060; //-73.935242

        double locLat = 42.360;
        double locLong = -71.058;


        LatLng origin = new LatLng(origLat, origLong);
        LatLng location = new LatLng(locLat, locLong);
        googleMap.addMarker(new MarkerOptions().position(location)
                .title("Marker in Boston"));
        //MarkerOptions bostonMarker = new MarkerOptions().position(boston).title("Marker in Boston");
        //bostonMarker.icon("planeMarker2.ico");
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,14f));

       // LatLng norway = new LatLng(59.913, 10.752);
        //googleMap.addMarker(new MarkerOptions().position(norway).title("Marker in Oslo"));


        googleMap.addPolyline(new PolylineOptions().add(location).add(origin));

    }

    public void showNorway(GoogleMap googleMap){
        LatLng norway = new LatLng(59.913, 10.752);
        googleMap.addMarker(new MarkerOptions().position(norway).title("Marker in Oslo"));
    }
}
