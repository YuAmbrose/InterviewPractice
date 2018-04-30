package com.example.interviewpractice.adapter.viewholder;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.hymane.expandtextview.ExpandTextView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.util.HashMap;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018/1/25.
 */

public class StartViewHolder extends BaseViewHolder<RecomendarMovie> {
    private JZVideoPlayerStandard jzVideo;
    private ExpandTextView dra;
    private static final String TAG = "StartViewHolder";
    public StartViewHolder(ViewGroup parent) {
        super(parent, R.layout.start_recyclerview_item);
        jzVideo=$(R.id.jzplayer);
        dra=$(R.id.des);
    }

    @Override
    public void setData(RecomendarMovie data) {
        super.setData(data);


        dra.setContent(data.getDescription());
        dra.setTitleTextSize(0);
        dra.setTitle("");
        dra.setAnimationDuration(60);

//        textView.setText("#"+data.getDescription());
        Log.e(TAG, "setData: "+data.getImagepng() );
        Glide.with(getContext())
                .load(data.getImagepng())
                .centerCrop()
                .into(jzVideo.thumbImageView);
        jzVideo.setUp(data.getMovieUrl(),jzVideo.SCREEN_WINDOW_NORMAL,"");
//        jzVideo.thumbImageView.setImageBitmap(getNetVideoBitmap(data.getMovieUrl()));
        jzVideo.startWindowTiny();
    }
    public static Bitmap getNetVideoBitmap(String videoUrl) {
        Bitmap bitmap = null;


       MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //根据url获取缩略图
            retriever.setDataSource(videoUrl, new HashMap());
            //获得第一帧图片
            bitmap = retriever.getFrameAtTime();
            Log.e(TAG, "getNetVideoBitmap: "+bitmap.getByteCount() );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            retriever.release();
        }
        return bitmap;
    }
}
