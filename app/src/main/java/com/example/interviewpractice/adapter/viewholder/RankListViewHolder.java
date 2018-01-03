package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.BannerBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2018/1/2.
 */

public class RankListViewHolder extends BaseViewHolder<BannerBean.ItemListBean> {

//    @BindView(R.id.iconhead)
//    ImageView iconhead;
//    @BindView(R.id.iconname)
//    TextView iconname;
//    @BindView(R.id.player)
//    JCVideoPlayerStandard player;
//    @BindView(R.id.description)
//    TextView description;
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
    public void setData(BannerBean.ItemListBean data) {
        super.setData(data);
        iconname.setText(data.getData().getAuthor().getName());
        title.setText("    #"+data.getData().getTitle());
        Glide.with(getContext())
                .load(data.getData().getCover().getFeed())
                .into(player.thumbImageView);
        player.setUp(data.getData().getPlayUrl(),player.SCREEN_LAYOUT_NORMAL,"");
        Glide.with(getContext())
                .load(data.getData().getAuthor().getIcon())
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(iconhead);
    }
}
