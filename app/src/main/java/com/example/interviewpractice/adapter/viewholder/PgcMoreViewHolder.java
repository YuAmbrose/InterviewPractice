package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.PgcBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 鱼握拳 on 2018/3/5.
 */

public class PgcMoreViewHolder extends BaseViewHolder<PgcBean.ItemListBean> {

    private TextView title;
    private TextView description;
    private  CircleImageView iconhead;
    public PgcMoreViewHolder(ViewGroup parent) {
        super(parent, R.layout.more_anthor_item);
        iconhead=$(R.id.iconhead);
        title=$(R.id.name);
        description=$(R.id.description);
    }

    @Override
    public void setData(PgcBean.ItemListBean data) {
        super.setData(data);
        Glide.with(MyApplication.getContext())
                .load(data.getData().getIcon())
                .into(iconhead);
        title.setText(data.getData().getTitle());
        description.setText(data.getData().getDescription());

    }
}
