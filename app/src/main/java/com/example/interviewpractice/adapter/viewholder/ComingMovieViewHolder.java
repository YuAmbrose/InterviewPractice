package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.utils.GlideManager;
import com.example.interviewpractice.utils.ImgSizeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 鱼握拳 on 2018/2/13.
 */

public class ComingMovieViewHolder extends BaseViewHolder<ComingMovieBean.DataBean.ComingBean> {
    private TextView name,time;
    private ImageView imageView;


    public  ComingMovieViewHolder(ViewGroup parent) {
        super(parent, R.layout.vlayout_forum_list);
        name=$(R.id.name);
        time=$(R.id.time);
        imageView=$(R.id.image);

    }

    @Override
    public void setData(ComingMovieBean.DataBean.ComingBean data) {
        super.setData(data);

        String iUrl= ImgSizeUtil.resetPicUrl(data.getImg(),".webp@321w_447h_1e_1c_1l");
        GlideManager.loadImage(MyApplication.getContext(),iUrl,imageView);
        name.setText(data.getNm());
        time.setText(data.getComingTitle());
    }
}
