package com.example.interviewpractice.mvp.homepage.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RankListBasePresenterImp  <V extends RankListBaseView,T> implements IBaseRequestCallBack<T> {
    private RankListBaseView rankListBaseView;
    public RankListBasePresenterImp(V view){
        this.rankListBaseView=view;
    }
    @Override
    public void requestError(Throwable throwable) {

    }

    @Override
    public void requestSuccess(T callBack) {
            rankListBaseView.rankSuccess(callBack);
    }
}
