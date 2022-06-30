package com.mudi.ramiz.tourplanner.database;

import com.mudi.ramiz.tourplanner.utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.mudi.ramiz.tourplanner.utils.Utils.LOG_TYPE.ERROR;
import static com.mudi.ramiz.tourplanner.utils.Utils.LOG_TYPE.INFO;
import static com.mudi.ramiz.tourplanner.utils.Utils.printText;

/**
 * Diese Klasse ist dafür verantwortlich, die Verbindung zu PostgreSQL herzustellen, und alle Table zu erstellen, falls noch nicht gemacht
 */

public class Database {

    private final String sqlURL;
    private final String sqlUserName;
    private final String sqlUserPassword;
    private Connection connection;
    private static Database db = null;

    public Database() {
        this.sqlURL = Config.getInstance().getSQLUrl();
        this.sqlUserName = Config.getInstance().getSQLUserName();
        this.sqlUserPassword = Config.getInstance().getSQLPassword();

        try {
            testConnection();
        } catch (SQLException sqlException) {
            printText(ERROR, "Database error (" + sqlException.getMessage() + ")");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void testConnection() throws SQLException {
        if (establishConnection()) {
            printText(INFO, "Database successfully connected!");

            if (!connection.getMetaData().getTables(null, null, "tour_data", null).next()) {
                createTourTable();
            }
            if (!connection.getMetaData().getTables(null, null, "log_data", null).next()) {
                createLogTable();
            }
            closeConnection();
        }
    }

    public boolean establishConnection() {
        try {
            connection = DriverManager.getConnection(sqlURL, sqlUserName, sqlUserPassword);
            return true;
        } catch (SQLException sqlException) {
            printText(ERROR, "Database could not be connected (" + sqlException.getMessage() + ")");
            return false;
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            printText(ERROR, "Database Connection could not be closed (" + sqlException.getMessage() + ")");
        }
    }


    public void createTourTable() throws SQLException {
        establishConnection();

        Statement statement = connection.createStatement();
        String createUserSQLTable =
                "Create Table TOUR_DATA(" +
                        "tourUUID VARCHAR(36) PRIMARY KEY UNIQUE," +
                        "tourName TEXT NOT NULL," +
                        "tourDescription TEXT NOT NULL," +
                        "tourFromLocation TEXT NOT NULL," +
                        "tourToLocation TEXT NOT NULL," +
                        "tourTransportType TEXT NOT NULL)";

        statement.executeUpdate(createUserSQLTable);
        statement.close();
        printText(INFO, "Database table 'Tour_Data' successfully created!");

        closeConnection();
    }

    public void createLogTable() throws SQLException {
        establishConnection();

        Statement statement = connection.createStatement();
        String createUserSQLTable =
                "Create Table LOG_DATA(" +
                        "logUUID VARCHAR(36) PRIMARY KEY UNIQUE," +
                        "tourUUID VARCHAR(36)," +
                        "logDate TEXT NOT NULL," +
                        "tourComment TEXT NOT NULL," +
                        "tourDifficulty INTEGER NOT NULL," +
                        "tourTotalTime FLOAT NOT NULL," +
                        "tourRating INTEGER NOT NULL)";

        statement.executeUpdate(createUserSQLTable);
        statement.close();
        printText(INFO, "Database table 'Log_Data' successfully created!");

        closeConnection();
    }

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }

        return db;
    }
}