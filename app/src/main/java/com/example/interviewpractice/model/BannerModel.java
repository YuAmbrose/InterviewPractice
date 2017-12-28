package com.example.interviewpractice.model;

import com.example.interviewpractice.base.IBaseRequestCallBack;

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

    void loadCategoryTab(IBaseRequestCallBack<T> iBaseRequestCallBack);
}
