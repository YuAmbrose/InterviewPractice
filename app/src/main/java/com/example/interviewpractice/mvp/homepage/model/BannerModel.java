package com.example.interviewpractice.mvp.homepage.model;


import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2017/12/26.
 */

public interface BannerModel<T> {
    /**
     * @descriptoin	获取网络数据
     */
    void loadBanner(IBaseRequestCallBack<T> iBaseRequestCallBack);
    /**
     * @descriptoin	注销subscribe
     */
    void onUnsubscribe();

//    void  loadRanklist(String strategy,int start,int num,IBaseRequestCallBack<T> iBaseRequestCallBack);

}
