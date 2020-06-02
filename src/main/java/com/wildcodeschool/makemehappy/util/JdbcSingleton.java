package com.wildcodeschool.makemehappy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingleton {

    private static final String URL_DATABASE = "jdbc:mysql://51.68.18.102:3306/nantes_java_0320_pjt2_makemehappy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    private static JdbcSingleton instance = null;
    private Connection connection = null;

    private JdbcSingleton() {

    }

    public static JdbcSingleton getInstance() {

        if (instance == null) {
            instance = new JdbcSingleton();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    URL_DATABASE, SQL_USER, SQL_PASSWORD
            );
        }
        return connection;
    }
}

