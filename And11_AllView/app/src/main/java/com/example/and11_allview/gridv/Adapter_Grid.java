package com.example.and11_allview.gridv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.example.and11_allview.R;

public class Adapter_Grid extends BaseAdapter {
    LayoutInflater inflater;

    public Adapter_Grid(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    int count = 0;
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(v == null){
            v = inflater.inflate(R.layout.item_gridf_gridv, parent, false);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);    // Tag Oject 형태여서 뭐든 담을 수 있음
            count++;
        }else{
            if(v.getTag() != null){
                viewHolder = (ViewHolder) v.getTag();
            }
        }

        final ViewHolder tempViewHolder = viewHolder;   // 또 쓰려면 final 로 변하지 않는 상수로 지정
        viewHolder.btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // index == 0 ( iv1, iv2, btn_change )
                if(tempViewHolder.iv1.getVisibility() == View.VISIBLE){
                    tempViewHolder.iv1.setVisibility(View.GONE);
                    tempViewHolder.iv2.setVisibility(View.VISIBLE);
                }else{
                    tempViewHolder.iv2.setVisibility(View.GONE);
                    tempViewHolder.iv1.setVisibility(View.VISIBLE);
                }
            }
        });

        Log.d("로그", "getView: " + count);
        return v;
    }

    // RecyclerView : view 한번 붙여놓은 아이템을 메모리에 저장해놨다가 다시 사용하는 구조
    //★위젯을 묶어놓은 DTO ==> ViewHolder (Inner class로 많이 사용) ==> 외부클래스로도 한번 해보기
    // RecyclerView는 ViewHolder라는 클래스를 강제한다( 무조건 만들어야함 )
    public class ViewHolder{
        //필드 : 위젯을 전부 써줌
        ImageView iv1, iv2;
        Button btn_change;

        public ViewHolder(View v) {     // 한 칸에 붙인 item 정보
            iv1 = v.findViewById(R.id.iv1);
            iv2 = v.findViewById(R.id.iv2);
            btn_change = v.findViewById(R.id.btn_change);
        }
    }

}
