package com.example.interviewpractice.mvp.discover.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.mvp.discover.base.ComingBaseViewImp;
import com.example.interviewpractice.mvp.discover.base.HotMovieBasePresenterImp;
import com.example.interviewpractice.mvp.discover.model.ComingModelImp;
import com.example.interviewpractice.mvp.discover.model.HotMovieModelImp;
import com.example.interviewpractice.mvp.discover.view.ComingView;
import com.example.interviewpractice.mvp.discover.view.HotMovieView;

/**
 * Created by 鱼握拳 on 2018/2/13.
 */

public class ComingPresenterImp extends ComingBaseViewImp<ComingView,ComingMovieBean> implements  ComingPresenter {
private ComingModelImp comingModelImp=null;
private Context context;
public ComingPresenterImp(ComingView view,Context context) {
        super(view);
        this.context=context;
        this.comingModelImp=new ComingModelImp(context);
        }


    @Override
    public void loadComingListMovie() {
        comingModelImp.loadSuccessComing(this);
    }
}