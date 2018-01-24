package com.example.interviewpractice.mvp.homepage.presenter;

/**
 * Created by Administrator on 2017/12/26.
 */

public interface BannerPresenter{

    /**
     * @descriptoin	获取网络数据
     */
    void loadBanner();

    /**
     * @descriptoin	注销subscribe
     */
    void onUnsubscribe();

//    void loadRanklist(String strategy,int start,int num);
}

