package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project_burgerking.databinding.ActivityDeliveryBinding;

public class DeliveryActivity extends AppCompatActivity {
    ActivityDeliveryBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityDeliveryBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());



    }
}