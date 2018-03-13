package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.utils.helper.GlideRoundTransform;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 鱼握拳 on 2018/3/14.
 */

public class CagViewHolder extends BaseViewHolder<RankListBean.ItemListBean> {
private ImageView imageView;
private TextView timer,name,description;
private CircleImageView circleImageView;
public CagViewHolder(ViewGroup parent) {
        super(parent, R.layout.cag_item);
        imageView=$(R.id.bgPic);
        timer=$(R.id.timer);
        name=$(R.id.name);
        description=$(R.id.description);
        circleImageView=$(R.id.iconhead);
        }

@Override
public void setData(RankListBean.ItemListBean data) {
        super.setData(data);
        SimpleDateFormat format=new SimpleDateFormat("mm:ss");
        short time=new Short((short) data.getData().getDuration());
        int t=time*1000;
        String d=format.format(t);
        timer.setText(d);
        Glide.with(MyApplication.getContext())
        .load(data.getData().getCover().getFeed())
        .transform(new GlideRoundTransform(getContext(), 8))
        .into(imageView);
        description.setText(data.getData().getAuthor().getDescription());
        Glide.with(MyApplication.getContext()).load(data.getData().getAuthor().getIcon()).into(circleImageView);
        name.setText(data.getData().getAuthor().getName());
        }
        }
