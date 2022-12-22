package com.example.lastproject.customer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.lastproject.R;

import java.util.ArrayList;

public class CuAdapter extends RecyclerView.Adapter<CuAdapter.ViewHolder>{

    ArrayList<CustomerVO> list;
    LayoutInflater inflater;
    CustomerActivity activity;      //액티비티는 반드시 Intent 로

    public CuAdapter(ArrayList<CustomerVO> list, LayoutInflater inflater, CustomerActivity activity) {
        this.list = list;
        this.inflater = inflater;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_customer, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.id.setText(list.get(i).getId()+"");
        h.name.setText(list.get(i).getName());

        h.delete.setOnClickListener(v->{
            checkDelete(list.get(i).getId());
        });

        h.info.setOnClickListener(v->{
            //CustomDialog
            Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.dialog_detail_cus);

            DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
            int device_width = metrics.widthPixels;
            int device_height = metrics.heightPixels * 50/100;

            dialog.getWindow().setLayout(device_width,device_height);

            TextView id = dialog.findViewById(R.id.tv_id);
            TextView gender = dialog.findViewById(R.id.tv_gender);
            TextView name = dialog.findViewById(R.id.tv_name);
            TextView email = dialog.findViewById(R.id.tv_email);
            TextView phone = dialog.findViewById(R.id.tv_phone);

            id.setText(list.get(i).getId() + "");
            name.setText(list.get(i).getName());
            gender.setText(list.get(i).getGender());
            email.setText(list.get(i).getEmail());
            phone.setText(list.get(i).getPhone());

            dialog.show();//dismiss() -> 안보이게
        });

//        h.gender.setText(list.get(i).getGender());
//        h.email.setText(list.get(i).getEmail());
//        h.phone.setText(list.get(i).getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public int getItemViewType(int i){
        return i;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, gender, email, phone;
        Button info, modify, delete;
        public ViewHolder(@NonNull View v) {
            super(v);
            id = v.findViewById(R.id.tv_id);
            name = v.findViewById(R.id.tv_name);
//            gender = v.findViewById(R.id.tv_gender);
//            email = v.findViewById(R.id.tv_email);
//            phone = v.findViewById(R.id.tv_phone);

            info = v.findViewById(R.id.btn_info);
            modify = v.findViewById(R.id.btn_modify);
            delete = v.findViewById(R.id.btn_delete);
        }
    }

    //삭제시 한번 묻기
    public void checkDelete(int id){    //<= 네를 누르면 바로 삭제처리
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("고객 정보 삭제")
                .setMessage("삭제하시겠습니까?")
                .setIcon(R.drawable.ic_launcher_foreground);

        builder.setPositiveButton("네", (dialog, which) -> {
            //네 누르면 실행
            new CommonMethod().setParams("id", id)
                    .sendPost("delete.cu", (isResult, data) -> {
                        Log.d("logd", "onBindViewHolder: " + data);
                        activity.selectList();
                    });
        });
        builder.setNegativeButton("아니오", (dialog, which) -> {
            //아니오 누르면 실행

        });
        builder.create().show();
    }

}
