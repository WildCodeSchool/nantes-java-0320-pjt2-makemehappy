package com.wildcodeschool.makemehappy.entity;

public class Theme {

    private int idTheme;
    private String background;

    public Theme () {}

    public Theme (int idTheme, String background) {

        this.idTheme = idTheme;
        this.background = background;
    }

    public int getIdTheme() {

        return this.idTheme;
    }

    public String getBackground() {

        return this.background;
    }

    public void setIdTheme( int newIdTheme ) {
        this.idTheme = newIdTheme;
    }

    public void setBackground( String newBackground ) {

        this.background = newBackground;
    }
}
