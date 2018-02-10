package com.example.interviewpractice.v_layout.holder.home;

import android.view.View;
import android.widget.TextView;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/1/23.
 */

public class EndHolder extends VlayoutBaseHolder<BannerBean> {

public EndHolder(View itemView) {
        super(itemView);
        }

@Override
public void setData(int ps,BannerBean mData) {
        super.setData(ps, mData);
        }

        }
