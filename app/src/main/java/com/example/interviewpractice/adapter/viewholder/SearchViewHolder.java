package com.example.interviewpractice.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.utils.helper.GlideRoundTransform;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鱼握拳 on 2018/5/1.
 */

public class SearchViewHolder extends BaseViewHolder<RankListBean.ItemListBean> {
    private ImageView imageView;
    private TextView timer,title,type;
    private LinearLayout linearLayout;
    private List<RankListBean.ItemListBean> itemListBeans=new ArrayList<>();
    public SearchViewHolder(ViewGroup parent) {
        super(parent, R.layout.home_recyclerview_item);
        imageView=$(R.id.bgPic);
        timer=$(R.id.timer);
        title=$(R.id.title);
        type=$(R.id.type);
        linearLayout=$(R.id.linear);
    }

    @Override
    public void setData(RankListBean.ItemListBean data) {
        super.setData(data);

        if (data.getType().equals("video")){
            title.setText(data.getData().getTitle());
            type.setText("#"+data.getData().getCategory());
            SimpleDateFormat format=new SimpleDateFormat("mm:ss");
            short time=new Short((short) data.getData().getDuration());
            int t=time*1000;
            String d=format.format(t);
            timer.setText(d);
            Glide.with(MyApplication.getContext())
                    .load(data.getData().getCover().getFeed())
                    .transform(new GlideRoundTransform(getContext(), 8))
                    .into(imageView);
        }
 else {
           linearLayout.setLayoutParams(new LinearLayout.LayoutParams(400, 0));
            linearLayout.setVisibility(View.GONE);
        }
    }

}
