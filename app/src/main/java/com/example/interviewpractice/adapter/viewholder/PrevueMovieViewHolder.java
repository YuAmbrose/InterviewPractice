package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.PrevueBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public class PrevueMovieViewHolder extends BaseViewHolder<PrevueBean.DataBean> {
    private JZVideoPlayerStandard player;
    private TextView originName;


    public PrevueMovieViewHolder(ViewGroup parent) {
        super(parent, R.layout.vlayout_forum_cmitem);
        player=$(R.id.player);
        originName=$(R.id.originName);

    }

    @Override
    public void setData(PrevueBean.DataBean data) {
        super.setData(data);

        Glide.with(getContext())
                .load(data.getImg())
                .into(player.thumbImageView);
        player.setUp(data.getUrl(),player.SCREEN_WINDOW_NORMAL,"");
       originName.setText("  #"+data.getName());

    }
}
