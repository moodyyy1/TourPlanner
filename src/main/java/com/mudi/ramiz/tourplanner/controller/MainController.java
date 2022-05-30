package com.mudi.ramiz.tourplanner.controller;

import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.provider.Provider;
import com.mudi.ramiz.tourplanner.utils.Utils;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class MainController implements NewDataInterface {

    @FXML
    public TableView<TourModel> tourList;

    @FXML
    public Button createButton;

    public MainController() {
        tourList = new TableView<>();
    }

    @FXML
    public void initialize() {
        initializeTourList();
    }

    private void initializeTourList() {
        newData();
    }

    public void createTour() {
        CreateTourController.show(this);
    }

    @Override
    public void newData() {
        ObservableList<TourModel> tourModelObservableList = Utils.getObservableFromList(Provider.getTourDao().getAllTours());

        this.tourList.setItems(tourModelObservableList);
        this.tourList.refresh();
    }
}
