package com.example.middle_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", "admin");
        params.put("pw", "0000");
        Call<String> apiTest = apiInterface.getData("andTest", params);

        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("로그", "일단 전송하고 응답옴: " + response.body());
                TextView text = findViewById(R.id.tv_main);
                text.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("로그", "onFailure(오류): ");
            }
        });
        
    }
}