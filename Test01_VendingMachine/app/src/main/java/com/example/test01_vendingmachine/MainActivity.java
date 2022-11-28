package com.example.test01_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<DrinkDTO> list;
    TextView tv_money;
    EditText edt_money;
    Button btn_input, btn_return;
    int money;  //금액을 누적시킬 변수
    HashMap<String, DrinkDTO> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_money = findViewById(R.id.tv_money);
        edt_money = findViewById(R.id.edt_money);
        btn_input = findViewById(R.id.btn_input);
        btn_return = findViewById(R.id.btn_return);

        tv_money.setText("0원");
        btn_input.setOnClickListener(this);
        btn_return.setOnClickListener(this);

        list = new ArrayList<DrinkDTO>();

        list.add(new DrinkDTO("콜라", 800, 10, findViewById(R.id.tv_name1)
                , findViewById(R.id.tv_ctn1), findViewById(R.id.btn_order1)));
        list.add(new DrinkDTO("사이다", 800, 8, findViewById(R.id.tv_name2)
                , findViewById(R.id.tv_ctn2), findViewById(R.id.btn_order2)));
        list.add(new DrinkDTO("환타", 500, 12, findViewById(R.id.tv_name3)
                , findViewById(R.id.tv_ctn3), findViewById(R.id.btn_order3)));
        list.add(new DrinkDTO("데미소다", 900, 15, findViewById(R.id.tv_name4)
                , findViewById(R.id.tv_ctn4), findViewById(R.id.btn_order4)));

        for(int i = 0; i < list.size(); i++){
            list.get(i).getBtn_order().setOnClickListener(this);
            list.get(i).getBtn_order().setTag(i+"");  // 각 버튼에 Tag 붙이기
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_input){
            tv_money.setText(edt_money.getText());
            if(edt_money.getText().toString().length() < 1){
                return;
            }
            money += Integer.parseInt(edt_money.getText()+"");
            tv_money.setText(money+"원");
            edt_money.setText("");
        }else if(v.getId()==R.id.btn_return){
            //잔돈반환
        }else{
            int index = Integer.parseInt(v.getTag()+"");
            if(list.get(index).getCnt()==0) {
                Toast.makeText(this, "재고부족", Toast.LENGTH_SHORT).show();
                return;
            }else if(money < list.get(index).getPrice()){
                Toast.makeText(this, "금액부족", Toast.LENGTH_SHORT).show();
                return;
            }
            money -= list.get(index).getPrice();
            tv_money.setText(money+"");
            list.get(index).setCnt(list.get(index).getCnt()-1); // 기존수량 - 1
        }
    }
}