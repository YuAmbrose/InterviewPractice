package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.HotMovieViewHolder;
import com.example.interviewpractice.enity.HotMovieBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMovieAdapter extends RecyclerArrayAdapter<HotMovieBean.DataBean.MoviesBean> {
    public HotMovieAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotMovieViewHolder(parent);
    }
}
