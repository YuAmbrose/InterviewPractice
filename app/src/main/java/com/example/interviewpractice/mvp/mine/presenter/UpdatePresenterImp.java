package com.example.interviewpractice.mvp.mine.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.UpdateAppInfo;
import com.example.interviewpractice.mvp.mine.base.UpdateBaseViewImp;
import com.example.interviewpractice.mvp.mine.model.UpdateModelImp;
import com.example.interviewpractice.mvp.mine.view.UpdateView;

/**
 * Created by 鱼握拳 on 2018/3/20.
 */

public class UpdatePresenterImp extends UpdateBaseViewImp<UpdateView,UpdateAppInfo> implements UpdatePresenter {
        private UpdateModelImp updateModelImp;
        private Context context;

    public UpdatePresenterImp(UpdateView view,Context context) {
        super(view);
        this.context=context;
        this.updateModelImp=new UpdateModelImp(context);
    }

    @Override
    public void loadUpdateApp() {
                updateModelImp.loadUpdate(this);
    }
}
