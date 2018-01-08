package com.example.interviewpractice.mvp.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/8.
 */

public interface PgcModel<T> {
    void loadPgc(IBaseRequestCallBack<T> iBaseRequestCallBack);
}
