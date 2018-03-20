package com.example.interviewpractice.mvp.mine.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by 鱼握拳 on 2018/3/20.
 */

public interface UpdateModel<T> {
    void  loadUpdate(IBaseRequestCallBack<T> iBaseRequestCallBack);
}
