package com.example.project01_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project01_clone.chat.ChatFragment;
import com.example.project01_clone.external.ExternalFragment;
import com.example.project01_clone.friendlist.FriendFragment;
import com.example.project01_clone.view.ViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView btm_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar(); // 기본 액션바 가져오기
        actionBar.setTitle("친구");
        changeFragment(new FriendFragment());   // 처음에 연결시킬 프래그먼트

        btm_nav=findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.btm_item1){
                    actionBar.setTitle("친구");
                    changeFragment(new FriendFragment());

                }else if(item.getItemId() == R.id.btm_item2){
                    actionBar.setTitle("채팅");
                    changeFragment(new ChatFragment());

                }else if(item.getItemId() == R.id.btm_item3){
                    actionBar.setTitle("뷰");
                    changeFragment(new ViewFragment());

                }else if(item.getItemId() == R.id.btm_item4){
                    actionBar.setTitle("쇼핑");
                    changeFragment(new ExternalFragment());

                }else if(item.getItemId() == R.id.btm_item5){
                    actionBar.setTitle("더보기");

                }

                return true;
            }
        });

    }// onCreate

    // 프래그먼트 붙이는 메소드
    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

}