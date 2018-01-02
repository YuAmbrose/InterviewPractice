package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.BannerBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2018/1/2.
 */

public class RankListViewHolder extends BaseViewHolder<BannerBean.ItemListBean> {

    @BindView(R.id.iconhead)
    ImageView iconhead;
    @BindView(R.id.iconname)
    TextView iconname;
    @BindView(R.id.player)
    JCVideoPlayerStandard player;
    @BindView(R.id.description)
    TextView description;

    public RankListViewHolder(ViewGroup parent) {
        super(parent, R.layout.ranklist_item);

    }

    @Override
    public void setData(BannerBean.ItemListBean data) {
        super.setData(data);
        Glide.with(getContext()).load(data.getData().getProvider().getIcon()).into(iconhead);
        iconname.setText(data.getData().getProvider().getName());
        description.setText(data.getData().getDescription());
        Glide.with(getContext()).load(data.getData().getCover().getFeed()).into(player.thumbImageView);
        player.setUp(data.getData().getPlayUrl(),player.SCREEN_LAYOUT_NORMAL,data.getData().getTitle());
    }
}
