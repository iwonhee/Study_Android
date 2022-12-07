package com.example.project01_clone.common;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {

    // 매번 화면에서 LayoutManager 만드는 행위 등
    // 재사용이 가능한 메소드들을 선언

    public static LinearLayoutManager getManager(Context context){
        return new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
    }

    public static LinearLayoutManager getManager(Context context, int orientation){
        return new LinearLayoutManager(context, orientation, false);
    }

}
