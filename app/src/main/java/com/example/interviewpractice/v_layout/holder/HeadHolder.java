package com.example.interviewpractice.v_layout.holder;

import android.view.View;
import android.widget.TextView;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VBaseHolder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/15.
 */

public class HeadHolder extends VBaseHolder<RankListBean> {
    private static final String TAG = "HeadHolder";
    @BindView(R.id.head)
    TextView textView;
    public HeadHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RankListBean mData) {
        super.setData(ps, mData);

    }
}
