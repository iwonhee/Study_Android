package com.example.and11_allview.recylerMelon;

public class MelonDTO {
    String tv_title, tv_sub;
    int iv_main;

    public MelonDTO(String tv_title, String tv_sub, int iv_main) {
        this.tv_title = tv_title;
        this.tv_sub = tv_sub;
        this.iv_main = iv_main;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public void setTv_sub(String tv_sub) {
        this.tv_sub = tv_sub;
    }

    public void setIv_main(int iv_main) {
        this.iv_main = iv_main;
    }

    public String getTv_title() {
        return tv_title;
    }

    public String getTv_sub() {
        return tv_sub;
    }

    public int getIv_main() {
        return iv_main;
    }
}
