package com.mudi.ramiz.tourplanner.service;

import com.mudi.ramiz.tourplanner.database.Database;
import com.mudi.ramiz.tourplanner.database.TourDao;
import com.mudi.ramiz.tourplanner.database.TourDaoInterface;
import com.mudi.ramiz.tourplanner.models.TourModel;

import java.util.List;
import java.util.UUID;

public class TourService implements TourServiceInterface {

    public static TourDaoInterface tourDao;

    public TourService() {
        tourDao = new TourDao(Database.getInstance());
    }

    @Override
    public void addTour(TourModel tourModel) {
        tourDao.addTour(tourModel);
    }

    @Override
    public void removeTour(UUID tourUUID) {
        tourDao.removeTour(tourUUID);
    }

    @Override
    public List<TourModel> getAllTours() {
        return tourDao.getAllTours();
    }

    @Override
    public TourModel getTour(UUID tourUUID) {
        return tourDao.getTour(tourUUID);
    }
}
