package com.example.interviewpractice.mvp.homepage.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.mvp.homepage.base.PgcBasePrestener;
import com.example.interviewpractice.mvp.homepage.model.PgcModelImp;
import com.example.interviewpractice.mvp.homepage.view.PgcView;

/**
 * Created by Administrator on 2018/1/8.
 */

public class PgcPresenterImp extends PgcBasePrestener<PgcView,PgcBean> implements PgcPresenter {
    private Context context;
    private PgcModelImp pgcModelImp;
    public PgcPresenterImp(PgcView view, Context context) {
        super(view);
        this.context=context;
        this.pgcModelImp=new PgcModelImp(context);
    }

    @Override
    public void loadPgc(int start,int num) {
        pgcModelImp.loadPgc(start,num,this);
    }
}
