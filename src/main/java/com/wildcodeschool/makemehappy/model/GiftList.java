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

    private String imageTheme;

    public GiftList() {
    }

    public GiftList(int idGiftList, String title, Date deadLine, String shareLink, String description, boolean notifyGift, int idUser, int idTheme) {
        this.idGiftList = idGiftList;
        this.title = title;
        this.deadLine = deadLine;
        this.shareLink = shareLink;
        this.description = description;
        this.notifyGift = notifyGift;
        this.idUser = idUser;
        this.idTheme = idTheme;

    }

    public GiftList(int idGiftList, String title, Date deadLine, String description, int idTheme, int idUser) {
        this.idGiftList = idGiftList;
        this.title = title;
        this.deadLine = deadLine;
        this.description = description;
        this.idTheme = idTheme;
        this.idUser = idUser;
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

    public String getImageTheme() {
        return imageTheme;
    }

    public void setImageTheme(String imageTheme) {
        this.imageTheme = imageTheme;
    }

}
