package com.example.interviewpractice.v_layout.holder;

import android.view.View;
import android.widget.TextView;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/23.
 */

public class HotHeadHolder extends VlayoutBaseHolder<BannerBean> {
    @BindView(R.id.title)
    TextView more;
    public HotHeadHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps,BannerBean mData) {
        super.setData(ps, mData);
    }

}
