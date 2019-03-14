package com.yoyi.android.naranginagpur;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestrauntsFragment extends Fragment {

    private ArrayList<Location> locationArrayList = new ArrayList<Location>();

    public RestrauntsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list_view, container, false);

        // Calling the data loader function to add Location objects to the array list
        getData();

        // Creating Objects for Views, Custom Array Adapter
        ListView locationListView = rootView.findViewById(R.id.list);

        // loading the ArrayList to the custom Array Adapter
        final LocationArrayAdapter locationArrayAdapter = new LocationArrayAdapter(getActivity(), locationArrayList);

        // Attaching the Custom Array Adapter to the List View
        locationListView.setAdapter(locationArrayAdapter);

        // Setting onItemClickListener on ListView to call LocationDetails Activity on click
        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Creating Intent to call the LocationDetails Activity
                Intent intent = new Intent(getActivity(), LocationDetails.class);

                // Adding LocationArrayList, position and CallingIntentID as Intent Extras
                intent.putExtra("Location List", locationArrayList);
                intent.putExtra("position", position);
                intent.putExtra("callingIntentID", 1);

                // Attempting to start the activity
                startActivity(intent);
            }
        });

        return rootView;
    }

    /***
     * Data Loader Method that adds Location objects in the ArrayList
     */
    private void getData() {
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant1), getResources().getString(R.string.Restro1details), R.drawable.restro1, new float[]{21.159326f, 79.080386f}, getResources().getString(R.string.RestroTimings1)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant2), getResources().getString(R.string.Restro2details), R.drawable.restro2, new float[]{21.153508f, 79.105564f}, getResources().getString(R.string.RestroTimings2)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant3), getResources().getString(R.string.Restro3details), R.drawable.restro3, new float[]{21.143340f, 79.082057f}, getResources().getString(R.string.RestroTimings3)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant4), getResources().getString(R.string.Restro4details), R.drawable.restro4, new float[]{21.106166f, 79.069338f}, getResources().getString(R.string.RestroTimings4)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant5), getResources().getString(R.string.Restro5details), R.drawable.restro5, new float[]{21.143533f, 79.080218f}, getResources().getString(R.string.RestroTimings5)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant6), getResources().getString(R.string.Restro6details), R.drawable.restro6, new float[]{21.087326f, 79.064427f}, getResources().getString(R.string.RestroTimings6)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant7), getResources().getString(R.string.Restro7details), R.drawable.restro7, new float[]{21.138086f, 79.082497f}, getResources().getString(R.string.RestroTimings7)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant8), getResources().getString(R.string.Restro8details), R.drawable.restro8, new float[]{21.137665f, 79.069268f}, getResources().getString(R.string.RestroTimings8)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant9), getResources().getString(R.string.Restro9details), R.drawable.restro9, new float[]{21.147112f, 79.136034f}, getResources().getString(R.string.RestroTimings9)));
        locationArrayList.add(new Location(getResources().getString(R.string.Restaurant10), getResources().getString(R.string.Restro10details), R.drawable.restro10, new float[]{21.105166f, 79.057963f}, getResources().getString(R.string.RestroTimings10)));
    }

}
