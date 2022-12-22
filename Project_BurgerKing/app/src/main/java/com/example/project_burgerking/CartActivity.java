package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project_burgerking.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());



    }
}