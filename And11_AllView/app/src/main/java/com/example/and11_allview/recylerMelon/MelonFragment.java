package com.example.and11_allview.recylerMelon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class MelonFragment extends Fragment {
    RecyclerView recv_melon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_melon, container, false);

        recv_melon = v.findViewById(R.id.recv_melon);

        ArrayList<MelonDTO> list = new ArrayList<>();
        list.add(new MelonDTO("사건의 지평선", "윤하", R.drawable.img1));
        list.add(new MelonDTO("ANTIFRAGILE", "LE SSERAFIM", R.drawable.img2));
        list.add(new MelonDTO("Hype boy", "NewJeans", R.drawable.img3));
        list.add(new MelonDTO("Nxde", "(여자)아이들", R.drawable.img4));
        list.add(new MelonDTO("After LIKE", "IVE(아이브)", R.drawable.img5));

        recv_melon.setAdapter(new MelonAdapter(inflater, list));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        );
        recv_melon.setLayoutManager(manager);

        return v;
    }
}