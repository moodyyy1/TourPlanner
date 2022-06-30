package com.mudi.ramiz.tourplanner.database;

import com.mudi.ramiz.tourplanner.models.TourLogModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

import static com.mudi.ramiz.tourplanner.utils.Utils.LOG_TYPE.ERROR;
import static com.mudi.ramiz.tourplanner.utils.Utils.LOG_TYPE.INFO;
import static com.mudi.ramiz.tourplanner.utils.Utils.printText;

public class LogDao implements LogDaoInterface {

    private static final String DB_CREATE_LOG = "INSERT INTO log_data (logUUID , tourUUID, logDate, tourComment, tourDifficulty, tourTotalTime , tourRating) values(?, ?, ?, ?, ?, ?, ?)";
    private static final String DB_GET_LOG = "SELECT * FROM log_data WHERE logUUID = ?";
    private static final String DB_GET_ALL_LOGS = "SELECT * FROM log_data";
    private static final String DB_REMOVE_LOG = "DELETE FROM log_data WHERE logUUID = ?";
    private static final String DB_MODIFY_LOG = "UPDATE log_data SET tourComment = ?, tourDifficulty = ?, tourRating = ? WHERE logUUID = ?";

    public Database database;

    public LogDao(Database database) {
        this.database = database;
    }

    @Override
    public void createLog(TourLogModel tourLogModel) {

        try {

            database.establishConnection();

            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_CREATE_LOG);

            preparedStatement.setString(1, tourLogModel.getLogID().toString());
            preparedStatement.setString(2, tourLogModel.getTourID().toString());
            preparedStatement.setString(3, tourLogModel.getLogDate().toString());
            preparedStatement.setString(4, tourLogModel.getTourComment());
            preparedStatement.setString(5, tourLogModel.getTourDifficulty());
            preparedStatement.setFloat(6, tourLogModel.getTourTotalTime());
            preparedStatement.setInt(7, tourLogModel.getTourRatingOutOf10());

            preparedStatement.execute();
            preparedStatement.close();
            database.closeConnection();

            printText(INFO, "LOG: '" + tourLogModel.getLogID() + "' Create successfully");

        } catch (
                SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");

        }
    }


    @Override
    public void removeLog(UUID logUUID) {

        try {
            database.establishConnection();

            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_REMOVE_LOG);
            preparedStatement.setString(1, logUUID.toString());

            preparedStatement.execute();
            preparedStatement.close();
            database.closeConnection();

            printText(INFO, "LOG: '" + logUUID + "' removed successfully");

        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }

    }

    @Override
    public void modifyLog(UUID logUUID, TourLogModel tourLogModel) {

        try {
            database.establishConnection();
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_MODIFY_LOG);

            preparedStatement.setString(1, tourLogModel.getTourComment());
            preparedStatement.setString(2, tourLogModel.getTourDifficulty());
            preparedStatement.setInt(3, tourLogModel.getTourRatingOutOf10());
            preparedStatement.setString(4, logUUID.toString());

            preparedStatement.execute();
            preparedStatement.close();

            database.closeConnection();


        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }

    }

    @Override
    public TourLogModel getLog(UUID logUUID) {
        try {
            database.establishConnection();

            PreparedStatement preparedStatement = database.getConnection().prepareStatement(DB_GET_LOG);
            preparedStatement.setString(1, logUUID.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                UUID pLogUUID = UUID.fromString(resultSet.getString("logUUID"));
                UUID pTourUUID = UUID.fromString(resultSet.getString("tourUUID"));
                LocalDate pLogDate = LocalDate.parse(resultSet.getString("logDate"));
                String pTourComment = resultSet.getString("tourComment");
                String pTourDifficulty = resultSet.getString("tourDifficulty");
                Float pTourTime = resultSet.getFloat("tourTotalTime");
                Integer pTourRating = resultSet.getInt("tourRating");

                resultSet.close();
                preparedStatement.close();
                database.closeConnection();

                printText(INFO, "LOG: '" + pLogUUID + "' successfully loaded!");

                return new TourLogModel(pTourUUID, pLogUUID, pLogDate, pTourComment, pTourDifficulty, pTourTime, pTourRating);
            } else {
                printText(ERROR, "Database error (The User does not exist!)");
            }

        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }

        return null;
    }
}
