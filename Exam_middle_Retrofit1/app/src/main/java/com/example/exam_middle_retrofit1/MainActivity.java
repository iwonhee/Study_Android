package com.example.exam_middle_retrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.exam_middle_retrofit1.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    final String TAG = "log";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HashMap<String, Object> params = new HashMap<>();
        params.put("id", "admin");

        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.getData("andVo", params);

        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "성공 : " + response.body());
                CustomerVO vo = new Gson().fromJson(response.body(), CustomerVO.class);
                binding.tv.setText(vo.getEmail());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "실패 : " + t.getMessage());
            }
        });

    }
}