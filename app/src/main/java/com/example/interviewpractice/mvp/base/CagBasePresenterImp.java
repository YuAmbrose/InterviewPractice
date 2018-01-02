package com.example.interviewpractice.mvp.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/2.
 */

public class CagBasePresenterImp <V extends CagBaseView, T> implements IBaseRequestCallBack<T> {

    private CagBaseView cagBaseView = null;  //基类视图
    public CagBasePresenterImp (V view) {
        this.cagBaseView = view;
    }
    @Override
    public void requestError(Throwable throwable) {

    }

    /**
     * @descriptoin	请求成功获取成功之后的数据信息
     */
    @Override
    public void requestSuccess(T callBack) {
       cagBaseView.loadCagSuccess(callBack);
    }


}
