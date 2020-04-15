package com.wildcodeschool.makemehappy.model;

public class Gift {

    private String nameGift;
    private int price;
    private int note;
    private String urlDealer;
    private String urlGiftPicture;
    private String description;

    public Gift(String nameGift, int price, int note, String urlDealer, String urlGiftPicture, String description) {

        this.nameGift = nameGift;
        this.price = price;
        this.note = note;
        this.urlDealer = urlDealer;
        this.urlGiftPicture = urlGiftPicture;
        this.description = description;
    }

    public Gift() {}

    public String getNameGift() {

        return nameGift;
    }

    public void setNameGift(String nameGift) {

        this.nameGift = nameGift;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

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
}
