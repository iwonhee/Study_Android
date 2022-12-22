package com.example.lastproject.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.conn.ApiClient;
import com.example.lastproject.R;

public class MemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        ApiClient.setBASEURL("");

    }
}