package com.example.interviewpractice.mvp.homepage.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/8.
 */

public interface PgcModel<T> {
    void loadPgc(int start,int num,IBaseRequestCallBack<T> iBaseRequestCallBack);
}
