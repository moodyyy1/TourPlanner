package com.mudi.ramiz.tourplanner.controller;

import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController implements NewDataInterface {

    @FXML
    public TableView<TourModel> tourList;

    @FXML
    public Button createButton;

    @FXML
    public ImageView tourImage;

    private MainViewModel mainViewModel;

    public MainController() {
        tourList = new TableView<>();
    }

    @FXML
    public void initialize() {
        mainViewModel = new MainViewModel(this, tourImage.getFitWidth(), tourImage.getFitHeight());
        initializeTourList();
    }

    private void initializeTourList() {
        newData();
        initClickListener();
    }

    private void initClickListener() {
        this.tourList.getSelectionModel().selectedItemProperty().addListener(this.mainViewModel);
    }

    public void createTour() {
        CreateTourController.show(this);
    }

    @Override
    public void newData() {
        this.tourList.setItems(this.mainViewModel.getTours());
        this.tourList.refresh();
    }

    @Override
    public void clickedTour(String image) {
        Image fxImage = new Image(image);
        System.out.println(image);
        this.tourImage.setImage(fxImage);
    }
}
