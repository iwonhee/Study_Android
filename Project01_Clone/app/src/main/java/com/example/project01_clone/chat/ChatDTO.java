package com.example.project01_clone.chat;

import java.io.Serializable;

public class ChatDTO implements Serializable {
    private int iv_chat;
    private String tv_chat_title, tv_chat_msg, tv_chat_time;

    public ChatDTO(int iv_chat, String tv_chat_title, String tv_chat_msg, String tv_chat_time) {
        this.iv_chat = iv_chat;
        this.tv_chat_title = tv_chat_title;
        this.tv_chat_msg = tv_chat_msg;
        this.tv_chat_time = tv_chat_time;
    }

    public void setIv_chat(int iv_chat) {
        this.iv_chat = iv_chat;
    }

    public void setTv_chat_title(String tv_chat_title) {
        this.tv_chat_title = tv_chat_title;
    }

    public void setTv_chat_msg(String tv_chat_msg) {
        this.tv_chat_msg = tv_chat_msg;
    }

    public void setTv_chat_time(String tv_chat_time) {
        this.tv_chat_time = tv_chat_time;
    }

    public int getIv_chat() {
        return iv_chat;
    }

    public String getTv_chat_title() {
        return tv_chat_title;
    }

    public String getTv_chat_msg() {
        return tv_chat_msg;
    }

    public String getTv_chat_time() {
        return tv_chat_time;
    }
}
