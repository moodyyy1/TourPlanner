package com.mudi.ramiz.tourplanner.provider;

import com.mudi.ramiz.tourplanner.database.*;

public class Provider {

    private static TourDaoInterface tourDAO;
    private static LogDaoInterface logDAO;

    public Provider() {
        Database database = new Database();
        tourDAO = new TourDao(database);
        logDAO = new LogDao(database);
    }

    public static TourDaoInterface getTourDao() {
        return tourDAO;
    }

    public static LogDaoInterface getLogDAO() {
        return logDAO;
    }
}