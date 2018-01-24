package com.example.interviewpractice.mvp.homepage.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/8.
 */

public class PgcBasePrestener <V extends PgcBaseView, T> implements IBaseRequestCallBack<T> {

    private PgcBaseView pgcBaseView = null;  //基类视图
    public PgcBasePrestener(V view) {
        this.pgcBaseView = view;
    }
    @Override
    public void requestError(Throwable throwable) {

    }

    /**
     * @descriptoin	请求成功获取成功之后的数据信息
     */
    @Override
    public void requestSuccess(T callBack) {
       pgcBaseView.loadPgc(callBack);
    }


}
