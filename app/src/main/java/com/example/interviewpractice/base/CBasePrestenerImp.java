package com.example.interviewpractice.base;

import com.example.interviewpractice.view.CategorytabView;

/**
 * Created by Administrator on 2017/12/28.
 */

public class CBasePrestenerImp <V extends CategorytabView , T> implements IBaseRequestCallBack<T> {
    private CBaseView cBaseView;

    public CBasePrestenerImp(V view) {
        this.cBaseView=view;
    }

    @Override
    public void beforeRequest() {

    }

    @Override
    public void requestComplete() {

    }

    @Override
    public void requestError(Throwable throwable) {

    }

    @Override
    public void requestSuccess(T callBack) {
        cBaseView.loadCagSuccess(callBack);
    }

}
