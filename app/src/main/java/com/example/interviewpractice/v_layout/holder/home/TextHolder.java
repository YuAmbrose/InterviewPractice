package com.example.interviewpractice.v_layout.holder.home;

import android.view.View;

import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;

/**
 * Created by Administrator on 2018/1/17.
 */

public  class  TextHolder extends VlayoutBaseHolder<RankListBean> {
    public TextHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RankListBean mData) {
        super.setData(ps, mData);
    }
    @Override
    public void init() {
        super.init();
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
