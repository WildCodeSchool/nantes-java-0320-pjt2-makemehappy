package com.wildcodeschool.makemehappy.model;

import java.util.Date;
import java.util.List;

public class GiftList {

    private int idGiftList;
    private String title;
    private Date deadLine;
    private String shareLink;
    private String description;
    private boolean notifyGift;
    private int idUser;
    private int idTheme;


    public GiftList() {
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
}
