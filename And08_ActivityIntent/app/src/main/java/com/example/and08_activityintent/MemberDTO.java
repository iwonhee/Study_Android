package com.example.and08_activityintent;

import java.io.Serializable;

// 직렬화 Serializable : 통신에서 전송을 편하게 하기 위해 메모리 번지수를 직렬로 바꾸는 것
// Main => Intent => OS => Intent => Sub
// ※ Intent 를 통해서 DTO 객체를 전송할때는 반드시 직렬화를 해야한다 ※
public class MemberDTO implements Serializable {
    private String id, name;
    private int num;

    public MemberDTO(String id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
