module com.example.tpfht {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;


    opens com.mudi.ramiz.tourplanner to javafx.fxml;
    exports com.mudi.ramiz.tourplanner;
    exports com.mudi.ramiz.tourplanner.controller;
    opens com.mudi.ramiz.tourplanner.controller to javafx.fxml;
    exports com.mudi.ramiz.tourplanner.ui;
    opens com.mudi.ramiz.tourplanner.ui to javafx.fxml;
    exports com.mudi.ramiz.tourplanner.models;
}