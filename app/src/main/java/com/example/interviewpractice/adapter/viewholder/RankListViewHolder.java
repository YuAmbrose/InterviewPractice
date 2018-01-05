package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RankListBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2018/1/2.
 */

public class RankListViewHolder extends BaseViewHolder<RankListBean.ItemListBean> {
    private ImageView iconhead;
    private TextView iconname,title;
    private JCVideoPlayerStandard player;

    public RankListViewHolder(ViewGroup parent) {
        super(parent, R.layout.ranklist_item);
        iconname=$(R.id.iconname);
        iconhead=$(R.id.iconhead);
        player=$(R.id.player);
        title=$(R.id.titleviewText);
    }

    @Override
    public void setData(RankListBean.ItemListBean data) {
        super.setData(data);
        iconname.setText(data.getData().getAuthor().getName());
        title.setText("    #"+data.getData().getTitle());
        Glide.with(getContext())
                .load(data.getData().getCover().getFeed())
                .into(player.thumbImageView);

//        JCVideoPlayer.toFullscreenActivity(this,
//                "http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
//                "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
//                "一行代码实现视频播放");
        player.setUp(data.getData().getPlayUrl(),player.SCREEN_LAYOUT_NORMAL,"");
        Glide.with(getContext())
                .load(data.getData().getAuthor().getIcon())
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(iconhead);
    }
}
