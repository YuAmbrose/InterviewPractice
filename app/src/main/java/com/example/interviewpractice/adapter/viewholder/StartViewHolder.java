package com.example.interviewpractice.adapter.viewholder;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018/1/25.
 */

public class StartViewHolder extends BaseViewHolder<RecomendarMovie> {
    private JZVideoPlayerStandard jzVideo;
    private TextView textView;
    private static final String TAG = "StartViewHolder";
    public StartViewHolder(ViewGroup parent) {
        super(parent, R.layout.start_recyclerview_item);
        jzVideo=$(R.id.jzplayer);
        textView=$(R.id.des);
    }

    @Override
    public void setData(RecomendarMovie data) {
        super.setData(data);
        textView.setText("#"+data.getDescription());
        Log.e(TAG, "setData: "+data.getImagepng() );
        Glide.with(getContext())
                .load(data.getImagepng())
                .into(jzVideo.thumbImageView);
        jzVideo.setUp(data.getMovieUrl(),jzVideo.SCREEN_WINDOW_NORMAL,"");
        jzVideo.startWindowTiny();
    }
}
