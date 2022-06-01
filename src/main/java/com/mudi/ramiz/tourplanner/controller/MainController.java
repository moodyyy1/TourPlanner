package com.mudi.ramiz.tourplanner.controller;

import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class MainController implements NewDataInterface {

    @FXML
    public TableView<TourModel> tourList;

    @FXML
    public Button createButton;

    private final MainViewModel mainViewModel;

    public MainController() {
        tourList = new TableView<>();
        mainViewModel = new MainViewModel();
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
        this.tourList.setItems(this.mainViewModel.getTours());
        this.tourList.refresh();
    }
}
