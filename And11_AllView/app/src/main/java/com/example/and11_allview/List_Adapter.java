package com.example.and11_allview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//1. 일반 클래스 => 어탭터 타입의 클래스 ( extends : 상속 )
public class List_Adapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<ListDTO> list;
    // 5-1. 생성자 생성. DB 혹은 Activity 에서 파라미터를 받아올때
    public List_Adapter(LayoutInflater inflater, ArrayList<ListDTO> list){
        this.inflater = inflater;
        this.list = list;
    }

    //2. 리스트뷰에 들어가는 내용의 갯수 지정 (items count)
    //ex) 10건의 목록을 보여주고 싶으면 -> return 10;
    // ArrayList<Data> list => return list.size();
    @Override
    public int getCount() {
        return list.size();
    }

    //3. ArrayList<Data> list 가 있을 때, index 로 해당 칸의 정보를 빼올때 사용
    @Override
    public Object getItem(int position) {
        return position;
    }

    //4. 칸에 별도의 아이디를 주고 싶을때 사용. position 값은 절대 중복안되서 position 사용
    @Override
    public long getItemId(int position) {
        return position;
    }

    //5. 리스트뷰는 getCount 에서 지정된 칸만큼 getView 를 실행하면서
    //   한칸마다 ViewGroup 을 제공 (Layout) <= OS가 자동으로 해줌
    // ViewGroup 에 들어가는 내용을 붙이는거 개발자가 직접함.
    @Override
    public View getView(int i, View v, ViewGroup root) {
        // Layout 을 붙이는 처리를 해야함
        // ListAdapter 라는 클래스에서 LayoutInflater 사용하게
        v = inflater.inflate(R.layout.item_sub_listv, root, false);
        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_sub = v.findViewById(R.id.tv_sub);
        tv_name.setText(list.get(i).getName());
        tv_sub.setText(list.get(i).getCnt());
        return v;
    }
}
