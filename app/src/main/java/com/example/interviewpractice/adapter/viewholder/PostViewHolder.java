package com.example.interviewpractice.adapter.viewholder;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.utils.util.TimeUtils;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by 鱼握拳 on 2018/3/24.
 */

public class PostViewHolder extends BaseViewHolder<Post> {
    private static final String TAG = "PostViewHolder";
    private ImageView iconhead;
    private TextView iconname,mainContent,time;
    public PostViewHolder(ViewGroup parent) {
        super(parent, R.layout.post_item);
        iconname=$(R.id.iconname);
        iconhead=$(R.id.iconhead);
        time=$(R.id.time);
        mainContent=$(R.id.text_content);
    }

    @Override
    public void setData(Post data) {
        super.setData(data);
        Glide.with(getContext())
                .load(R.mipmap.skybg)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(iconhead);
        Log.e(TAG, "setData: "+data.getAuthor().getLocalName() );
        iconname.setText(data.getAuthor().getLocalName() );
        mainContent.setText(data.getContent());
        time.setText(TimeUtils.format(data.getCreatedAt())+"    来自  "+data.getPhoneType());
    }
}