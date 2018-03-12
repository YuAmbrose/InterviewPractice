package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.PgcViewHolder;
import com.example.interviewpractice.enity.PgcBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/3/12.
 */

public class EyPopularAdapter extends RecyclerArrayAdapter<PgcBean.ItemListBean> {
    public EyPopularAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PgcViewHolder(parent);
    }
}
