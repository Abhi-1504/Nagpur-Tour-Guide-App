package com.yoyi.android.naranginagpur;

import java.io.Serializable;

// Location class implementing Serializable class to avoid intent related exceptions
public class Location implements Serializable {

    // Location Name
    private String mName;

    // Location Description
    private String mDescription;

    // Location Image
    private int mImageResourceID;

    // Location Co-ordinates
    private float mCoordinates[];

    // Location open Timings
    private String mOpenTimings;

    /***
     * Location Class Constructor for location having open timings
     * @param name Name of the location
     * @param description Brief Description of the location
     * @param imageResourceID Carries Image ID of the location
     * @param coordinates Longitude and Latitude coordinates of the location to locate on map
     * @param openTimings Open timings of the location
     */
    public Location(String name, String description, int imageResourceID, float coordinates[], String openTimings) {
        mName = name;
        mDescription = description;
        mImageResourceID = imageResourceID;
        mCoordinates = coordinates;
        mOpenTimings = openTimings;
    }

    /***
     * Location Class Constructor for location having no specific working timings
     * @param name Name of the location
     * @param description Brief Description of the location
     * @param imageResourceID Carries Image ID of the location
     * @param coordinates Longitude and Latitude coordinates of the location to locate on map
     */
    public Location(String name, String description, int imageResourceID, float coordinates[]) {
        mName = name;
        mDescription = description;
        mImageResourceID = imageResourceID;
        mCoordinates = coordinates;
        mOpenTimings = null;
    }

    // Getter Methods for the Location Class

    /***
     * Gets the name of the location
     * @return Name of the location
     */
    public String getmName() {
        return mName;
    }

    /***
     * Gets the brief description of the location
     * @return Brief Description of the location
     */
    public String getmDescription() {
        return mDescription;
    }

    /***
     * Gets the image resource ID of the location
     * @return Image Resource ID of the location
     */
    public int getmImageResourceID() {
        return mImageResourceID;
    }

    /***
     * Gets the longitude and latitude coordinates of the location
     * @return Map coordinates of the system
     */
    public float[] getmCoordinates() {
        return mCoordinates;
    }

    /***
     * Gets the Open timings of the location
     * @return Open timings of the location
     */
    public String getmOpenTimings() {
        return mOpenTimings;
    }
}
