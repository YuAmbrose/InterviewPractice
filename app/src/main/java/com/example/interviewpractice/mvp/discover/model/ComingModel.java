package com.example.interviewpractice.mvp.discover.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by 鱼握拳 on 2018/2/13.
 */

public interface ComingModel<T> {
    void  loadSuccessComing(IBaseRequestCallBack<T> iBaseRequestCallBack);
}
