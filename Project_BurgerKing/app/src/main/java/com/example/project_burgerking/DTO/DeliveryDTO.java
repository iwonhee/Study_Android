package com.example.project_burgerking.DTO;

public class DeliveryDTO {
    private int img;
    private String name, price;

    public DeliveryDTO(int img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
