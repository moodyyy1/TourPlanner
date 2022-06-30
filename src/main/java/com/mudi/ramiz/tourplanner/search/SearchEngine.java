package com.mudi.ramiz.tourplanner.search;

import com.mudi.ramiz.tourplanner.models.TourLogModel;
import com.mudi.ramiz.tourplanner.models.TourModel;
import com.mudi.ramiz.tourplanner.service.LogService;
import com.mudi.ramiz.tourplanner.service.LogServiceInterface;
import com.mudi.ramiz.tourplanner.service.TourService;
import com.mudi.ramiz.tourplanner.service.TourServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    private final TourServiceInterface tourDAO;
    private final LogServiceInterface logDAO;

    public SearchEngine() {
        tourDAO = new TourService();
        logDAO = new LogService();
    }

    public List<TourModel> searchTourModels(String searchKey) {
        List<TourModel> tourList = tourDAO.getAllTours();

        return tourList.stream().filter((tour) -> tour.getTourName().toLowerCase().contains(searchKey.toLowerCase()) ||
                tour.getTourDescription().toLowerCase().contains(searchKey.toLowerCase())).collect(Collectors.toList());
    }

    public List<TourLogModel> searchTourLogModels(String searchKey) {
        List<TourLogModel> tourList = logDAO.getAllLogs();

        return tourList.stream().filter((log) -> log.getTourComment().toLowerCase().contains(searchKey.toLowerCase()) ||
                log.getLogDate().toString().contains(searchKey.toLowerCase())).collect(Collectors.toList());
    }
}
