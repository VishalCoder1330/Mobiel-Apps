package com.example.vishal_parekh_comp304_assign5;

import java.io.Serializable;
import java.util.List;

public class Cities implements Serializable {

    private String names;
    private double lat;
    private double lon;
    private List<Theaters> theaters;

    public List<Theaters> getTheaters() {
        return theaters;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setTheaters(List<Theaters> theaters) {
        this.theaters = theaters;
    }

    public Cities(String names , double lat, double lon, List<Theaters> theaters) {
        this.names = names;
        this.lat = lat;
        this.lon = lon;
        this.theaters = theaters;
    }

}
