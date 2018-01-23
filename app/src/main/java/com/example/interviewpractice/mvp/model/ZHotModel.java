package com.example.interviewpractice.mvp.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/23.
 */

public interface ZHotModel<T> {
    void loadHotNews(IBaseRequestCallBack<T> iBaseRequestCallBack);

}
