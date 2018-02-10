package com.example.interviewpractice.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.utils.GlideManager;
import com.example.interviewpractice.utils.ImgSizeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMovieViewHolder extends BaseViewHolder<HotMovieBean.DataBean.MoviesBean> {
    private ImageView bgPic;
    private  TextView name;
    private  TextView sc;
    private  TextView pubDesc;
    private  TextView star;

    public HotMovieViewHolder(ViewGroup parent) {
        super(parent, R.layout.vlayout_forum_ryitem);
        bgPic=$(R.id.bgPic);
        name=$(R.id.name);
        sc=$(R.id.sc);
        pubDesc=$(R.id.pubDesc);
        star=$(R.id.star);
    }

    @Override
    public void setData(HotMovieBean.DataBean.MoviesBean data) {
        super.setData(data);

        String imgUrl = ImgSizeUtil.resetPicUrl(data.getImg(), ".webp@321w_447h_1e_1c_1l");
        GlideManager.loadImage(MyApplication.getContext(),imgUrl,bgPic);
        name.setText(data.getNm());
//        sc.setText((int) data.getSc());
        pubDesc.setText(data.getPubDesc());
        star.setText("主演："+data.getStar());
    }
}
