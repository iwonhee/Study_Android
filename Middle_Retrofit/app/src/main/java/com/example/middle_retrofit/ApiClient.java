package com.example.middle_retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public Retrofit getApiClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.5/middle/")         // 톰캣까지(서버까지 접근경로)
                .client(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)

                        .build())
                .addConverterFactory(ScalarsConverterFactory.create())  //json String 사용
                .build();

        return retrofit;
    }


}
