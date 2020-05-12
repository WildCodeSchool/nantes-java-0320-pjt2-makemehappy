package com.wildcodeschool.makemehappy.entity;

public class Avatar {

    private int id;
    private String name;

    public Avatar(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Avatar() {

    }

    public int getId() {

        return this.id;
    }

    public String getName() {

        return this.name;
    }

    public void setId(int newId) {

        this.id = newId;
    }

    public void setName(String newName) {

        this.name = newName;
    }
}