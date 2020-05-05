package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.model.Gift;

import java.sql.*;

public class GiftRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public Gift findGift() {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);

            String request = "SELECT * FROM gift;";
            PreparedStatement statement = connection.prepareStatement(request);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_gift");
                String nameGift = resultSet.getString("title");
                String description = resultSet.getString("description");
                int note = resultSet.getInt("preference");
                String urlGiftPicture = resultSet.getString("image");
                String urlDealer = resultSet.getString("url_dealer");
                float price = resultSet.getFloat("price");
                int idGiftList = resultSet.getInt("id_gift_list");

                Gift gift = new Gift();
                gift.setId(id);
                gift.setNameGift(nameGift);
                gift.setDescription(description);
                gift.setNote(note);
                gift.setUrlGiftPicture(urlGiftPicture);
                gift.setUrlDealer(urlDealer);
                gift.setPrice(price);
                gift.setIdGiftList(idGiftList);

                return gift;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
