package com.example.interviewpractice.mvp.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/2.
 */

public interface CagModel<T> {
    void loadCategoryTab(IBaseRequestCallBack<T> iBaseRequestCallBack);
}
