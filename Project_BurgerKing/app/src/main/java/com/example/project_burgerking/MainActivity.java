package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
    //ImageView iv_home_slide1
    ImageView  iv_nav_home, iv_nav_coupon, iv_nav_order, iv_nav_myking, iv_nav_more;
    ImageView iv_membership, iv_home_basket_number;
    RecyclerView recv_home_new;
    LinearLayout lin_btm_item1, lin_btm_item2, lin_btm_item4, lin_btm_item5;
    RelativeLayout rel_btm_item3, rel_basket;
    ViewPager2 viewpager_home;

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
        iv_home_basket_number = findViewById(R.id.iv_home_basket_number);

        lin_btm_item1 = findViewById(R.id.lin_btm_item1);
        lin_btm_item2 = findViewById(R.id.lin_btm_item2);
        rel_btm_item3 = findViewById(R.id.rel_btm_item3);
        lin_btm_item4 = findViewById(R.id.lin_btm_item4);
        lin_btm_item5 = findViewById(R.id.lin_btm_item5);
        rel_basket = findViewById(R.id.rel_basket);

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

        // 장바구니
        rel_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ArrayList<Integer> slideList = new ArrayList<>();
        slideList.add(R.drawable.home_slide1);
        slideList.add(R.drawable.home_slide2);
        slideList.add(R.drawable.home_slide3);
        slideList.add(R.drawable.home_slide4);
        //뷰페이저 어댑터 연결
        viewpager_home.setAdapter(new HomeViewPagerAdapter(this, getLayoutInflater(), slideList));
        viewpager_home.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);



        ArrayList<HomeBurgerDTO> list = new ArrayList<>();
        list.add(new HomeBurgerDTO(R.drawable.burger_buw, "블랙어니언 와퍼"));
        list.add(new HomeBurgerDTO(R.drawable.burger_bux, "블랙어니언X"));
        list.add(new HomeBurgerDTO(R.drawable.burger_buc, "블랙어니언 치킨"));
        // It's NEW 스크롤
        recv_home_new = findViewById(R.id.recv_home_new);
        recv_home_new.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recv_home_new.setAdapter(new HomeBurgerAdapter(getLayoutInflater(), list));


    }// onCreate()

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.lin_btm_item1){

        }else if(v.getId() == R.id.lin_btm_item2){

        }


    }// onClick()


    

}