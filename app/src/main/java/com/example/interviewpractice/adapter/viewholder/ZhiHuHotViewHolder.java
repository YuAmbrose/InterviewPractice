package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.ZhihuHotBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ZhiHuHotViewHolder extends BaseViewHolder<ZhihuHotBean.RecentBean> {
    private TextView textView;
    private ImageView imageView;
    public ZhiHuHotViewHolder(ViewGroup parent) {
        super(parent, R.layout.zhihu_hot_item);
        imageView=$(R.id.image);
        textView=$(R.id.title);
    }

    @Override
    public void setData(ZhihuHotBean.RecentBean data) {
        super.setData(data);
        Glide.with(MyApplication.getContext()).load(data.getThumbnail()).into(imageView);
        textView.setText(data.getTitle());
    }
}
