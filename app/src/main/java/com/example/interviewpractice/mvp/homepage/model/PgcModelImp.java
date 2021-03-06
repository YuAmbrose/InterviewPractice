package com.example.interviewpractice.mvp.homepage.model;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/8.
 */

public class PgcModelImp extends BaseModel implements PgcModel {
    private Context context;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public PgcModelImp(Context mcontext){
        super();
        context=mcontext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void loadPgc(int start,int num,final  IBaseRequestCallBack iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getPgc(start,num,"71832b53062e4030b29af17f7ddfe6e5a82c43e7")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<PgcBean>() {
                    @Override
                    public void accept(PgcBean pgcBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(pgcBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));

    }
}
