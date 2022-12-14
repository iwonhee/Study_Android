package com.example.middle_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.middle_retrofit.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;    // 위젯을 하나씩 find 안해도 하나로 묶어놓음

    String TAG = "log";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonMethod commonMethod = new CommonMethod();
        commonMethod.setParams("data", "kwh");
        commonMethod.getConn("andVo", new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG,  "성공");
                CustomerVO vo = new Gson().fromJson(response.body(), CustomerVO.class);
                binding.tv.setText(vo.getName());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "실패 : " + t.getMessage());
            }
        });

        
    }
}