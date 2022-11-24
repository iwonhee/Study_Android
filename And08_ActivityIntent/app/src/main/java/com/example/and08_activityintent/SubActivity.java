package com.example.and08_activityintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();    // MainActivity 에서 SubActivity 를 띄울때 통신용으로 사용한 Intent
        String sVal = intent.getStringExtra("sVal");
        int num1 = intent.getIntExtra("num1", -1); // int 타입은 null 사용 못하므로, 기본값 지정
        MemberDTO dto = (MemberDTO) intent.getSerializableExtra("dto");
        ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) intent.getSerializableExtra("list");

        Log.d("로그", "sVal : " + sVal);
        Log.d("로그", "num1 : " + num1);
        Log.d("로그", "dto.name : " + dto.getName());
        Log.d("로그", "list size : " + list.size());

    }
}