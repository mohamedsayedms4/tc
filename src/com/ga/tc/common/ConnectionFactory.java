/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ga.tc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

   

    private static String driver, url, user, password;

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        ConnectionFactory.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConnectionFactory.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        ConnectionFactory.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConnectionFactory.password = password;
    }
    
    
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("com.ga.tc.common.db");
        driver = bundle.getString("db.driver");
        url = bundle.getString("db.url");
        user = bundle.getString("db.user");
        password = bundle.getString("db.password");
    }
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    
}

    
