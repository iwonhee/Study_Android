package com.example.project01_clone.chat_temp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

// 리사이클러뷰는 반드시 뷰홀더를 강제하기 때문에 밑에서 ViewHolder 만들고 Adapter 상속 받는다
public class ChatTempAdapter extends RecyclerView.Adapter<ChatTempAdapter.ViewHolder> {
    ArrayList<ChatTempDTO> list;
    LayoutInflater inflater;
    Context context;

    public ChatTempAdapter(LayoutInflater inflater, ArrayList<ChatTempDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_chattemp, parent, false));
    }

    @Override   // Binding, bind : 요소끼리 데이터 연결
    public void onBindViewHolder(@NonNull ViewHolder v, int i) {
        v.tv_chat_temp_name.setText(list.get(i).getChat_name());
        v.tv_chat_temp_message.setText(list.get(i).getChat_msg());

        v.lin_item_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context con_temp = v.getContext(); // LinearLayout(item)은 Context를 가지고있음(MainActivity)

                Intent intent = new Intent(context, ChatDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }

    // 위젯들을 재활용하기 위해서 묶어두기위한(메모리에 올려두기) 위젯용 DTO(ViewHolder)
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_chat_temp_name, tv_chat_temp_message;
        ImageView iv_chat_temp_pro;
        LinearLayout lin_item_temp;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_chat_temp_name = v.findViewById(R.id.tv_chat_temp_name);
            tv_chat_temp_message = v.findViewById(R.id.tv_chat_temp_message);
            iv_chat_temp_pro = v.findViewById(R.id.iv_chat_temp_pro);
            lin_item_temp = v.findViewById(R.id.lin_item_temp);
        }
    }
}
