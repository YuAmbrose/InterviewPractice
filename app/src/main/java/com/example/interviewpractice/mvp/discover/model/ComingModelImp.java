package com.example.interviewpractice.mvp.discover.model;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 鱼握拳 on 2018/2/13.
 */

public class ComingModelImp extends BaseModel implements ComingModel<ComingMovieBean> {
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public  ComingModelImp (Context mContext) {
        super();
        context = mContext;
        api = maoyanRetrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadSuccessComing(final  IBaseRequestCallBack<ComingMovieBean> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getComingList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ComingMovieBean>() {
                    @Override
                    public void accept(ComingMovieBean comingMovieBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(comingMovieBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));

    }
}
