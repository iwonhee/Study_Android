package com.example.test02_listview;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ListDTO implements Serializable {
    int iv_main;
    String tv_main, tv_sub;

    public ListDTO(int iv_main, String tv_main, String tv_sub) {
        this.iv_main = iv_main;
        this.tv_main = tv_main;
        this.tv_sub = tv_sub;
    }


    public void setIv_main(int iv_main) {
        this.iv_main = iv_main;
    }

    public void setTv_main(String tv_main) {
        this.tv_main = tv_main;
    }

    public void setTv_sub(String tv_sub) {
        this.tv_sub = tv_sub;
    }

    public int getIv_main() {
        return iv_main;
    }

    public String getTv_main() {
        return tv_main;
    }

    public String getTv_sub() {
        return tv_sub;
    }
}
