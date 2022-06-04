package com.mudi.ramiz.tourplanner.viewmodel;

import com.mudi.ramiz.tourplanner.controller.NewDataInterface;
import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.service.TourService;
import com.mudi.ramiz.tourplanner.service.TourServiceInterface;
import com.mudi.ramiz.tourplanner.utils.DataAPI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel implements ChangeListener<TourModel> {

    private TourServiceInterface tourService;
    private NewDataInterface newDataInterface;
    private double imageWidth, imageHeight;

    public MainViewModel(NewDataInterface newDataInterface, double imageWidth, double imageHeight) {
        tourService = new TourService();

        this.newDataInterface = newDataInterface;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
    }

    public ObservableList<TourModel> getTours() {
        ObservableList<TourModel> observableList = FXCollections.observableArrayList();

        observableList.addAll(this.tourService.getAllTours());
        return observableList;
    }

    //TODO DYNAMIC IMAGE SIZING

    private void acquireImageForTour(TourModel tourModel) {
        String tourFrom = tourModel.getTourFromLocation();
        String tourTo = tourModel.getTourToLocation();

        imageWidth = 200;
        imageHeight = 300;

        newDataInterface.clickedTour(DataAPI.getMapImage(tourFrom, tourTo, imageHeight, imageWidth));
    }

    @Override
    public void changed(ObservableValue<? extends TourModel> observableValue, TourModel oldTour, TourModel newTour) {
        acquireImageForTour(newTour);
    }
}
