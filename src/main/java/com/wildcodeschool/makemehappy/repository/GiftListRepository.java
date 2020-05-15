package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.model.GiftList;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class GiftListRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public List<GiftList> findAllWishList(int id) {

        List<GiftList> dashboard = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT * FROM gift_list WHERE id_user = ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, id);
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

    public GiftList findGiftListById(int id)  {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "SELECT * FROM gift_list WHERE id_gift_list = ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                int idGiftList = resultSet.getInt("id_gift_list");
                String title = resultSet.getString("title");
                Date deadLine = resultSet.getDate("dead_line");;
                String shareLink = resultSet.getString("share_link");;
                String description = resultSet.getString("description");;
                boolean notifyGift = resultSet.getBoolean("notify_gift");
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
                return giftList;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GiftList save(String title, int idTheme, Date deadLine, String description, int idUser) {


        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            statement = connection.prepareStatement(
                    "INSERT INTO gift_list (title, id_theme, dead_line, description, id_user) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, title);
            statement.setInt(2, idTheme);
            statement.setDate(3, deadLine);
            statement.setString(4, description);
            statement.setInt(5, idUser);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int idGiftList = generatedKeys.getInt(1);
                return new GiftList(idGiftList, title, deadLine, description, idTheme, idUser);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public GiftList deleteById(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    URL_DATABASE, SQL_USER, SQL_PASSWORD
            );
            statement = connection.prepareStatement(
                    "DELETE FROM gift_list WHERE id_gift_list=?"
            );
            statement.setInt(1, id);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to delete data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

