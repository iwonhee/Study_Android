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
import com.example.project_burgerking.databinding.ActivityMainBinding;
import com.example.project_burgerking.membership.MemberActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();
//        overridePendingTransition();   슬라이드 애니메이션으로 화면 띄우기
        // MainFragment 기본 연결
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();

        // Binding
        // 바텀내비 클릭시 색 변경될 아이콘
        b.ivNavHome.setImageResource(R.drawable.nav_home_r);  //기본 홈화면 select


        // 바텀내비 아이템 : lin_btm_item1

        // 홈 클릭시
        b.linBtmItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.ivNavCoupon.setImageResource(R.drawable.nav_coupon);
                b.ivNavMyking.setImageResource(R.drawable.nav_myking);
                b.ivNavMore.setImageResource(R.drawable.nav_more);
                b.ivNavHome.setImageResource(R.drawable.nav_home_r);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
            }
        });
        // 쿠폰 클릭시
        b.linBtmItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.ivNavHome.setImageResource(R.drawable.nav_home);
                b.ivNavMyking.setImageResource(R.drawable.nav_myking);
                b.ivNavMore.setImageResource(R.drawable.nav_more);
                b.ivNavCoupon.setImageResource(R.drawable.nav_coupon_r);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CouponFragment()).commit();
            }
        });



    }// onCreate()



    @Override
    public void onClick(View v) {

    }// onClick()

    //나머지 내비 아이콘 이미지 바꾸기
    

}