package com.wildcodeschool.makemehappy.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThemeRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public String findThemeById(int idTheme) {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT * FROM theme WHERE id_theme = ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, idTheme);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {

                return resultSet.getString("background");
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
