package com.example.interviewpractice.v_layout.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;

import butterknife.BindView;


/**
 * Created by Moushao on 2017/8/30.
 */

public class GridHolder extends VlayoutBaseHolder<CategoryTab> {
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.func)
    TextView mFunc;

    public GridHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, CategoryTab data) {
        super.setData(ps, data);
        Glide.with(MyApplication.getContext())
                .load(data.getTypeIcon().getUrl())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mIcon);
        mFunc.setText(data.getType());
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
