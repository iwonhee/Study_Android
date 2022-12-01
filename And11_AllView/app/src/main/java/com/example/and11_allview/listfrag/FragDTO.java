package com.example.and11_allview.listfrag;

import android.widget.ImageView;
import android.widget.TextView;

public class FragDTO {
    TextView name, upload_time;
    ImageView iv_main, iv_star, iv_new;

    public FragDTO(TextView name, TextView upload_time, ImageView iv_main, ImageView iv_star, ImageView iv_new) {
        this.name = name;
        this.upload_time = upload_time;
        this.iv_main = iv_main;
        this.iv_star = iv_star;
        this.iv_new = iv_new;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public void setUpload_time(TextView upload_time) {
        this.upload_time = upload_time;
    }

    public void setIv_main(ImageView iv_main) {
        this.iv_main = iv_main;
    }

    public void setIv_star(ImageView iv_star) {
        this.iv_star = iv_star;
    }

    public void setIv_new(ImageView iv_new) {
        this.iv_new = iv_new;
    }

    public TextView getName() {
        return name;
    }

    public TextView getUpload_time() {
        return upload_time;
    }

    public ImageView getIv_main() {
        return iv_main;
    }

    public ImageView getIv_star() {
        return iv_star;
    }

    public ImageView getIv_new() {
        return iv_new;
    }
}
