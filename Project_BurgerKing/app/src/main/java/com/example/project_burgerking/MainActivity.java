package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.project_burgerking.DTO.HomeBurgerDTO;
import com.example.project_burgerking.adapter.HomeBurgerAdapter;
import com.example.project_burgerking.adapter.HomeViewPagerAdapter;
import com.example.project_burgerking.membership.MemberActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_home_slide1, iv_nav_home, iv_nav_coupon, iv_nav_order, iv_nav_myking, iv_nav_more;
    ImageView iv_membership;
    RecyclerView recv_home_new;
    LinearLayout lin_btm_item1, lin_btm_item2, lin_btm_item4, lin_btm_item5;
    RelativeLayout rel_btm_item3;
    ViewPager viewpager_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // Binding
        iv_nav_home = findViewById(R.id.iv_nav_home);
        iv_nav_coupon = findViewById(R.id.iv_nav_coupon);
        iv_nav_order = findViewById(R.id.iv_nav_order);
        iv_nav_myking = findViewById(R.id.iv_nav_myking);
        iv_nav_more = findViewById(R.id.iv_nav_more);
        iv_membership = findViewById(R.id.iv_membership);

        lin_btm_item1 = findViewById(R.id.lin_btm_item1);
        lin_btm_item2 = findViewById(R.id.lin_btm_item2);
        rel_btm_item3 = findViewById(R.id.rel_btm_item3);
        lin_btm_item4 = findViewById(R.id.lin_btm_item4);
        lin_btm_item5 = findViewById(R.id.lin_btm_item5);

        viewpager_home = findViewById(R.id.viewpager_home);

        iv_nav_home.setImageResource(R.drawable.nav_home_r);    //기본 홈화면 select

        // 멤버십화면
        iv_membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MemberActivity.class);
                startActivity(intent);
            }
        });

        viewpager_home.setAdapter(new HomeViewPagerAdapter(this, getLayoutInflater()));
        // Main Slide
        iv_home_slide1 = findViewById(R.id.iv_home_slide1);
        Glide.with(this).load("https://d1cua0vf0mkpiy.cloudfront.net/images/web/banner/5364f790-a064-42a2-9bbc-6972e053ad83.png")
                .into(iv_home_slide1);

        ArrayList<HomeBurgerDTO> list = new ArrayList<>();
        list.add(new HomeBurgerDTO(R.drawable.burger_buw, "블랙어니언 와퍼"));
        list.add(new HomeBurgerDTO(R.drawable.burger_bux, "블랙어니언X"));
        list.add(new HomeBurgerDTO(R.drawable.burger_buc, "블랙어니언 치킨"));
        // It's NEW 스크롤
        recv_home_new = findViewById(R.id.recv_home_new);
        recv_home_new.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recv_home_new.setAdapter(new HomeBurgerAdapter(getLayoutInflater(), list));


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.lin_btm_item1){

        }


    }// onClick()
    

}