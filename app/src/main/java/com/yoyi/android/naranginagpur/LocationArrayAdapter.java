package com.yoyi.android.naranginagpur;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/***
 * {@link LocationArrayAdapter} ia an {@link ArrayAdapter} that can provide the layout for each list item
 * based on the data source, which is a list of {@link Location} objects.
 */

public class LocationArrayAdapter extends ArrayAdapter<Location> {

    /***
     * Create a new {@link LocationArrayAdapter} object.
     * @param context context of the calling Fragment
     * @param locationArrayList Arraylist containing the {@link Location} objects
     */

    public LocationArrayAdapter(Context context, ArrayList<Location> locationArrayList) {
        super(context, 0, locationArrayList);
    }

    /***
     * Method gets the View layout that would be inflated in the List View
     * @param position current position of the array list
     * @param convertView ListView that needs to be inflated
     * @param parent Parent View
     * @return Inflated ListView with all the views being set as per the {@link Location} object values
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        // Inflating ListView if it's empty
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.location_list, parent, false);
        }

        // Getting the current Location Object
        Location currentLocation = getItem(position);

        // Setting the Views as per the current Location object attributes
        ImageView locationImage = listItemView.findViewById(R.id.image);

        locationImage.setImageResource(currentLocation.getmImageResourceID());

        TextView locationName = listItemView.findViewById(R.id.name);

        locationName.setText(currentLocation.getmName());

        TextView locationTimings = listItemView.findViewById(R.id.timings);

        // Checking if the Location object does not have a specified open timings
        // as in case of MarketsFragment and setting the TextView accordingly
        if (currentLocation.getmOpenTimings() != null) {

            locationTimings.setText(currentLocation.getmOpenTimings());
        } else
            locationTimings.setVisibility(View.INVISIBLE);

        return listItemView;
    }
}
