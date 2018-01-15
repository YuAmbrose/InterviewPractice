package com.example.interviewpractice.mvp.model;

import com.example.interviewpractice.http.IBaseRequestListCallBack;

/**
 * Created by Administrator on 2018/1/2.
 */

public interface CagModel<T> {
    void loadCategoryTab(IBaseRequestListCallBack<T> iBaseRequestCallBack);
}
