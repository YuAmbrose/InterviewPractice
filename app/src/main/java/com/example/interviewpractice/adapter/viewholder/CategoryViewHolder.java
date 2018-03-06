package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.EyCategoryBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class CategoryViewHolder extends BaseViewHolder<EyCategoryBean> {
    private TextView name;
    private ImageView imageView;


    public  CategoryViewHolder(ViewGroup parent) {
        super(parent, R.layout.ey_category_item);
        name=$(R.id.name);
        imageView=$(R.id.bgPicture);

    }

    @Override
    public void setData(EyCategoryBean data) {
        super.setData(data);
        name.setText("#"+data.getName());
        Glide.with(MyApplication.getContext()).load(data.getBgPicture()).into(imageView);
    }
}

