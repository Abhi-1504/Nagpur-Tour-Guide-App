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
public class MarketsFragment extends Fragment {

    private ArrayList<Location> locationArrayList = new ArrayList<>();

    public MarketsFragment() {
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
                intent.putExtra("callingIntentID", 4);

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
        locationArrayList.add(new Location(getResources().getString(R.string.market1), getResources().getString(R.string.market1details), R.drawable.market1, new float[]{21.153161f, 79.110532f}));
        locationArrayList.add(new Location(getResources().getString(R.string.market2), getResources().getString(R.string.market2details), R.drawable.market2, new float[]{21.146624f, 79.084917f}));
        locationArrayList.add(new Location(getResources().getString(R.string.market3), getResources().getString(R.string.market3details), R.drawable.market3, new float[]{21.152925f, 79.107603f}));
    }
}
