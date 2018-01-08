package com.example.interviewpractice.mvp.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.mvp.base.PgcBasePrestener;
import com.example.interviewpractice.mvp.model.PgcModelImp;
import com.example.interviewpractice.mvp.view.PgcView;

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
    public void loadPgc() {
        pgcModelImp.loadPgc(this);
    }
}
