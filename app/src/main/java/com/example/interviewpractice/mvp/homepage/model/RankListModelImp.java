package com.example.interviewpractice.mvp.homepage.model;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RankListModelImp extends BaseModel implements  RankListModel<RankListBean>{
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public RankListModelImp(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void loadRankList(String strategy, int start, int num, final IBaseRequestCallBack<RankListBean> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getRankList(strategy,start,num)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RankListBean>() {
                    @Override
                    public void accept(RankListBean bannerBean) throws Exception {
                       iBaseRequestCallBack.requestSuccess(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    @Override
    public void loadSelected(int start,int num,final IBaseRequestCallBack<RankListBean> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getSelected(start,num)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RankListBean>() {
                    @Override
                    public void accept(RankListBean bannerBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
}
