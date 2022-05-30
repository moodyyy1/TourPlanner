package com.mudi.ramiz.tourplanner.utils;

import com.mudi.ramiz.tourplanner.models.TourModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Utils {

    /**
     * gets expanded in the coming days
     */

    public enum LOG_TYPE {
        ERROR,
        INFO,
        WARN;
    }

    public static void printText(LOG_TYPE printType, String message) {
        System.out.println("[TOUR_PLANNER/" + printType.name() + "]: " + message);
    }

    public static boolean validateData(TourModel tourModel) {
        return !tourModel.getTourName().isEmpty() && !tourModel.getTourDescription().isEmpty() &&
                !tourModel.getTourFromLocation().isEmpty() && !tourModel.getTourToLocation().isEmpty() &&
                !tourModel.getTourTransportType().isEmpty();
    }

    public static ObservableList<TourModel> getObservableFromList(List<TourModel> tourModelList) {
        ObservableList<TourModel> observableList = FXCollections.observableArrayList();

        observableList.addAll(tourModelList);
        return observableList;
    }
}
