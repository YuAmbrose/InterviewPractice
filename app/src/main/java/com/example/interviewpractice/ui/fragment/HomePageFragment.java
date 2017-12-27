package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.presenter.BannerPresenterImp;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.GlideImageLoader;
import com.example.interviewpractice.view.BannerView;
import com.example.interviewpractice.weight.IndicatorView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment implements BannerView {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.main_home_entrance_vp)
    ViewPager entranceViewPage;
    @BindView(R.id.main_home_entrance_indicator)
    IndicatorView entranceIndicatorView;
    @BindView(R.id.home_entrance)
    LinearLayout homeEntranceLayout;

    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        bannerPresenterImp.loadBanner();
        return view;
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void disimissProgress() {

    }

    @Override
    public void loadDataError(Throwable throwable) {
        bannerPresenterImp.requestError(throwable);
    }

    @Override
    public void loadDataSuccess(BannerBean tData) {
        Log.e("123", "loadDataSuccess: " + tData.toString());
        if (tData.getItemList() != null) {
            List<String> listImage = new ArrayList<>();
            List<String> listTitle = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                if (i == 5) {
                } else {
                    listImage.add(tData.getItemList().get(i).getData().getCover().getFeed());
                    listTitle.add(tData.getItemList().get(i).getData().getTitle());
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

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
