package com.mudi.ramiz.tourplanner.viewmodel;

import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.service.TourService;
import com.mudi.ramiz.tourplanner.service.TourServiceInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

    private TourServiceInterface tourService;

    public MainViewModel() {
        tourService = new TourService();
    }

    public ObservableList<TourModel> getTours() {
        ObservableList<TourModel> observableList = FXCollections.observableArrayList();

        observableList.addAll(this.tourService.getAllTours());
        return observableList;
    }
}
