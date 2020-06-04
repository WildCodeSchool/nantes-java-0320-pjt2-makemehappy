package com.wildcodeschool.makemehappy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ThemeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String findThemeById(int idTheme) {

        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
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
