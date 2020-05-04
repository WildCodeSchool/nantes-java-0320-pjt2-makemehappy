package com.wildcodeschool.makemehappy.model;

public class Gift {

    private int id;
    private String nameGift;
    private float price;
    private int note;
    private String urlDealer;
    private String urlGiftPicture;
    private String description;
    private String nameList;

    public Gift(int id, String nameGift, float price, int note, String urlDealer, String urlGiftPicture, String description, String nameList) {

        this.id = id;
        this.nameGift = nameGift;
        this.price = price;
        this.note = note;
        this.urlDealer = urlDealer;
        this.urlGiftPicture = urlGiftPicture;
        this.description = description;
        this.nameList = nameList;
    }

    public Gift() {}



    public Gift(String id, String nameGift, float price, int note, String urlDealer, String urlGiftPicture, String description, String id_gift_list) {
    }

    public Gift(String casque, double v, int note, String urlDealer, String urlGiftPicture, String description, String id_gift_list) {
    }

    public String getNameGift() {

        return nameGift;
    }

    public void setNameGift(String nameGift) {

        this.nameGift = nameGift;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(float price) {

        this.price = price;
    }

    public int getNote() {

        return note;
    }

    public void setNote(int note) {

        this.note = note;
    }

    public String getUrlDealer() {

        return urlDealer;
    }

    public void setUrlDealer(String urlDealer) {

        this.urlDealer = urlDealer;
    }

    public String getUrlGiftPicture() {

        return urlGiftPicture;
    }

    public void setUrlGiftPicture(String urlGiftPicture) {

        this.urlGiftPicture = urlGiftPicture;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNameList(int id_gift_list) {
        this.nameList = nameList;
    }

    public String getNameList() {
        return nameList;
    }
}
