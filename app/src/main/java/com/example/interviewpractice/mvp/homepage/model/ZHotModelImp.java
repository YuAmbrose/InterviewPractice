package com.example.interviewpractice.mvp.homepage.model;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.ZhihuHotBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ZHotModelImp extends BaseModel implements  ZHotModel<ZhihuHotBean> {
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public ZHotModelImp(Context mContext) {
        super();
        context = mContext;
        api = zhRetrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void loadHotNews(final IBaseRequestCallBack<ZhihuHotBean> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getZHot()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ZhihuHotBean>() {
                    @Override
                    public void accept(ZhihuHotBean zhihuHotBean) throws Exception {
                      iBaseRequestCallBack.requestSuccess(zhihuHotBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
}
