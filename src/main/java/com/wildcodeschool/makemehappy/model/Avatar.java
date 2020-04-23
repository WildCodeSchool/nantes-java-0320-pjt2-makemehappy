package com.wildcodeschool.makemehappy.model;

public class Avatar {

    private String name;
    private String image;

    public Avatar(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {

        return this.name;
    }

    public String getImage() {

        return  this.image;
    }

    public void setName(String newName) {

        this.name = newName;
    }

    public void setImage(String image) {

        this.image = image;
    }
}