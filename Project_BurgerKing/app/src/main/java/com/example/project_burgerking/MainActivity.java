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
        b.relBtmItem3.setOnClickListener(this);
        // 검은화면 사라지게
        b.orderContainer.setOnClickListener(this);
        b.ivNavClose.setOnClickListener(this);

        // 킹오더 클릭
        b.cardKingOrder.setOnClickListener(this);

        // 홈 클릭시
        b.linBtmItem1.setOnClickListener(this);
        // 쿠폰 클릭시
        b.linBtmItem2.setOnClickListener(this);
        // 더보기 클릭시
        b.linBtmItem5.setOnClickListener(this);

        // MY킹 클릭 : 임시 로그인
        b.linBtmItem4.setOnClickListener(this);

    }// onCreate()


    // 클릭이벤트
    @Override
    public void onClick(View v) {
        int red = getResources().getColor(R.color.icon_red);
        if (v.getId() == R.id.lin_btm_item4) {
            // MY킹 클릭
            selectNav("myKing");
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyKingFragment()).commit();
        } else if (v.getId() == R.id.lin_btm_item2) {
            // 쿠폰 클릭
            selectNav("coupon");
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new CouponFragment()).commit();
        } else if (v.getId() == R.id.lin_btm_item1) {
            // 홈 클릭
            selectNav("home");
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();
        }else if(v.getId() == R.id.lin_btm_item5){
            // 더보기 클릭
            selectNav("more");
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MoreFragment()).commit();
        }else if(v.getId() == R.id.card_kingOrder){
            // 킹오더 클릭
            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.iv_nav_close){
            // close 클릭
            blackOut();
        }else if(v.getId() == R.id.order_container){
            // 검은화면 클릭
            blackOut();
        }else if(v.getId() == R.id.rel_btm_item3){
            // 주문 클릭
            b.orderContainer.setVisibility(View.VISIBLE);
            b.ivNavOrder.setVisibility(View.GONE);
            b.ivNavClose.setVisibility(View.VISIBLE);
        }

    }// onClick()

    //나머지 내비 아이콘 색 바꾸기
    public void selectNav(String s){
        int braun = getResources().getColor(R.color.font_braun);
        int red = getResources().getColor(R.color.icon_red);

        b.ivNavMyking.setImageResource(R.drawable.nav_myking);
        b.ivNavMore.setImageResource(R.drawable.nav_more);
        b.ivNavHome.setImageResource(R.drawable.nav_home);
        b.ivNavCoupon.setImageResource(R.drawable.nav_coupon);

        b.tvCoupon.setTextColor(braun);
        b.tvHome.setTextColor(braun);
        b.tvMore.setTextColor(braun);
        b.tvMyKing.setTextColor(braun);

        if(s.equals("myKing")){
            b.ivNavMyking.setImageResource(R.drawable.nav_myking_r);
            b.tvMyKing.setTextColor(red);
        }else if(s.equals("more")){
            b.ivNavMore.setImageResource(R.drawable.nav_more_r);
            b.tvMore.setTextColor(red);
        }else if(s.equals("home")){
            b.ivNavHome.setImageResource(R.drawable.nav_home_r);
            b.tvHome.setTextColor(red);
        }else if(s.equals("coupon")){
            b.ivNavCoupon.setImageResource(R.drawable.nav_coupon_r);
            b.tvCoupon.setTextColor(red);
        }
    }//selectNav()

    //검은화면 닫기
    public void blackOut(){
        b.orderContainer.setVisibility(View.GONE);
        b.ivNavClose.setVisibility(View.GONE);
        b.ivNavOrder.setVisibility(View.VISIBLE);
    }

}