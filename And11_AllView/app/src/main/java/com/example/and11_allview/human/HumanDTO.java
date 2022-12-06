package com.example.and11_allview.human;

public class HumanDTO {
    private int iv_main;
    private String tv_title, tv_price;

    public HumanDTO(int iv_main, String tv_title, String tv_price) {
        this.iv_main = iv_main;
        this.tv_title = tv_title;
        this.tv_price = tv_price;
    }

    public void setIv_main(int iv_main) {
        this.iv_main = iv_main;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public void setTv_price(String tv_price) {
        this.tv_price = tv_price;
    }

    public int getIv_main() {
        return iv_main;
    }

    public String getTv_title() {
        return tv_title;
    }

    public String getTv_price() {
        return tv_price;
    }
}
