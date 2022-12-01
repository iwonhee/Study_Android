package com.example.and11_allview;

public class ListDTO {
    String name, cnt;

    public void setName(String name) {
        this.name = name;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public String getCnt() {
        return cnt;
    }

    public ListDTO(String name, String cnt){
        this.name = name;
        this.cnt = cnt;
    }
}
