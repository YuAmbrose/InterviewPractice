package com.example.interviewpractice.mvp.discover.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public class PrevueViewImp<V extends PrevueBaseView,T> implements IBaseRequestCallBack<T> {
    private PrevueBaseView prevueBaseView;
    public PrevueViewImp(V view){
        this.prevueBaseView =view;
    }
    @Override
    public void requestError(Throwable throwable) {

    }

    @Override
    public void requestSuccess(T callBack) {
            prevueBaseView.loadMovieSuccess(callBack);
    }
}
