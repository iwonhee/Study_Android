package com.example.project_burgerking.kingOrder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_burgerking.R;
import com.example.project_burgerking.databinding.FragmentSearch2Binding;

import java.util.ArrayList;

public class Search2Fragment extends Fragment {
    FragmentSearch2Binding b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentSearch2Binding.inflate(inflater);

        String textDetail = "드라이브스루 주문은 현재위치에서 2km이내 매장에만 가능하며, 픽업방법은 드라이브스루 픽업만 가능합니다.";

        // 찾은 결과 ArrayList 에 넣기 (지도 api 되면!)
        ArrayList<String> list = new ArrayList<>();

        String textCnt = list.size()+"개의 검색결과가 있습니다";
        // 결과 없으면 결과없음 이미지 보이기
        if(list.size()==0){
            b.relNoResult.setVisibility(View.VISIBLE);
        }else{
            b.relNoResult.setVisibility(View.GONE);
        }

        // 텍스트 일부만 색 바꾸기
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(textDetail);
        stringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.icon_red))
                , 18, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        b.tvKingOrderDetail.append(stringBuilder);

        SpannableStringBuilder cntBuilder = new SpannableStringBuilder(textCnt);
        cntBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.icon_red))
                , 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        b.tvSearchCnt.append(cntBuilder);


        // 어댑터 연결
        b.recvSearch.setAdapter(new SearchAdapter(inflater, list));
        b.recvSearch.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        return b.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}