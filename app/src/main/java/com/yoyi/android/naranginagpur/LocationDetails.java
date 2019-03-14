package com.yoyi.android.naranginagpur;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        //Extracting the ArrayList from Extra of the intent passed by the calling Fragment
        final ArrayList<Location> locationArrayList = (ArrayList<Location>) getIntent().getSerializableExtra("Location List");

        //Extracting the current position from Extra of the intent passed by the calling Fragment
        final int position = getIntent().getIntExtra("position", 0);

        //Extracting the calling Fragment ID from Extra of the intent passed by the calling Fragment
        final int callingIntentID = getIntent().getIntExtra("callingIntentID", 0);

        // Creating objects for the LocationDetails Activity Layout and setting them as per the attribute passed to them
        ImageView locationImage = findViewById(R.id.location_details_image);

        locationImage.setImageResource(locationArrayList.get(position).getmImageResourceID());

        TextView locationName = findViewById(R.id.location_details_name);

        locationName.setText(locationArrayList.get(position).getmName());

        TextView locationTimings = findViewById(R.id.location_details_timings);

        // Checking if the calling Fragment has no Open timings and setting the Timing TextView accordingly
        if (locationArrayList.get(position).getmOpenTimings() != null) {

            locationTimings.setText(locationArrayList.get(position).getmOpenTimings());

        } else
            locationTimings.setVisibility(View.INVISIBLE);

        TextView locationDescription = findViewById(R.id.location_details_description);

        locationDescription.setText(locationArrayList.get(position).getmDescription());

        // Linking the Map Locator and Street View Button to View Object

        Button mapLocatorButton = findViewById(R.id.map_locater_button);

        Button streetViewButton = findViewById(R.id.street_viewer_button);

        // Setting on click listener on the map locator button
        mapLocatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating string to pass in the Uri object
                String uriIntentString = "geo:" + locationArrayList.get(position).getmCoordinates()[0] + "," + locationArrayList.get(position).getmCoordinates()[1] + "?q=" + locationArrayList.get(position).getmCoordinates()[0] + "," + locationArrayList.get(position).getmCoordinates()[1] + "(" + locationArrayList.get(position).getmName() + ")";

                // Creating a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse(uriIntentString);

                // Creating an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Making the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempting to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });

        // Checking if the Calling Intent is TouristAttractions then setting on click listener if being true and launching google street view
        if (callingIntentID == 0) {
            streetViewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Creating string to pass in the Uri object
                    String uriIntentString = "google.streetview:cbll=" + locationArrayList.get(position).getmCoordinates()[0] + "," + locationArrayList.get(position).getmCoordinates()[1];

                    // Creating a Uri from an intent string. Use the result to create an Intent.
                    Uri gmmIntentUri = Uri.parse(uriIntentString);

                    // Creating an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                    // Making the Intent explicit by setting the Google Maps package
                    mapIntent.setPackage("com.google.android.apps.maps");

                    // Attempting to start an activity that can handle the Intent
                    startActivity(mapIntent);
                }
            });

        } else
            streetViewButton.setVisibility(View.INVISIBLE);
    }
}
