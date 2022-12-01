package com.example.and11_allview.listfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView list_flag;
    TextView tv_name, tv_upload_tiem;
    ImageView iv_main, iv_star, iv_new;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ArrayList<FragDTO> list = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            list.add(new FragDTO(tv_name, tv_upload_tiem, iv_main, iv_star, iv_new));
        }

        Frag_Adapter frag_adapter = new Frag_Adapter(getLayoutInflater(), list);
        list_flag = v.findViewById(R.id.listv_frag);
        list_flag.setAdapter(frag_adapter);


        return v;
    }
}