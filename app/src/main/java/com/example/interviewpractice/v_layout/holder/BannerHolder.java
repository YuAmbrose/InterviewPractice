package com.example.interviewpractice.v_layout.holder;

import android.util.Log;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.utils.helper.GlideImageLoader;
import com.example.interviewpractice.v_layout.VBaseHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/11.
 */

public class BannerHolder extends VBaseHolder<BannerBean> {
    @BindView(R.id.banner)
    Banner banner;
    private static final String TAG = "BannerHolder";
    public BannerHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setData(int ps, BannerBean tData) {
        super.setData(ps, tData);
        if (tData.getIssueList() != null) {
            List<String> listImage = new ArrayList<>();
            List<String> listTitle = new ArrayList<>();
            for (int i =0; i <tData.getIssueList().get(0).getItemList().size(); i++) {
                    if (tData.getIssueList().get(0).getItemList().get(i).getType().equals("video")) {
                        listImage.add(tData.getIssueList().get(0).getItemList().get(i).getData().getCover().getFeed());
                        listTitle.add(tData.getIssueList().get(0).getItemList().get(i).getData().getTitle());
                    } else {

                        Log.e(TAG, "出错了");
                }
            }
            banner.setImages((List<?>) listImage)
                    .setImageLoader(new GlideImageLoader())
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setBannerTitles(listTitle)
                    .isAutoPlay(true);
            banner.start();
        }
    }
}
