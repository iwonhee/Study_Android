package com.example.project01_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    // Splash 화면 : 사용자에게 자연스럽게 광고 배너나 브랜드 이미지를 노출
    // 해당 화면을 노출하는 동안, 백그라운드에서 데이터 로딩 작업을 할 수 있음

    // Handler : 메인 쓰레드를 이용해서 딜레이를 주는 기능을 이용할때 사용.

    // 화면에 앱이 보여주는 액티비티의 순서나 등록된 모든 컴포넌트 관리 : androidManifest.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // ProgressDialog ※사용자 입장에서 중요한 UI 요소
        // 사용자는 현재 앱이 멈춘건지 데이터 로딩을 하는건지 판단하기 어려움
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("로그인 정보 가져오는중");
        dialog.setMessage("로딩중...");
        dialog.setCancelable(false);
        dialog.show(); // 실제로 화면에 보이게 하는 메소드


        // 쓰레드, RunOnUiTread, Handler 이용해서 메인액티비티로 이동
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 토스트 메세지
                Toast.makeText(SplashActivity.this, "로그인 완료", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); // dialog 안보이게 하기
                // SplashAct -> MainAct 화면전환
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 1500);
        
    }
}