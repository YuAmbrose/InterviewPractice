package com.example.interviewpractice.adapter.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.ui.activity.MorePPActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31/031.
 */

public class MoreAdapter extends BaseQuickAdapter<PgcBean.ItemListBean, BaseViewHolder> {
    public  MoreAdapter(@Nullable List<PgcBean.ItemListBean> data) {
        super(R.layout.more_anthor_item, data);
    }

    @Override
    protected void convert(BaseViewHolder  viewHolder, PgcBean.ItemListBean item) {
        viewHolder
                .setText(R.id.name, item.getData().getTitle())
                .setText(R.id.description,item.getData().getDescription());
        Glide.with(MyApplication.getContext())
                .load(item.getData().getIcon())
                .into((ImageView) viewHolder.getView(R.id.iconhead));
    }


}
