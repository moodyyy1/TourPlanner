package com.mudi.ramiz.tourplanner.controller;

import com.mudi.ramiz.tourplanner.models.TourLogModel;
import com.mudi.ramiz.tourplanner.ui.Alert;
import com.mudi.ramiz.tourplanner.utils.Utils;
import com.mudi.ramiz.tourplanner.viewmodel.CreateLogViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class CreateLogController {

    @FXML
    public TextField tourComment;
    @FXML
    public TextField logDate;
    @FXML
    public TextField tourDifficulty;
    @FXML
    public TextField tourRating;
    @FXML
    public TextField tourTotalTime;
    @FXML
    public Button saveLogButton;

    public Stage stage;

    public static CreateLogViewModel createLogViewModel;

    public static NewDataInterface newData;


    public static CreateLogController show(NewDataInterface newDataInterface, UUID tourUUID) {
        FXMLLoader loader = new FXMLLoader(CreateLogController.class.getResource("/createLog.fxml"));
        Stage stage = new Stage();
        createLogViewModel = new CreateLogViewModel(tourUUID);
        newData = newDataInterface;

        try {
            System.out.println(loader.getLocation());
            stage.setScene(new Scene(loader.load(), 800, 400));
        } catch (IOException e) {
            System.out.println("CreateTour Error");
            e.printStackTrace();
        }

        CreateLogController createTourController = loader.getController();

        createTourController.setStage(stage);

        stage.setTitle("How was your tour? Rate it :)");
        stage.show();
        return createTourController;
    }

    public TourLogModel getCurrentTourLogModel() {
        String tourComment = this.tourComment.getText();
        String tourDifficulty = this.tourDifficulty.getText();
        Integer tourRating = Integer.parseInt(this.tourRating.getText());
        Float tourTotalTime = Float.parseFloat(this.tourTotalTime.getText());

        //TODO Parse LocalDate from textFields

        LocalDate logDate = LocalDate.now();

        return new TourLogModel(null, UUID.randomUUID(), logDate, tourComment, tourDifficulty, tourTotalTime, tourRating);
    }

    public void saveLog() {
        TourLogModel tourLogModel = getCurrentTourLogModel();
        if (Utils.validateData(tourLogModel)) {
            createLogViewModel.saveLog(tourLogModel);
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