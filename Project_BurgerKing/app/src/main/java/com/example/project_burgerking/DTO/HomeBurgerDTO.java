package com.example.project_burgerking.DTO;

import java.io.Serializable;

public class HomeBurgerDTO implements Serializable {

    private int imgRes;
    private String name;

    public HomeBurgerDTO(int imgRes, String name) {
        this.imgRes = imgRes;
        this.name = name;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgRes() {
        return imgRes;
    }

    public String getName() {
        return name;
    }
}
