package com.siti.sitiuts.models;

public class MenuLogo {
    String logo;
    String name;

    public MenuLogo(String s, String coffee) {
        this.logo = s;
        this.name = coffee;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
