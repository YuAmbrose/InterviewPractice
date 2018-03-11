package com.example.interviewpractice.v_layout.holder.EyDetail;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 鱼握拳 on 2018/3/11.
 */

public class TagsHolder  extends VlayoutBaseHolder<EyDetailBean> {

//    @BindView(R.id.layout)
//    FrameLayout frameLayout;
//    @BindView(R.id.tags)
//    TextView tags;
    @BindView(R.id.image)
    ImageView imageView;
    private static final String TAG = "TagsHolder";
    private List<EyDetailBean.TagsBean> tagsBeans=new ArrayList<>();
    public TagsHolder (View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, EyDetailBean cData) {
        super.setData(ps, cData);
        tagsBeans=cData.getTags();
//        Glide.with(MyApplication.getContext()).load(cData.getTags().get(1).getBgPicture()).into(imageView);
//        for (int i = 0; i <tagsBeans.size() ; i++) {
//            Glide.with(MyApplication.getContext()).load(tagsBeans.get(i).getBgPicture()).into(imageView);
//            tags.setText("#"+tagsBeans.get(i).getName()+"#");
//        }
    }
}
