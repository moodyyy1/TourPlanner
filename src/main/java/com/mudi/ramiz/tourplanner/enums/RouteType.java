package com.mudi.ramiz.tourplanner.enums;

public enum RouteType {

    FASTEST("fastest"),
    SHORTEST("shortest"),
    PEDESTRIAN("pedestrian"),
    BICYCLE("bicycle");

    private final String name;

    public String getName() {
        return name;
    }

    RouteType(String name) {
        this.name = name;
    }
}
