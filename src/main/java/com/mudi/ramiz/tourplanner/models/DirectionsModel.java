package com.mudi.ramiz.tourplanner.models;

public class DirectionsModel {

    private String image;
    private Float distance;
    private Float time;

    public DirectionsModel(String image, Float distance, Float time) {
        this.image = image;
        this.distance = distance;
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DirectionsModel{" +
                "image='" + image + '\'' +
                ", distance=" + distance +
                ", time=" + time +
                '}';
    }
}
