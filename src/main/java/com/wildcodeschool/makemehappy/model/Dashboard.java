package com.wildcodeschool.makemehappy.model;

import java.util.List;

public class Dashboard {
    private List GiftList;

    public Dashboard (){}

    public Dashboard (List list){
        this.GiftList= list;
    }

    public List getList() {
        return GiftList;
    }

    public void setList(List list) {
        this.GiftList = list;
    }
}
