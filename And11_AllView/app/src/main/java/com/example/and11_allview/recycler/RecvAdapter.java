package com.example.and11_allview.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

//2. 밑에서 만든 ViewHolder를 이용해서 RecyclerViewAdapter를 상속받기
public class RecvAdapter extends RecyclerView.Adapter<RecvAdapter.MyViewHolder>{
    // ※ LayoutInflater ※ : 어댑터가 붙일수 있는 공간만 마련. 직접 붙이는 처리를 해주는 객체
    LayoutInflater inflater;

    public RecvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    //3. 직접 만든 ViewHolder를 실제로 만들고 return해주는 부분
    // MyViewHolder == 몇개의 위젯이 들어있는지 OS가 판단 x, 직접 커스텀해서 사용
    // 아이템마다 위젯의 종류나 갯수가 다르므로
    // BaseAdapter의 getView <==> 현) onCreateViewHolder
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_gridf_gridv, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    //5. 데이터가 있다면 position holder에 담겨있는 (칸) 위젯과 연결부분 ( Binding ) list와 position 연결
    // 이벤트 작업
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder h, int i) {
        h.btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h.iv1.getVisibility() == View.VISIBLE){
                    h.iv1.setVisibility(View.GONE);
                    h.iv2.setVisibility(View.VISIBLE);
                }else{
                    h.iv2.setVisibility(View.GONE);
                    h.iv1.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    //4. 아이템의 갯수 지정
    @Override
    public int getItemCount() {
        return 35;
    }

    // 포지션이 꼬여서 데이터 통제가 안되는 문제 해결법
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }


    //1. ViewHolder타입을 상속받은 innerClass ViewHolder를 만든다.
    // (이름은 관례상 ViewHolder)
    public class MyViewHolder extends RecyclerView.ViewHolder {
        //필요한 것들만 찾아쓰기
        ImageView iv1, iv2;
        Button btn_change;
        public MyViewHolder(@NonNull View v) {
            super(v);
            iv1 = v.findViewById(R.id.iv1);
            iv2 = v.findViewById(R.id.iv2);
            btn_change = v.findViewById(R.id.btn_change);
            //위젯을 찾아서 초기화하는 기능
        }

    }//ViewHolder

}
