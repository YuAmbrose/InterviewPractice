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

public class PgcHeadHolder extends VlayoutBaseHolder<BannerBean> {
    @BindView(R.id.more)
    TextView more;
    public PgcHeadHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps,BannerBean mData) {
        super.setData(ps, mData);
    }
    @Override
    public void init() {
        super.init();
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
