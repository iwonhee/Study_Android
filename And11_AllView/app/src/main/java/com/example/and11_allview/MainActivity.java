package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.and11_allview.gridv.Adapter_Grid;
import com.example.and11_allview.gridv.GridFragment;
import com.example.and11_allview.human.HumanFragment;
import com.example.and11_allview.listfrag.Frag_Adapter;
import com.example.and11_allview.listfrag.ListFragment;
import com.example.and11_allview.recycler.RecyclerFragment;
import com.example.and11_allview.recylerMelon.MelonFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_sub, btn_list, btn_grid, btn_recycler, btn_melon;
    // 2인구현 버튼 (임시)
    Button btn_human;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sub = findViewById(R.id.btn_sub);
        btn_list = findViewById(R.id.btn_list);     //리스트뷰 버튼
        btn_grid = findViewById(R.id.btn_grid);     //그리드뷰 버튼
        btn_recycler = findViewById(R.id.btn_recycler);     //리사이클러 버튼
        btn_melon = findViewById(R.id.btn_melon);
        btn_human = findViewById(R.id.btn_human);

        // 리사이클러뷰 - 2인구현
        btn_human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HumanFragment()).commit();
            }
        });

        // 리사이클러뷰 - 직접구현
        btn_melon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MelonFragment()).commit();
            }
        });

        // 리사이클러뷰
        btn_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new RecyclerFragment()).commit();
            }
        });

        // 그리드뷰
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 메인액티비티에 있는 id:container에 프래그먼트 붙이기
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new GridFragment()).commit();
            }
        });

        // 서브 액티비티 연결
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        // 리스트뷰
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();
            }
        });


    }
}