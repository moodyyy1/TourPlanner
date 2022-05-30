package com.mudi.ramiz.tourplanner;

import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.provider.Provider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public class TourPlanner extends Application {

    private Provider provider;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TourPlanner.class.getResource("/mainScreen.fxml"));

        provider = new Provider();
        Scene scene = new Scene(fxmlLoader.load());

        //     DataAPI.getDirectionsModel("Germany", "POLAND");

        stage.setTitle("FHTW Tourplanner!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        launch();
    }

    public Provider getProvider() {
        return provider;
    }

    public void testCase() {
        Provider.getTourDao().addTour(new TourModel(UUID.randomUUID(), "Mallorca", "hot", "Germany", "Mallorca", "BUS"));
        System.out.println(Provider.getTourDao().getTour(UUID.fromString("d717163e-8ac8-47c6-a9ff-5d9b59b38968")).getTourName());
        Provider.getTourDao().removeTour(UUID.fromString("d717163e-8ac8-47c6-a9ff-5d9b59b38968"));
        System.out.println(Arrays.toString(Provider.getTourDao().getAllTours().toArray()));
    }
}