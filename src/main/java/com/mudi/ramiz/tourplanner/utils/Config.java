package com.mudi.ramiz.tourplanner.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties properties = new Properties();
    private static Config config = null;

    private Config() {
        this.loadProperties();
    }

    private void loadProperties() {
        try {
            InputStream is = new FileInputStream("src/main/resources/tourplanner.properties");
            this.properties.load(is);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }

        return config;
    }

    public String getProperty(String data) {
        return this.properties.getProperty(data);
    }

    public String getSQLUserName() {
        return this.getProperty("dbUser");
    }

    public String getSQLPassword() {
        return this.getProperty("dbPassword");
    }

    public String getSQLUrl() {
        return this.getProperty("dbUrl");
    }
}
