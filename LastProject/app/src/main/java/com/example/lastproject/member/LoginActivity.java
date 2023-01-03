package com.example.lastproject.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.databinding.ActivityLoginBinding;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding b;
    private final String TAG = "logd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        ApiClient.setBASEURL("http://192.168.0.115/middle/");
        //초기화(네이티브 키)
        KakaoSdk.init(this, "d81ef1951c67b3de710220c4425d8aeb");
        NaverIdLoginSDK.INSTANCE.initialize(this, "q713C8rnA3eeJpK9yEsf", "VlbbENE90q", "LastProject");

        // 카카오 로그인
        b.buttonOAuthLoginImg.setOAuthLogin(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "onSuccess: ");
                new NidOAuthLogin().callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse nidProfileResponse) {
                        Log.d(TAG, "onSuccess: " + nidProfileResponse.getProfile().getEmail());
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                });
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d(TAG, i + "onError: "+s);
            }
        });

        // 일반 로그인 버튼
        b.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams("email", b.edtId.getText().toString())
                        .setParams("pw", b.edtPw.getText().toString())
                        .sendPost("login.me", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                Log.d("log", "result: "+ data);
                            }
                        });
            }
        });

        //크롬 안켜지면 크롬 비활성화 후 진행
        b.ivKakaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kakaoLogin();
            }
        });
        getHashKey();

        //회원가입
        b.btnJoin.setOnClickListener(v -> {
            Intent intent = new Intent(this, JoinActivity.class);
            startActivity(intent);
        });

    }// onCreate()

    //  VEnQQSCqQmKL0uHmxSK1Y/hRy5g=
    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("log", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("log", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    private void kakaoLogin(){
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null){
                    Log.d("log", "invoke: " + oAuthToken.toString());

                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {
                            Log.d(TAG, "invoke: " + user.getId());
                            Log.d(TAG, "invoke: " + user.getKakaoAccount().getEmail());
                            Log.d(TAG, "invoke: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                            socialLogin(user.getKakaoAccount().getEmail());
                            return null;
                        }
                    });
                }
                return null;
            }
        };

        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)) {
            UserApiClient.getInstance().loginWithKakaoTalk(this, callback);
        }else{
            UserApiClient.getInstance().loginWithKakaoAccount(this, callback);
        }
    }

    // Spring 으로 email(kakaoInfo) 보내기
    public void socialLogin(String email){
        Log.d(TAG, "socialLogin: " + email);
        // 소셜 로그인을 통해 가져온 정보를 Spring 으로 전송( oracle 테이블에 해당하는 메일로 가입한 정보 )
        new CommonMethod().setParams("email", email).sendPost("social.me", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                if(isResult){
                    Log.d(TAG, "성공 " + data); //return 다시 받아보기
                }else{
                    Log.d(TAG, "실패");
                }
            }
        });
        //1. 가입한 정보가 있다면 로그인 성공처리
        //2. 가입한 정보가 없다면 회원가입 처리
    }

}