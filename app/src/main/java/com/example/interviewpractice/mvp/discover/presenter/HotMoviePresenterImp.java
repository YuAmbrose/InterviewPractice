package com.example.interviewpractice.mvp.discover.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.mvp.discover.base.HotMovieBasePresenterImp;
import com.example.interviewpractice.mvp.discover.model.HotMovieModelImp;
import com.example.interviewpractice.mvp.discover.view.HotMovieView;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMoviePresenterImp extends HotMovieBasePresenterImp<HotMovieView,HotMovieBean> implements  HotMoviePresenter {
    private HotMovieModelImp hotMovieModelImp=null;
    private Context context;
    public HotMoviePresenterImp(HotMovieView view,Context context) {
        super(view);
        this.context=context;
        this.hotMovieModelImp=new HotMovieModelImp(context);
        }

    @Override
    public void loadHotMovie() {
            hotMovieModelImp.loadList(this);
    }
}
