package com.ga.tc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A factory class for managing database connections.
 * Handles loading configuration and establishing JDBC connections.
 * 
 * Author: Mohamed Sayed (modified)
 */
public class ConnectionFactory {
    
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String CONFIG_FILE = "com.ga.tc.common.db"; // Resource bundle path

    private static String driver, url, user, password;

    // Static block to load DB settings from the properties file when the class is loaded
    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE);
            driver = bundle.getString("db.driver");
            url = bundle.getString("db.url");
            user = bundle.getString("db.user");
            password = bundle.getString("db.password");

            // Load JDBC driver class
            Class.forName(driver);
            LOGGER.log(Level.INFO, "JDBC driver loaded successfully: {0}", driver);
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Failed to load JDBC driver", ex);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error initializing ConnectionFactory", ex);
        }
    }

    /**
     * Get the JDBC driver name.
     * @return the driver class name.
     */
    public static String getDriver() {
        return driver;
    }

    /**
     * Set the JDBC driver class name.
     * @param driverClass the driver class to set.
     */
    public static void setDriver(String driverClass) {
        ConnectionFactory.driver = driverClass;
    }

    /**
     * Get the database URL.
     * @return the JDBC URL.
     */
    public static String getUrl() {
        return url;
    }

    /**
     * Set the database URL.
     * @param dbUrl the JDBC URL to set.
     */
    public static void setUrl(String dbUrl) {
        ConnectionFactory.url = dbUrl;
    }

    /**
     * Get the database username.
     * @return the username.
     */
    public static String getUser() {
        return user;
    }

    /**
     * Set the database username.
     * @param dbUser the username to set.
     */
    public static void setUser(String dbUser) {
        ConnectionFactory.user = dbUser;
    }

    /**
     * Get the database password.
     * @return the password.
     */
    public static String getPassword() {
        return password;
    }

    /**
     * Set the database password.
     * @param dbPassword the password to set.
     */
    public static void setPassword(String dbPassword) {
        ConnectionFactory.password = dbPassword;
    }

    /**
     * Create and return a new database connection.
     * 
     * @return a new Connection instance.
     * @throws SQLException if connection fails.
     */
    public static Connection createConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            LOGGER.log(Level.FINE, "New database connection established");
            return conn;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Failed to create database connection", ex);
            throw ex;
        }
    }

    /**
     * Safely close an existing database connection.
     * 
     * @param connection the Connection to close.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    LOGGER.log(Level.FINE, "Database connection closed");
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.WARNING, "Error while closing database connection", ex);
            }
        }
    }
}
