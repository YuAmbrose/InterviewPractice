package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.utils.helper.GlideRoundTransform;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2018/1/8.
 */

public class PgcViewHolder extends BaseViewHolder<PgcBean.ItemListBean> {
        private ImageView bgVeiw;
        private ImageView icon;
        private TextView iconName,iconDes;
        public PgcViewHolder(ViewGroup parent) {
        super(parent, R.layout.pgc_recyclerview_item);
        bgVeiw=$(R.id.bgcolor);
        icon=$(R.id.iconPic);
        iconName=$(R.id.iconnametitle);
        iconDes=$(R.id.icondesc);

    }

    @Override
    public void setData(PgcBean.ItemListBean data) {
        super.setData(data);
        Glide.with(getContext())
                .load(data.getData().getIcon())
                .transform(new GlideRoundTransform(getContext(), 3))
                .bitmapTransform(new BlurTransformation(getContext(), 100, 3))
                .into(bgVeiw);

        Glide.with(getContext())
                .load(data.getData().getIcon())
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(icon);
        iconName.setText(data.getData().getTitle());
        iconDes.setText("      #"+data.getData().getDescription());
    }
}
