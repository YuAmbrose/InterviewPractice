package com.example.interviewpractice.mvp.discover.model;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMovieModelImp  extends BaseModel implements HotMovieModel<HotMovieBean> {
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public  HotMovieModelImp (Context mContext) {
        super();
        context = mContext;
        api = maoyanRetrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void loadList(final IBaseRequestCallBack<HotMovieBean> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getHotMovie()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<HotMovieBean>() {
                    @Override
                    public void accept(HotMovieBean hotMovieBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(hotMovieBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
}
