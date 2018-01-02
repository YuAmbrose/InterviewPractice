package com.example.interviewpractice.mvp.model;

import android.content.Context;
import android.util.Log;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.enity.CategoryTab;

import java.util.List;

import cn.bmob.v3.datatype.BmobFile;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/26.
 */

public class BannerModelImp extends BaseModel implements BannerModel<BannerBean> {
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    private List<CategoryTab> homeEntrances;
    private String types;
    private BmobFile icons;
    public BannerModelImp(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void loadRanklist(String strategy,final IBaseRequestCallBack iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getRankList(strategy)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        Log.e("轮播图", String.valueOf(bannerBean.getItemList().size()));
                        iBaseRequestCallBack.requestSuccess(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("888", "accept: "+throwable.getMessage() );
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    @Override
    public void loadBanner(final IBaseRequestCallBack iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getMessage()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        Log.e("轮播图", String.valueOf(bannerBean.getItemList().size()));
                        iBaseRequestCallBack.requestSuccess(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("888", "accept: "+throwable.getMessage() );
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));

    }




    @Override
    public void onUnsubscribe() {
        mcompositeDisposable.clear();  //注销
    }




}




