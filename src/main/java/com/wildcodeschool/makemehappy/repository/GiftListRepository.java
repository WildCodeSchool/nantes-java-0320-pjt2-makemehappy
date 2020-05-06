package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.model.Avatar;
import com.wildcodeschool.makemehappy.model.Gift;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GiftListRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public List<Gift> findAllGift() {

        List<Gift> giftList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT * FROM giftList;";
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                int idGiftList = resultSet.getInt("id_gift_list");
                String title = resultSet.getString("title");
                Date deadLine = resultSet.getDate("dead_line");;
                String shareLink = resultSet.getString("share_link");;
                String description = resultSet.getString("description");;
                boolean notifyGift= resultSet.getBoolean("notify_gift");
                int idUser = resultSet.getInt("id_user");
                int idTheme = resultSet.getInt("id_theme");

                Gift gift = new Gift();
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return giftList;
    }
}
