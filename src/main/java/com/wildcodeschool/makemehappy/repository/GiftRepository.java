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

    public Gift save(String nameGift, String description, String urlGiftPicture, String urlDealer, float price, int note) {
        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO gift(title, description, image, url_dealer, price, preference) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nameGift);
            statement.setString(2, description);
            statement.setString(3, urlGiftPicture);
            statement.setString(4, urlDealer);
            statement.setFloat(5, price);
            statement.setInt(6, note);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                return new Gift(id, nameGift, price, note, urlGiftPicture, urlDealer, description, 0);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Gift update(int id, String nameGift, String description, String urlGiftPicture, String urlDealer, float price, int note) {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("UPDATE  gift SET title = ?, description = ?, image = ?, url_dealer = ?, price = ? ,preference = ? WHERE id_gift = ?");
            statement.setString(1, nameGift);
            statement.setString(2, description);
            statement.setString(3, urlGiftPicture);
            statement.setString(4, urlDealer);
            statement.setFloat(5, price);
            statement.setInt(6, note);
            statement.setInt(7, id);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new Gift(1, nameGift, price, note, urlGiftPicture, urlDealer, description, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Gift findById(int id) {
        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gift WHERE id_gift = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
