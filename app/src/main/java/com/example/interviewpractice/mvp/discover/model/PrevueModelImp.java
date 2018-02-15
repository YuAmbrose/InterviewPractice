package com.example.interviewpractice.mvp.discover.model;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public class PrevueModelImp extends BaseModel implements PrevueModel<PrevueBean> {
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public PrevueModelImp(Context mContext) {
        super();
        context = mContext;
        api = maoyanRetrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void loadComing(final  IBaseRequestCallBack<PrevueBean> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getComingMovie()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<PrevueBean>() {
                    @Override
                    public void accept(PrevueBean prevueBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(prevueBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

}
