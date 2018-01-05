package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.HomeRecyclerViewHolder;
import com.example.interviewpractice.enity.RankListBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2018/1/5.
 */

public class HomeRecyclervAdapter extends RecyclerArrayAdapter<RankListBean.ItemListBean> {
    public HomeRecyclervAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeRecyclerViewHolder(parent);
    }
}
