package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.EyReplyBean;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 鱼握拳 on 2018/3/10.
 */

public class ReplyViewHolder extends BaseViewHolder<EyReplyBean.ReplyListBean> {

    private  TextView titleDescription;
   private  CircleImageView iconhead;
   private TextView name;
public ReplyViewHolder(ViewGroup parent) {
        super(parent, R.layout.vlayout_eydetail_reply_item);
        name=$(R.id.name);
        iconhead=$(R.id.iconhead);
        titleDescription=$(R.id.description);
        }

    @Override
    public void setData(EyReplyBean.ReplyListBean data) {
        super.setData(data);
        Glide.with(MyApplication.getContext()).load(data.getUser().getAvatar()).into(iconhead);
        titleDescription.setText(data.getMessage());
        name.setText(data.getUser().getNickname());
    }
}
