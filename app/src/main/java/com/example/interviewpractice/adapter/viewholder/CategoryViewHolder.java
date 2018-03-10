package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.Cag;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class CategoryViewHolder extends BaseViewHolder<Cag> {
    private TextView name;
    private ImageView imageView;
    private FrameLayout frameLayout;


    public  CategoryViewHolder(ViewGroup parent) {
        super(parent, R.layout.ey_category_item);
        name=$(R.id.name);
        imageView=$(R.id.bgPicture);
        frameLayout=$(R.id.fragout);

    }

    @Override
    public void setData(Cag data) {
        super.setData(data);
//        if (data.getData().getId()>=2){
            name.setText("#"+data.getName());
            Glide.with(MyApplication.getContext()).load(data.getBgPicture()).into(imageView);
//        }else {
//            frameLayout.setVisibility(View.GONE);
//        }

    }


}

