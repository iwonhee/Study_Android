package com.example.project01_clone.view;

import java.io.Serializable;

public class ViewDTO implements Serializable {
    private int imgRes, tv_view_time, iv_view_writer;
    private String tv_view_title, tv_view_subtitle, tv_view_content, tv_view_writer, tv_view_writer2;

    public ViewDTO(int imgRes, int iv_view_writer, int tv_view_time, String tv_view_title, String tv_view_subtitle, String tv_view_content, String tv_view_writer) {
        this.imgRes = imgRes;
        this.iv_view_writer = iv_view_writer;
        this.tv_view_time = tv_view_time;
        this.tv_view_title = tv_view_title;
        this.tv_view_subtitle = tv_view_subtitle;
        this.tv_view_content = tv_view_content;
        this.tv_view_writer = tv_view_writer;
        this.tv_view_writer2 = tv_view_writer;
    }

    public void setIv_view_writer(int iv_view_writer) {
        this.iv_view_writer = iv_view_writer;
    }

    public int getIv_view_writer() {
        return iv_view_writer;
    }

    public int getImgRes() {
        return imgRes;
    }

    public int getTv_view_time() {
        return tv_view_time;
    }

    public String getTv_view_title() {
        return tv_view_title;
    }

    public String getTv_view_subtitle() {
        return tv_view_subtitle;
    }

    public String getTv_view_content() {
        return tv_view_content;
    }

    public String getTv_view_writer() {
        return tv_view_writer;
    }

    public String getTv_view_writer2() {
        return tv_view_writer2;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public void setTv_view_time(int tv_view_time) {
        this.tv_view_time = tv_view_time;
    }

    public void setTv_view_title(String tv_view_title) {
        this.tv_view_title = tv_view_title;
    }

    public void setTv_view_subtitle(String tv_view_subtitle) {
        this.tv_view_subtitle = tv_view_subtitle;
    }

    public void setTv_view_content(String tv_view_content) {
        this.tv_view_content = tv_view_content;
    }

    public void setTv_view_writer(String tv_view_writer) {
        this.tv_view_writer = tv_view_writer;
    }

    public void setTv_view_writer2(String tv_view_writer2) {
        this.tv_view_writer2 = tv_view_writer2;
    }
}
