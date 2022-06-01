package com.mudi.ramiz.tourplanner.viewmodel;

import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.service.TourService;
import com.mudi.ramiz.tourplanner.service.TourServiceInterface;

public class CreateTourViewModel {

    private TourServiceInterface tourService;

    public CreateTourViewModel() {
        tourService = new TourService();
    }

    public void saveTour(TourModel tourModel) {
        tourService.addTour(tourModel);
    }

}
