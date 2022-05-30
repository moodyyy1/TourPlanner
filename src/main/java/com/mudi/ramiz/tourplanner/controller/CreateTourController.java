package com.mudi.ramiz.tourplanner.controller;

import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.provider.Provider;
import com.mudi.ramiz.tourplanner.ui.Alert;
import com.mudi.ramiz.tourplanner.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

public class CreateTourController {

    @FXML
    public TextField tourName;
    @FXML
    public TextField tourDescription;
    @FXML
    public TextField tourFrom;
    @FXML
    public TextField tourTo;
    @FXML
    public TextField transportType;
    @FXML
    public Button saveButton;

    public Stage stage;

    public static NewDataInterface newData;

    public static CreateTourController show(NewDataInterface newDataInterface) {
        FXMLLoader loader = new FXMLLoader(CreateTourController.class.getResource("/createTour.fxml"));
        Stage stage = new Stage();
        newData = newDataInterface;

        try {
            System.out.println(loader.getLocation());
            stage.setScene(new Scene(loader.load(), 800, 400));
        } catch (IOException e) {
            System.out.println("CreateTour Error");
            e.printStackTrace();
        }

        CreateTourController createTourController = loader.getController();

        createTourController.setStage(stage);

        stage.setTitle("Where are you going?");
        stage.show();
        return createTourController;
    }

    public TourModel getCurrentTourModel() {
        String tourName = this.tourName.getText();
        String tourDescription = this.tourDescription.getText();
        String tourFrom = this.tourFrom.getText();
        String tourTo = this.tourTo.getText();
        String tourTransportType = this.transportType.getText();

        return new TourModel(UUID.randomUUID(), tourName, tourDescription, tourFrom, tourTo, tourTransportType);
    }

    public void saveTour() {
        TourModel tourModel = getCurrentTourModel();
        if (Utils.validateData(tourModel)) {
            Provider.getTourDao().addTour(tourModel);
            newData.newData();
            closeWindow();
        } else {
            Alert.missingDataForSaving().show();
        }
    }

    public void closeWindow() {
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}