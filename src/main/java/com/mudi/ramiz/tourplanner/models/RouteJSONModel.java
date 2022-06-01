package com.mudi.ramiz.tourplanner.models;

import java.util.List;

public class RouteJSONModel {

    public List<String> locations;
    public RouteOptionModel options;

    public RouteJSONModel() {

    }

    public RouteJSONModel(List<String> locations, RouteOptionModel routeOptionModel) {
        this.locations = locations;
        this.options = routeOptionModel;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public RouteOptionModel getOptions() {
        return options;
    }

    public void setOptions(RouteOptionModel options) {
        this.options = options;
    }
}
