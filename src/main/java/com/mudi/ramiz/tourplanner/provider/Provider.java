package com.mudi.ramiz.tourplanner.provider;

import com.mudi.ramiz.tourplanner.database.Database;
import com.mudi.ramiz.tourplanner.database.TourDao;
import com.mudi.ramiz.tourplanner.database.TourDaoInterface;

public class Provider {

    private static TourDaoInterface tourDAO;

    public Provider() {
        Database database = new Database();
        tourDAO = new TourDao(database);
    }

    public static TourDaoInterface getTourDao() {
        return tourDAO;
    }
}