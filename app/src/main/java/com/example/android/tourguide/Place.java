package com.example.android.tourguide;

import android.location.Location;

/**
 * Created by ghataks on 11/4/2017.
 */

public class Place {

    //Strings used to store place names, their description and location object
    private int mResourceNameOfPlace;
    private int mResourceDescritption;
    private int mResourceImage;
    Location location;

    //Constructor with three parameters name, description and image
    public Place(int nameOfPlace, int description, int imageID) {
        mResourceNameOfPlace = nameOfPlace;
        mResourceDescritption = description;
        mResourceImage = imageID;
    }

    //Constructor with five parameters name, description, image, latitude and longitude of the place.
    public Place(int nameOfPlace, int description, int imageID, double latitude, double longitude) {
        mResourceNameOfPlace = nameOfPlace;
        mResourceDescritption = description;
        mResourceImage = imageID;
        setLocation(latitude, longitude);
    }

    //Getter method to get place name
    public int getmNameOfPlace() {
        return mResourceNameOfPlace;
    }
    //Getter method to get description

    public int getmDescritption() {
        return mResourceDescritption;
    }

    //Getter method to get image resource
    public int getmResourceImage() {
        return mResourceImage;
    }

    //Getter method to return latitude
    public double getResourceLatitude() {
        return location.getLatitude();
    }

    //Getter method to return longitude
    public double getResourceLongitude() {
        return location.getLongitude();
    }

    /**
     * Method to set location object
     *
     * @param latitude  value of the co-ordinates
     * @param longitude value of the co-ordinates
     **/
    public void setLocation(double latitude, double longitude) {
        location = new Location("Tour Guide");
        location.setLatitude(latitude);
        location.setLongitude(longitude);
    }
}
