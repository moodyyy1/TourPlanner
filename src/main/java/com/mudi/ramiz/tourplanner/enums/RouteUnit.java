package com.mudi.ramiz.tourplanner.enums;

public enum RouteUnit {

    MILES("m"),
    KILO_METERS("k");

    private final String name;

    public String getName() {
        return name;
    }

    RouteUnit(String name) {
        this.name = name;
    }

}
