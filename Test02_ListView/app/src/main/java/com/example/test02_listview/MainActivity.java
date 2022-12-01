package com.example.test02_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // main 레이아웃에 있는 리스트뷰 초기화
        listv_main = findViewById(R.id.listv_main);

        // 리스트뷰 각각의 데이터를 다르게 하기 위한 DTO객체를 담을 ArrayList 생성
        ArrayList<ListDTO> list = new ArrayList<>();
//        HashMap<String, ListDTO> map = new HashMap<>();
//        for(int i = 0; i < 12; i++){
//            list.add(new ListDTO(R.drawable.cat8, "tv_main"+i, "tv_sub"+i));
//        }
        list.add(new ListDTO(R.drawable.cat0, "tv_m3g1ain", "tv_sub"));
        list.add(new ListDTO(R.drawable.cat1, "tv_m1ain2", "tv_sㅁㄴㄻㅈㄹub"));
        list.add(new ListDTO(R.drawable.cat2, "tv_m1ain", "tv_suㅋㄴㄿㅂㅈㅍㅋb"));
        list.add(new ListDTO(R.drawable.cat3, "tv_main", "tv_suㅌㅋb"));
        list.add(new ListDTO(R.drawable.cat4, "tv_m12ain", "tv_sㅍㅋㅍㅋㅈㅍub"));
        list.add(new ListDTO(R.drawable.cat5, "tv_mgain", "tv_sㅌ츄윰ub"));
        list.add(new ListDTO(R.drawable.cat6, "tv_main", "tv_sㅁㅍㅁ뉴ub"));
        list.add(new ListDTO(R.drawable.cat7, "tv_dm1gain", "tv_sㄴ유ub"));
        list.add(new ListDTO(R.drawable.cat8, "tv_main", "tv_sub"));
        list.add(new ListDTO(R.drawable.cat9, "tv_madㅁㄴㅁㄴin", "tv_su눈두유b"));
        list.add(new ListDTO(R.drawable.cat10, "tv_ma1gin", "tv_ㄴ뮹븀sub"));


        // 생성한 Adapter 초기화. Adapter 에 필요한 LayoutInflater 넘겨주기
        MainAdapter adapter = new MainAdapter(getLayoutInflater(), list);
        // 리스트뷰, 어댑터 연결
        listv_main.setAdapter(adapter);

    }

}