package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.StartViewHolder;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2018/1/25.
 */

public class StartAdapter  extends RecyclerArrayAdapter<RecomendarMovie> {
    public StartAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new StartViewHolder(parent);
    }
}
