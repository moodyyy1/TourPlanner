package com.mudi.ramiz.tourplanner.service;

import com.mudi.ramiz.tourplanner.models.TourModel;

import java.util.List;
import java.util.UUID;

public interface TourServiceInterface {

    void addTour(TourModel tourModel);

    void removeTour(UUID tourUUID);

    List<TourModel> getAllTours();

    TourModel getTour(UUID tourUUID);
}
