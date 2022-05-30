package com.mudi.ramiz.tourplanner.database;

import com.mudi.ramiz.tourplanner.models.TourModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mudi.ramiz.tourplanner.utils.Utils.LOG_TYPE.ERROR;
import static com.mudi.ramiz.tourplanner.utils.Utils.LOG_TYPE.INFO;
import static com.mudi.ramiz.tourplanner.utils.Utils.printText;

public class TourDao implements TourDaoInterface {

    private static final String DB_ADD_TOUR = "INSERT INTO tour_data (tourUUID, tourName, tourDescription, tourFromLocation, tourToLocation, tourTransportType) values(?, ?, ?, ?, ?, ?)";
    private static final String DB_GET_TOUR = "SELECT * FROM tour_data WHERE tourUUID = ?";
    private static final String DB_GET_ALL_TOURS = "SELECT * FROM tour_data";
    private static final String DB_REMOVE_TOUR = "DELETE FROM tour_data WHERE tourUUID = ?";

    public Database database;

    public TourDao(Database database) {
        this.database = database;
    }

    @Override
    public void addTour(TourModel tourModel) {
        try {
            database.establishConnection();

            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_ADD_TOUR);

            preparedStatement.setString(1, tourModel.getTourUUID().toString());
            preparedStatement.setString(2, tourModel.getTourName());
            preparedStatement.setString(3, tourModel.getTourDescription());
            preparedStatement.setString(4, tourModel.getTourFromLocation());
            preparedStatement.setString(5, tourModel.getTourToLocation());
            preparedStatement.setString(6, tourModel.getTourTransportType());

            preparedStatement.execute();
            preparedStatement.close();
            database.closeConnection();

            printText(INFO, "TOUR: '" + tourModel.getTourName() + "' added successfully");

        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }
    }

    @Override
    public void removeTour(UUID tourUUID) {
        try {
            database.establishConnection();

            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_REMOVE_TOUR);
            preparedStatement.setString(1, tourUUID.toString());

            preparedStatement.execute();
            preparedStatement.close();
            database.closeConnection();

            printText(INFO, "TOUR: '" + tourUUID + "' removed successfully");

        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }
    }

    @Override
    public List<TourModel> getAllTours() {
        try {
            database.establishConnection();

            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_GET_ALL_TOURS);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet);

            List<TourModel> allTours = new ArrayList<>();

            while (resultSet.next()) {
                UUID tourUUID = UUID.fromString(resultSet.getString("tourUUID"));
                TourModel tourModel = getTour(tourUUID);
                allTours.add(tourModel);
            }
            return allTours;

        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }
        return null;
    }

    @Override
    public TourModel getTour(UUID tourUUID) {
        try {
            database.establishConnection();

            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_GET_TOUR);
            preparedStatement.setString(1, tourUUID.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                UUID pTourUUID = UUID.fromString(resultSet.getString("tourUUID"));
                String pTourName = resultSet.getString("tourName");
                String pTourDescription = resultSet.getString("tourDescription");
                String pTourLocationFrom = resultSet.getString("tourFromLocation");
                String pTourLocationTo = resultSet.getString("tourToLocation");
                String pTransportType = resultSet.getString("tourTransportType");

                resultSet.close();
                preparedStatement.close();
                database.closeConnection();

                printText(INFO, "TOUR: '" + pTourName + "' successfully loaded!");

                return new TourModel(pTourUUID, pTourName, pTourDescription, pTourLocationFrom, pTourLocationTo, pTransportType);
            } else {
                printText(ERROR, "Database error (The User does not exist!)");
            }

        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }

        return null;
    }
}
