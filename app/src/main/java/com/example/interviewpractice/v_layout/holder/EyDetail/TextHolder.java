package com.example.interviewpractice.v_layout.holder.EyDetail;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.v_layout.VlayoutBaseAdapter;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by 鱼握拳 on 2018/2/18.
 */

public class TextHolder extends VlayoutBaseHolder<EyDetailBean> {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.layout)
    LinearLayout linearLayout;
    @BindView(R.id.titleDescription)
    TextView titleDescription;
    @BindView(R.id.iconhead)
    CircleImageView iconhead;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.description)
    TextView description;

    public TextHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, EyDetailBean cData) {
        super.setData(ps, cData);
        Glide.with(MyApplication.getContext())
                .load(cData.getAuthor().getIcon())
                .into(iconhead);
            title.setText(cData.getTitle());
            titleDescription.setText(cData.getDescription());
            name.setText(cData.getAuthor().getName());
            description.setText(cData.getAuthor().getDescription());
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(mView, position, mData);
                }
            });
    }
}
