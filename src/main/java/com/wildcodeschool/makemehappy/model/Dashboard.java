package com.wildcodeschool.makemehappy.model;

import java.util.List;

public class Dashboard {

    private List<GiftList> dashboard;

    public Dashboard(List<GiftList> dashboard) {
        this.dashboard = dashboard;
    }

    public List<GiftList> getDashboard() {
        return dashboard;
    }

    public void setDashboard(List<GiftList> dashboard) {
        this.dashboard = dashboard;
    }
}