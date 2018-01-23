package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.ZhiHuHotViewHolder;
import com.example.interviewpractice.enity.ZhihuHotBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ZhiHuAdapter  extends RecyclerArrayAdapter<ZhihuHotBean.RecentBean>{
    public ZhiHuAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZhiHuHotViewHolder(parent);
    }
}
