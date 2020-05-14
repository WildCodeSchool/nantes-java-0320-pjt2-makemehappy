package com.wildcodeschool.makemehappy.repository;

import com.wildcodeschool.makemehappy.entity.User;
import java.sql.*;

public class UserRepository {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/make_me_happy?serverTimezone=Europe/Paris";
    private static final String SQL_USER = "donkey";
    private static final String SQL_PASSWORD = "projet2$";

    public boolean hasAccount(String pseudo, String password) {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "select * from user where pseudo = ? and password = ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setString(1, pseudo);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public User getUser(String pseudo, String password) {

        User user = new User();

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "select * from user where pseudo = ? and password = ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setString(1, pseudo);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int userId = resultSet.getInt("id_user");
            String userPseudo = resultSet.getString("pseudo");
            String userPassword = resultSet.getString("password");
            Date userBirthDate = resultSet.getDate("birth_date");
            String userAvatar = resultSet.getString("avatar");
            int userIdAvatar = resultSet.getInt("id_avatar");

            user.setId(userId);
            user.setPseudo(userPseudo);
            user.setPassword(userPassword);
            user.setBirthDate(userBirthDate);
            user.setAvatar(userAvatar);
            user.setIdAvatar(userIdAvatar);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserById(int id) {

        User user = new User();
        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "select * from user where id_user = ?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int userId = resultSet.getInt("id_user");
            String userPseudo = resultSet.getString("pseudo");
            String userPassword = resultSet.getString("password");
            Date userBirthDate = resultSet.getDate("birth_date");
            String userAvatar = resultSet.getString("avatar");
            int userIdAvatar = resultSet.getInt("id_avatar");

            user.setId(userId);
            user.setPseudo(userPseudo);
            user.setPassword(userPassword);
            user.setBirthDate(userBirthDate);
            user.setAvatar(userAvatar);
            user.setIdAvatar(userIdAvatar);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User createUser(String pseudo, String password, String avatar) {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "INSERT INTO user (pseudo, password, avatar) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pseudo);
            statement.setString(2, password);
            statement.setString(3, avatar);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                return new User(id, pseudo, password, null, "image/avatar-vide.svg", 0);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User updateProfile(int id_user, String pseudo, String password) {

        PreparedStatement statement;
        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            if (!password.isEmpty()) {
                String request = "UPDATE user SET pseudo=?, password=? WHERE id_user=?;";
                statement = connection.prepareStatement(request);
                statement.setString(1, pseudo);
                statement.setString(2, password);
                statement.setInt(3, id_user);
            } else {
                String request = "UPDATE user SET pseudo=? WHERE id_user=?;";
                statement = connection.prepareStatement(request);
                statement.setString(1, pseudo);
                statement.setInt(2, id_user);
            }

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new User(id_user, pseudo, password, null, null, 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAvatar(int idUser,int idAvatar, String avatar) {

        try {
            Connection connection = DriverManager.getConnection(URL_DATABASE, SQL_USER, SQL_PASSWORD);
            String request = "UPDATE user SET avatar=?, id_avatar=? WHERE id_user=?;";
            PreparedStatement statement = connection.prepareStatement(request);
            statement.setString(1, avatar);
            statement.setInt(2, idAvatar);
            statement.setInt(3, idUser);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
}