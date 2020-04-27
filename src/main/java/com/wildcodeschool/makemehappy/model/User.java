package com.wildcodeschool.makemehappy.model;

import java.util.Date;

public class User {

    private int id;
    private String pseudo;
    private String password;
    private Date birthDate;
    private String avatar;
    private int idAvatar;

    public User() {}

    public User(int id, String pseudo, String password, Date birthDate, String avatar, int idAvatar) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.birthDate = birthDate;
        this.avatar = avatar;
        this.idAvatar = idAvatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }
}
