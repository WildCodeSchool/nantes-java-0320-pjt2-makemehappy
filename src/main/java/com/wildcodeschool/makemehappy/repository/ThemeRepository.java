package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.util.JdbcSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThemeRepository {

    public String findThemeById(int idTheme) {

        try {
            Connection connection = JdbcSingleton.getInstance().getConnection();
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
