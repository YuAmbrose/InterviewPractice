package com.example.interviewpractice.adapter.viewholder;

import android.content.Intent;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.ui.activity.AuthorDetailActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.jzvd.JZVideoPlayerStandard;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2018/1/2.
 */

public class RankListViewHolder extends BaseViewHolder<RankListBean.ItemListBean> {
    private ImageView iconhead;
    private TextView iconname,title;
    private JZVideoPlayerStandard player;
    private LinearLayout linearLayout;
    public RankListViewHolder(ViewGroup parent) {
        super(parent, R.layout.ranklist_item);
        iconname=$(R.id.iconname);
        iconhead=$(R.id.iconhead);
        player=$(R.id.player);
        title=$(R.id.titleviewText);
        linearLayout=$(R.id.layout);
    }

    @Override
    public void setData(final RankListBean.ItemListBean data) {
        super.setData(data);
        iconname.setText(data.getData().getAuthor().getName());
        title.setText("    #"+data.getData().getTitle());

//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent anthorIntent=new Intent(MyApplication.getContext(), AuthorDetailActivity.class);
//                int id=data.getData().getAuthor().getId();
//                anthorIntent.putExtra("id",String.valueOf(id));
//                startActivity(anthorIntent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
//            }
//        });
//        JCVideoPlayer.toFullscreenActivity(this,
//                "http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
//                "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
//                "一行代码实现视频播放");
        Glide.with(getContext())
                .load(data.getData().getCover().getFeed())
                .into(player.thumbImageView);
        player.setUp(data.getData().getPlayUrl(),player.SCREEN_WINDOW_NORMAL,"");
        Glide.with(getContext())
                .load(data.getData().getAuthor().getIcon())
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(iconhead);
    }
}
