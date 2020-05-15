package com.wildcodeschool.makemehappy.entity;

public class UserGift {

    private int id;
    private int idGift;
    private int idUser;
    private String message;
    private String pseudo;

    public UserGift(int id, int idGift, int idUser, String message, String pseudo) {

        this.id = id;
        this.idGift = idGift;
        this.idUser = idUser;
        this.message = message;
        this.pseudo = pseudo;
    }

    public UserGift() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGift() {
        return idGift;
    }

    public void setIdGift(int idGift) {
        this.idGift = idGift;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
