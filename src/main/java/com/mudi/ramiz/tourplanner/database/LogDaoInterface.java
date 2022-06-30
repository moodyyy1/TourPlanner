package com.mudi.ramiz.tourplanner.database;

import com.mudi.ramiz.tourplanner.models.TourLogModel;

import java.util.UUID;

public interface LogDaoInterface {

    void createLog(TourLogModel tourLogModel);

    void removeLog(UUID logUUID);

    void modifyLog(UUID logUUID, TourLogModel tourLogModel);

    TourLogModel getLog(UUID logUUID);

}
