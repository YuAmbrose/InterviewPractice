package com.example.interviewpractice.mvp.discover.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.mvp.discover.base.PrevueViewImp;
import com.example.interviewpractice.mvp.discover.model.PrevueModelImp;
import com.example.interviewpractice.mvp.discover.view.PrevueView;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public class PrevuePresenterImp extends PrevueViewImp<PrevueView,PrevueBean> implements PrevuePresenter {
   private PrevueModelImp prevueModelImp =null;
   private Context context;
    public PrevuePresenterImp(PrevueView view, Context context) {
        super(view);
        this.context=context;
        this.prevueModelImp =new PrevueModelImp(context);
    }

    @Override
    public void loadComingSuccess() {
        prevueModelImp.loadComing(this);

    }
}
