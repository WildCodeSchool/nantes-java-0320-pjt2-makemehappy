package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.entity.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AvatarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Avatar> findAll() {

        List<Avatar> avatarList = new ArrayList<>();

        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            String request = "SELECT * FROM avatar;";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                int id = resultSet.getInt("id_avatar");
                String path = resultSet.getString("name");
                Avatar newAvatar = new Avatar(id, path);
                avatarList.add(newAvatar);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avatarList;
    }

    public Avatar findById(int idSelected) {

        Avatar avatar = new Avatar();
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            String request = "SELECT * FROM avatar WHERE id_avatar = ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, idSelected);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");

            avatar.setId(idSelected);
            avatar.setName(name);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avatar;
    }
}
