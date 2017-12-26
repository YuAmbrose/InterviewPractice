package com.example.interviewpractice.model;

import android.content.Context;
import android.widget.Toast;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.base.BaseModel;
import com.example.interviewpractice.base.IBaseRequestCallBack;
import com.example.interviewpractice.enity.BannerBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/26.
 */

public class BannerModelImp extends BaseModel implements BannerModel<BannerBean>{
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;

    public BannerModelImp(Context mContext) {
        super();
        context = mContext;
       api = retrofitManager.getService();
       mcompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadBanner(final IBaseRequestCallBack<BannerBean> iBaseRequestCallBack) {

       mcompositeDisposable.add(api.getMessage()
             .observeOn(AndroidSchedulers.mainThread())
             .subscribeOn(Schedulers.io())
             .subscribe(new Consumer<BannerBean>() {
                 @Override
                 public void accept(BannerBean bannerBean) throws Exception {
                     if (bannerBean!=null){
                         iBaseRequestCallBack.requestSuccess(bannerBean);
                     }else {
                         Toast.makeText(context, "555", Toast.LENGTH_SHORT).show();
                     }

                 }
             }));

    }

    @Override
    public void onUnsubscribe() {
//        if(mcompositeDisposable.isDisposed()){
//            mcompositeDisposable.clear();  //注销
//            mcompositeDisposable.remove(mcompositeDisposable);
//        }
    }
    }

