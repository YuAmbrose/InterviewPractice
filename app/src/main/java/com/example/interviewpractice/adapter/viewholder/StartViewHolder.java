package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.jzvd.JZVideoPlayer;

/**
 * Created by Administrator on 2018/1/25.
 */

public class StartViewHolder extends BaseViewHolder<RecomendarMovie> {
    private JZVideoPlayer jzVideo;
    private TextView textView;
    public StartViewHolder(ViewGroup parent) {
        super(parent, R.layout.start_recyclerview_item);
        jzVideo=$(R.id.jzplayer);
        textView=$(R.id.des);
    }

    @Override
    public void setData(RecomendarMovie data) {
        super.setData(data);
        textView.setText("#"+data.getDescription());

//        Glide.with(getContext())
//                .load(data.getImageUrl().getUrl())
//                .into(jzVideo.thumbImageView);
        jzVideo.setUp(data.getMovieUrl(),jzVideo.SCREEN_WINDOW_NORMAL,"");
    }
}
