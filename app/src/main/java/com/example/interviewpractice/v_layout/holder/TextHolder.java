package com.example.interviewpractice.v_layout.holder;

import android.view.View;

import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VBaseHolder;

/**
 * Created by Administrator on 2018/1/17.
 */

public  class  TextHolder extends VBaseHolder<RankListBean> {
    public TextHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RankListBean mData) {
        super.setData(ps, mData);
    }
}
