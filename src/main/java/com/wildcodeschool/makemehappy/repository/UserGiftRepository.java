package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.entity.UserGift;
import com.wildcodeschool.makemehappy.model.Gift;

import java.sql.*;

public class UserGiftRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public UserGift findUserGift() throws SQLException {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);

            String request = "SELECT user_gift.*, user.pseudo FROM user_gift JOIN user ON user.id_user = user_gift.id_user;";
            PreparedStatement statement = connection.prepareStatement(request);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idGift = resultSet.getInt("id_gift");
                int idUser = resultSet.getInt("id_user");
                String message = resultSet.getString("message");
                String pseudo = resultSet.getString("pseudo");

                UserGift userGift = new UserGift();
                userGift.setIdGift(idGift);
                userGift.setIdUser(idUser);
                userGift.setMessage(message);
                userGift.setPseudo(pseudo);

                return userGift;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
