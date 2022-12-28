package com.example.vishal_parekh_comp304_assign5;

import java.io.Serializable;

public class Theaters  implements Serializable {

    private String theaterName;
    private String address;
    private String contact;
    private String websiteURL;
    private double lat;
    private double lon;

    public String getTheaterName() {
        return theaterName;
    }

    public String getAddress() {
        return address;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getContact() {
        return contact;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Theaters(String theaterName, String address, String contact, String websiteURL, double lat, double lon) {
        this.theaterName = theaterName;
        this.address = address;
        this.contact = contact;
        this.websiteURL = websiteURL;
        this.lat = lat;
        this.lon = lon;
    }
}
