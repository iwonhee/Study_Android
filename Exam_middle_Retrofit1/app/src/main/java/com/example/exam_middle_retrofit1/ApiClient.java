package com.example.exam_middle_retrofit1;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public Retrofit getApiClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.5/middle/")
                .client(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit;
    }
}
