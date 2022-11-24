package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // MainActivity 는 다른 클래스에서 new 로 생성하지 못함
    // Inflater 는 MainActivity 에서만 생성가능

    LinearLayout ln_layout, ln_layout2;
    int cnt = 0;
    LayoutInflater inflater;
    String str;
    Button btn_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 레이아웃 인플레이션 : xml 에 있는 내용이 메모리에 올라가는 부분
        // xml 파일과 java 파일이 연결되었는지?
        // view 타입이 null 이면 연결 x
        // R.layout.activity_main 에 있는 view 타입인지

        btn_new = findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity => Intent => SubActivity
                // 현재 액티비티에서 인텐트라는 객체를 통해 다음 액티비티 띄우기
                //                                            현재 액티비티, 다음 액티비티 클래스
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("sVal", "kwh");
                intent.putExtra("num1", 100); //오버로딩 메소드 putExtra

                ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
                for(int i = 0; i < 10; i++){
                    list.add(new MemberDTO("id"+i, "name"+i, i));
                }

                MemberDTO dto = new MemberDTO("id", "name", 1);
                intent.putExtra("dto", dto);
                intent.putExtra("list", list);


                startActivity(intent);
                // AppCompatActivity 를 상속받은 액티비티만 사용가능
            }
        });

        ln_layout = findViewById(R.id.ln_layout);
        ln_layout2 = findViewById(R.id.ln_layout2);
        inflater = getLayoutInflater();  // OS 에서 레이아웃을 붙이는 기능을 가진 객체를 줌
        View v1 = inflater.inflate(R.layout.layout_sub1, ln_layout, true);
        View v2 = inflater.inflate(R.layout.layout_sub2, ln_layout2, true);
        // 레이아웃을 붙이는 처리를 하면 xml 내용이 메모리에 올라감, 그리고 다시 return

        // 레이아웃을 붙이는 처리(=레이아웃 인플레이션)를 하면 붙은 레이아웃이 메모리에 올라가면서,
        // 레이아웃의 모든 내용을 View 타입으로 return 해줌.
        // return 해준 View 타입을 활용해서 위젯을 찾는다

        Button btn_sub2 = v2.findViewById(R.id.btn_sub2);
        TextView tv_sub2 = v2.findViewById(R.id.tv_sub2);

        btn_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoneContext noneContext = new NoneContext(inflater, str);

                noneContext.method1();

                noneContext.showToast(MainActivity.this);

                noneContext.v1Setting(v2);
            }
        });

        // ★ context ★
        // 현재 화면에 떠있는 객체에게 어떤 기능들을 사용할수있는 권한을 줌
        // Context <= Activity 를 넘겨주면 된다
        Toast.makeText(this, "메세지", Toast.LENGTH_SHORT).show();

    }

    public LayoutInflater rtn_inf(){
        return inflater;
    }

    public String rtn_str(){
        str = "aaa";
        return str;
    }
}