package com.example.android.project6;

/**
 * Created by Edvinas on 28/05/2017.
 */

public class Place {

    private String name;
    private String description;
    private int picture;
    private int thumbnail;
    private String address;

    public Place(String name, String description, int thumbnail, int picture, String address) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.picture = picture;
        this.address = address;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() { return description;}
    public void setDescription(String description) {this.description = description;}

    public int getPicture() {return picture;}
    public void setPicture(int picture) {this.picture = picture;}

    public int getThumbnail() {return thumbnail;}
    public void setThumbnail(int thumbnail) {this.thumbnail = thumbnail;}

    public String getAddress() {return address;}
    public void setAddress(String picture) {this.address = address;}
}
