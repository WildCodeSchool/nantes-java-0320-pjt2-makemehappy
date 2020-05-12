package com.wildcodeschool.makemehappy.model;

import java.util.Date;

public class GiftList {

    private int idGiftList;
    private String title;
    private Date deadLine;
    private String shareLink;
    private String description;
    private boolean notifyGift;
    private int idUser;
    private int idTheme;
    private String nameGift;
    private int note;
    private String urlGiftPicture;

    public GiftList() {
    }

    public GiftList(int idGiftList, String title, Date deadLine, String shareLink, String description, boolean notifyGift, int idUser, int idTheme, String nameGift, int note, String urlGiftPicture) {
        this.idGiftList = idGiftList;
        this.title = title;
        this.deadLine = deadLine;
        this.shareLink = shareLink;
        this.description = description;
        this.notifyGift = notifyGift;
        this.idUser = idUser;
        this.idTheme = idTheme;
        this.nameGift = nameGift;
        this.note = note;
        this.urlGiftPicture = urlGiftPicture;
    }


    public int getIdGiftList() {
        return idGiftList;
    }

    public void setIdGiftList(int idGiftList) {
        this.idGiftList = idGiftList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNotifyGift() {
        return notifyGift;
    }

    public void setNotifyGift(boolean notifyGift) {
        this.notifyGift = notifyGift;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getNameGift() {
        return nameGift;
    }

    public void setNameGift(String nameGift) {
        this.nameGift = nameGift;
    }

    public int getNote() {
        return note;
    }

 

    public void setNote(int note) {
        this.note = note;
    }

    public String getUrlGiftPicture() {
        return urlGiftPicture;
    }

    public void setUrlGiftPicture(String urlGiftPicture) {
        this.urlGiftPicture = urlGiftPicture;
    }
}
