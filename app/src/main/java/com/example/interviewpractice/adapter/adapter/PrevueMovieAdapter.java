package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.PrevueMovieViewHolder;
import com.example.interviewpractice.enity.PrevueBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public class PrevueMovieAdapter extends RecyclerArrayAdapter<PrevueBean.DataBean> {
    public PrevueMovieAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PrevueMovieViewHolder(parent);
    }
}
