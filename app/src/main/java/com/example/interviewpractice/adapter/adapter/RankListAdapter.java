package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.RankListViewHolder;
import com.example.interviewpractice.enity.BannerBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/1/1.
 */

public class RankListAdapter extends RecyclerArrayAdapter<BannerBean.ItemListBean> {
    public RankListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new RankListViewHolder(parent);
    }
}
