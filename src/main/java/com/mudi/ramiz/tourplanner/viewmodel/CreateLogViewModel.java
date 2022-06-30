package com.mudi.ramiz.tourplanner.viewmodel;

import com.mudi.ramiz.tourplanner.models.TourLogModel;
import com.mudi.ramiz.tourplanner.service.LogService;
import com.mudi.ramiz.tourplanner.service.LogServiceInterface;

import java.util.UUID;

public class CreateLogViewModel {

    private final LogServiceInterface logService;
    private final UUID tourUUID;

    public CreateLogViewModel(UUID tourUUID) {
        logService = new LogService();

        this.tourUUID = tourUUID;
    }

    public void saveLog(TourLogModel logModel) {
        logModel.setTourID(tourUUID);

        logService.createLog(logModel);
    }
}
