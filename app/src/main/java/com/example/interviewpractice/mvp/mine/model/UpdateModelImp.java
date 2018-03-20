package com.example.interviewpractice.mvp.mine.model;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.UpdateAppInfo;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.ui.fragment.MineFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 鱼握拳 on 2018/3/20.
 */

public class UpdateModelImp extends BaseModel implements UpdateModel<UpdateAppInfo> {
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;

    public UpdateModelImp(Context mContext) {
        super();
        context = mContext;
        api = firRetrofit.getService();
        mcompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void loadUpdate(final IBaseRequestCallBack<UpdateAppInfo> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getUpdateInfo("4954a03096ef1524a23052b712533a68")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<UpdateAppInfo>() {
                    @Override
                    public void accept(UpdateAppInfo updateAppInfo) throws Exception {
                        iBaseRequestCallBack.requestSuccess(updateAppInfo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
}
