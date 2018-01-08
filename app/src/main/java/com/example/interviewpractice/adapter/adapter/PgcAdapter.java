package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.PgcViewHolder;
import com.example.interviewpractice.enity.PgcBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2018/1/8.
 */

public class PgcAdapter extends RecyclerArrayAdapter<PgcBean.ItemListBean> {
    public PgcAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PgcViewHolder(parent);
    }
}
