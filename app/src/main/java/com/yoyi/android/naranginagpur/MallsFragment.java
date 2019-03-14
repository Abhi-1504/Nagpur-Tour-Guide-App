package com.yoyi.android.naranginagpur;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallsFragment extends Fragment {

    private ArrayList<Location> locationArrayList = new ArrayList<Location>();

    public MallsFragment() {
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
                intent.putExtra("callingIntentID", 2);

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
        locationArrayList.add(new Location(getResources().getString(R.string.mall1), getResources().getString(R.string.mall1details), R.drawable.mall1, new float[]{21.148389f, 79.093418f}, getResources().getString(R.string.mall1timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.mall2), getResources().getString(R.string.mall2details), R.drawable.mall2, new float[]{21.138394f, 79.068492f}, getResources().getString(R.string.mall2timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.mall3), getResources().getString(R.string.mall3details), R.drawable.mall3, new float[]{21.144007f, 79.080536f}, getResources().getString(R.string.mall3timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.mall4), getResources().getString(R.string.mall4details), R.drawable.mall4, new float[]{21.143732f, 79.081112f}, getResources().getString(R.string.mall4timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.mall5), getResources().getString(R.string.mall5details), R.drawable.mall5, new float[]{21.143479f, 79.080292f}, getResources().getString(R.string.mall5timings)));
    }
}