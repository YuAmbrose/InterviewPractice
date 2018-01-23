package com.example.interviewpractice.mvp.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ZHotBasePrsenterImp <V extends ZHotBaseView,T> implements IBaseRequestCallBack<T> {
    private ZHotBaseView zHotBaseView;
    public ZHotBasePrsenterImp(V view){
        this.zHotBaseView=view;
    }
    @Override
    public void requestError(Throwable throwable) {

    }

    @Override
    public void requestSuccess(T callBack) {
            zHotBaseView.loadSuccess(callBack);
    }
}
