package com.weather.model.weather;

public class Coordinate {

    private Double lon;
    private Double lat;

    public Coordinate() {}

    public Coordinate(Double lat, Double lon ) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}
