package com.mudi.ramiz.tourplanner.models;

import java.time.LocalDate;
import java.util.UUID;

public class TourLogModel {

    private UUID tourID;
    private UUID logID;
    private LocalDate logDate;
    private String tourComment;
    private String tourDifficulty;
    private Float tourTotalTime;
    private Integer tourRatingOutOf10;

    public TourLogModel(UUID tourID, UUID logID, LocalDate logDate, String tourComment, String tourDifficulty, Float tourTotalTime, Integer tourRatingOutOf10) {
        this.tourID = tourID;
        this.logID = logID;
        this.logDate = logDate;
        this.tourComment = tourComment;
        this.tourDifficulty = tourDifficulty;
        this.tourTotalTime = tourTotalTime;
        this.tourRatingOutOf10 = tourRatingOutOf10;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public String getTourComment() {
        return tourComment;
    }

    public void setTourComment(String tourComment) {
        this.tourComment = tourComment;
    }

    public String getTourDifficulty() {
        return tourDifficulty;
    }

    public void setTourDifficulty(String tourDifficulty) {
        this.tourDifficulty = tourDifficulty;
    }

    public Float getTourTotalTime() {
        return tourTotalTime;
    }

    public void setTourTotalTime(Float tourTotalTime) {
        this.tourTotalTime = tourTotalTime;
    }

    public Integer getTourRatingOutOf10() {
        return tourRatingOutOf10;
    }

    public void setTourRatingOutOf10(Integer tourRatingOutOf10) {
        this.tourRatingOutOf10 = tourRatingOutOf10;
    }

    public UUID getLogID() {
        return logID;
    }

    public void setLogID(UUID logID) {
        this.logID = logID;
    }

    public UUID getTourID() {
        return tourID;
    }

    public void setTourID(UUID tourID) {
        this.tourID = tourID;
    }
}
