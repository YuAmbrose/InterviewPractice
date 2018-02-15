package com.example.interviewpractice.mvp.discover.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by 鱼握拳 on 2018/2/13.
 */

public class ComingBaseViewImp  <V extends  ComingBaseView,T> implements IBaseRequestCallBack<T> {
    private ComingBaseView comingBaseView;
    public  ComingBaseViewImp(V view){
        this.comingBaseView=view;
    }
    @Override
    public void requestError(Throwable throwable) {

    }

    @Override
    public void requestSuccess(T callBack) {
        comingBaseView.loadComingMovie(callBack);
    }
}

