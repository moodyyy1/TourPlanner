package com.mudi.ramiz.tourplanner.controller;

import com.mudi.ramiz.tourplanner.models.TourLogModel;
import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.viewmodel.MainViewModel;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.UUID;

public class MainController implements NewDataInterface {

    @FXML
    public TableView<TourModel> tourList;

    @FXML
    public TableView<TourLogModel> logList;

    @FXML
    public Button createButton;

    @FXML
    public ImageView tourImage;

    private MainViewModel mainViewModel;

    public MainController() {
        tourList = new TableView<>();
        logList = new TableView<>();
    }

    @FXML
    public void initialize() {
        mainViewModel = new MainViewModel(this, tourImage.getFitWidth(), tourImage.getFitHeight());
        initializeTourList();
    }

    private void initializeTourList() {
        newData();
        initClickListener();
        initializeTableViewContextMenu();
    }

    private void initClickListener() {
        this.tourList.getSelectionModel().selectedItemProperty().addListener(this.mainViewModel);
    }

    private void loadTourLogs(ObservableList<TourLogModel> tourLogModels) {
        this.logList.setItems(tourLogModels);
        this.tourList.refresh();
    }

    public void createTour() {
        CreateTourController.show(this);
    }

    @Override
    public void newData() {
        this.tourList.setItems(this.mainViewModel.getTours());
        this.tourList.refresh();

        if (this.tourList.getSelectionModel().getSelectedItem() != null) {
            loadTourLogs(this.mainViewModel.getLogs(getSelectedTour()));
        }
    }

    @Override
    public void clickedTour(String image) {
        Image fxImage = new Image(image);
        this.tourImage.setImage(fxImage);

        UUID uuid = getSelectedTour();
        loadTourLogs(this.mainViewModel.getLogs(uuid));
    }

    public UUID getSelectedTour() {
        return this.tourList.getSelectionModel().getSelectedItem().getTourUUID();
    }

    public void initializeTableViewContextMenu() {
        tourList.setRowFactory(
                tableView -> {
                    final TableRow<TourModel> row = new TableRow<>();
                    final ContextMenu rowMenu = new ContextMenu();
                    MenuItem editItem = new MenuItem("Create Tour-Log");
                    editItem.setOnAction(event -> CreateLogController.show(this, getSelectedTour()));

                    rowMenu.getItems().addAll(editItem);

                    row.contextMenuProperty().bind(
                            Bindings.when(row.emptyProperty())
                                    .then((ContextMenu) null)
                                    .otherwise(rowMenu));
                    return row;
                });
    }
}
