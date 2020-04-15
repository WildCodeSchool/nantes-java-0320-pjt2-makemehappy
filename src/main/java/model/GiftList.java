package model;

import java.util.Date;

public class GiftList{
    private String title;
    private Date date;
    private String description;
    private List<Gift> giftList;
    }

    public GiftList () {
    }

    public GiftList (String title, String description, Date date) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDate (Date date) {
        this.date= date;
    }

    public Date getDate() {
        return date;
    }

    public void setDescription (String description) {
        this.description= description;
    }

    public String getDescription() {
        return description;
    }
}

