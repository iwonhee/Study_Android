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


        // 바텀 내비 '주문' 클릭
        b.relBtmItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.orderContainer.setVisibility(View.VISIBLE);
                b.ivNavOrder.setVisibility(View.GONE);
                b.ivNavClose.setVisibility(View.VISIBLE);
            }
        });
        // 검은화면 사라지게
        b.orderContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.orderContainer.setVisibility(View.GONE);
                b.ivNavClose.setVisibility(View.GONE);
                b.ivNavOrder.setVisibility(View.VISIBLE);
            }
        });
        b.ivNavClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.orderContainer.setVisibility(View.GONE);
                b.ivNavClose.setVisibility(View.GONE);
                b.ivNavOrder.setVisibility(View.VISIBLE);
            }
        });

        // 킹오더 클릭
        b.cardKingOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

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

        // MY킹 클릭 : 임시 로그인
        b.linBtmItem4.setOnClickListener(this);

    }// onCreate()



    @Override
    public void onClick(View v) {
        // MY킹 클릭 : 임시 로그인 페이지 이동
        if(v.getId() == R.id.lin_btm_item4){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }// onClick()

    //나머지 내비 아이콘 이미지 바꾸기
    

}