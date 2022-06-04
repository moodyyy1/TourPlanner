package com.mudi.ramiz.tourplanner.models;

import java.util.UUID;

public class TourModel {

    public UUID tourUUID;
    public String tourName;
    public String tourDescription;
    public String tourFromLocation;
    public String tourToLocation;
    public String tourTransportType;
    public Float tourTransportDistance;
    public Float tourEstimatedTime;
    public String tourRoutInformation;
    
    public TourModel() {

    }

    public TourModel(UUID tourUUID, String tourName, String tourDescription, String tourFromLocation, String tourToLocation, String tourTransportType) {
        this.tourUUID = tourUUID;
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.tourFromLocation = tourFromLocation;
        this.tourToLocation = tourToLocation;
        this.tourTransportType = tourTransportType;
    }

    public UUID getTourUUID() {
        return tourUUID;
    }

    public void setTourUUID(UUID tourUUID) {
        this.tourUUID = tourUUID;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public String getTourFromLocation() {
        return tourFromLocation;
    }

    public void setTourFromLocation(String tourFromLocation) {
        this.tourFromLocation = tourFromLocation;
    }

    public String getTourToLocation() {
        return tourToLocation;
    }

    public void setTourToLocation(String tourToLocation) {
        this.tourToLocation = tourToLocation;
    }

    public String getTourTransportType() {
        return tourTransportType;
    }

    public void setTourTransportType(String tourTransportType) {
        this.tourTransportType = tourTransportType;
    }

    public Float getTourTransportDistance() {
        return tourTransportDistance;
    }

    public void setTourTransportDistance(Float tourTransportDistance) {
        this.tourTransportDistance = tourTransportDistance;
    }

    public Float getTourEstimatedTime() {
        return tourEstimatedTime;
    }

    public void setTourEstimatedTime(Float tourEstimatedTime) {
        this.tourEstimatedTime = tourEstimatedTime;
    }

    public String getTourRoutInformation() {
        return tourRoutInformation;
    }

    public void setTourRoutInformation(String tourRoutInformation) {
        this.tourRoutInformation = tourRoutInformation;
    }

    @Override
    public String toString() {
        return "TourModel{" +
                "tourUUID=" + tourUUID +
                ", tourName='" + tourName + '\'' +
                ", tourDescription='" + tourDescription + '\'' +
                ", tourFromLocation='" + tourFromLocation + '\'' +
                ", tourToLocation='" + tourToLocation + '\'' +
                ", tourTransportType='" + tourTransportType + '\'' +
                ", tourTransportDistance=" + tourTransportDistance +
                ", tourEstimatedTime=" + tourEstimatedTime +
                ", tourRoutInformation='" + tourRoutInformation + '\'' +
                '}';
    }
}
