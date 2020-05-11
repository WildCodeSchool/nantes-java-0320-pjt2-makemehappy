package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.model.Avatar;
import com.wildcodeschool.makemehappy.model.Gift;
import com.wildcodeschool.makemehappy.model.GiftList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GiftListRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public List<GiftList> findAllWishList() {

        List<GiftList> dashboard = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT * FROM gift_list;";
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

                GiftList giftList = new GiftList();

                giftList.setIdGiftList(idGiftList);
                giftList.setTitle(title);
                giftList.setDeadLine(deadLine);
                giftList.setShareLink(shareLink);
                giftList.setDescription(description);
                giftList.setNotifyGift(notifyGift);
                giftList.setIdUser(idUser);
                giftList.setIdTheme(idTheme);

                dashboard.add(giftList);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dashboard;
    }
}
