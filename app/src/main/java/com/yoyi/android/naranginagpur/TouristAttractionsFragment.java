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
public class TouristAttractionsFragment extends Fragment {

    private ArrayList<Location> locationArrayList = new ArrayList<>();


    public TouristAttractionsFragment() {
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
                intent.putExtra("callingIntentID", 0);

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
        locationArrayList.add(new Location(getResources().getString(R.string.TA1name), getResources().getString(R.string.TA1Description), R.drawable.ta1, new float[]{21.128491f, 79.066950f}, getResources().getString(R.string.TA1Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA2name), getResources().getString(R.string.TA2Description), R.drawable.ta2, new float[]{21.129733f, 79.040671f}, getResources().getString(R.string.TA2Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA3name), getResources().getString(R.string.TA3Description), R.drawable.ta3, new float[]{21.150026f, 79.080620f}, getResources().getString(R.string.TA3Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA4name), getResources().getString(R.string.TA4Description), R.drawable.ta4, new float[]{21.153800f, 79.045483f}, getResources().getString(R.string.TA4Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA5name), getResources().getString(R.string.TA5Description), R.drawable.ta5, new float[]{21.143999f, 79.074191f}, getResources().getString(R.string.TA5Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA6name), getResources().getString(R.string.TA6Description), R.drawable.ta6, new float[]{21.146161f, 79.094137f}, getResources().getString(R.string.TA6Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA7name), getResources().getString(R.string.TA7Description), R.drawable.ta7, new float[]{21.148617f, 79.084517f}, getResources().getString(R.string.TA7Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA8name), getResources().getString(R.string.TA8Description), R.drawable.ta8, new float[]{20.434066f, 79.373774f}, getResources().getString(R.string.TA8Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA9name), getResources().getString(R.string.TA9Description), R.drawable.ta9, new float[]{21.151266f, 79.078087f}, getResources().getString(R.string.TA9Timings)));
        locationArrayList.add(new Location(getResources().getString(R.string.TA10name), getResources().getString(R.string.TA10Description), R.drawable.ta10, new float[]{21.154183f, 79.082447f}, getResources().getString(R.string.TA10Timings)));

    }

}
