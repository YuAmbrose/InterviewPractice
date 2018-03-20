package com.example.interviewpractice.mvp.mine.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.mvp.discover.base.ComingBaseView;

/**
 * Created by 鱼握拳 on 2018/3/20.
 */

public class UpdateBaseViewImp <V extends UpdateBaseView,T> implements IBaseRequestCallBack<T> {
    private UpdateBaseView updateBaseView=null;
    public  UpdateBaseViewImp(V view){
        this.updateBaseView=view;
    }
    @Override
    public void requestError(Throwable throwable) {

    }

    @Override
    public void requestSuccess(T callBack) {
        updateBaseView.UpdateApp(callBack);
    }
}


