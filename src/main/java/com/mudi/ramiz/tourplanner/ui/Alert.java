package com.mudi.ramiz.tourplanner.ui;

import javafx.scene.control.Alert.AlertType;

import java.util.ResourceBundle;

public class Alert {
    private final AlertType alertType;
    private final String alertName;
    private final ResourceBundle resourceBundle;

    public Alert(AlertType alertType, String alertName) {
        this.alertType = alertType;
        this.alertName = alertName;
        this.resourceBundle = ResourceBundle.getBundle("tourPlannerAlerts");
    }

    public javafx.scene.control.Alert buildAlert() {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
        alert.setTitle(this.resourceBundle.getString(this.alertName + "AlertTitle.txt"));
        alert.setHeaderText(this.resourceBundle.getString(this.alertName + "AlertHeader.txt"));
        alert.setContentText(this.resourceBundle.getString(this.alertName + "AlertBody.txt"));

        return alert;
    }

    public static javafx.scene.control.Alert missingDataForSaving() {
        return new Alert(AlertType.WARNING, "missingDataForSaving").buildAlert();
    }
}
