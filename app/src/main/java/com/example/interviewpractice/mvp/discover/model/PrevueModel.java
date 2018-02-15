package com.example.interviewpractice.mvp.discover.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public interface PrevueModel<T>{
    void loadComing(IBaseRequestCallBack<T> iBaseRequestCallBack);
}
