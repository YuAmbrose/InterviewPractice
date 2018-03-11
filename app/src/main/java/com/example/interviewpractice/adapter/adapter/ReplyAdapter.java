package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.ReplyViewHolder;
import com.example.interviewpractice.adapter.viewholder.StartViewHolder;
import com.example.interviewpractice.enity.EyReplyBean;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/3/10.
 */

public class ReplyAdapter extends RecyclerArrayAdapter<EyReplyBean.ReplyListBean> {
    public ReplyAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReplyViewHolder(parent);
    }
}
