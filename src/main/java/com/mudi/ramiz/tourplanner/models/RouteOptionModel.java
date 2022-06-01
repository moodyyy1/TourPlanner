package com.mudi.ramiz.tourplanner.models;

public class RouteOptionModel {

    public String unit;
    public String routeType;
    public String locale;

    public RouteOptionModel() {

    }

    public RouteOptionModel(String unit, String routeType, String locale) {
        this.unit = unit;
        this.routeType = routeType;
        this.locale = locale;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
