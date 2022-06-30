package com.mudi.ramiz.tourplanner.service;

import com.mudi.ramiz.tourplanner.database.LogDaoInterface;
import com.mudi.ramiz.tourplanner.models.TourLogModel;

import java.util.UUID;

public class LogService implements LogServiceInterface {

    public static LogDaoInterface logDAO;

    @Override
    public void createLog(TourLogModel tourLogModel) {
        logDAO.createLog(tourLogModel);
    }

    @Override
    public void removeLog(UUID logUUID) {
        logDAO.removeLog(logUUID);
    }

    @Override
    public void modifyLog(UUID logUUID, TourLogModel tourLogModel) {
        logDAO.modifyLog(logUUID, tourLogModel);
    }

    @Override
    public TourLogModel getLog(UUID logUUID) {
        return logDAO.getLog(logUUID);
    }
}
