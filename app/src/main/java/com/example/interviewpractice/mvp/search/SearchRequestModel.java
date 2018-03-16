package com.example.interviewpractice.mvp.search;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by 鱼握拳 on 2018/3/15.
 */

public class SearchRequestModel  extends BaseModel {
    private Call<RankListBean> rankListBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    private Call<List<String>> listCall;
    public  SearchRequestModel(Context mContext) {
        super();
        context = mContext;
        api =retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void RequestQuery(int start,int num,String query, final IBaseRequestCallBack<RankListBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getQuery(start,num,query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RankListBean>() {
                    @Override
                    public void accept(RankListBean rankListBeann) throws Exception {
                        iBaseRequestCallBack.requestSuccess(rankListBeann);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void  RequestList(final IBaseListCallBack<List<String>> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getQueriesHotData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> list) throws Exception {
                            iBaseRequestCallBack.requestList(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(rankListBeanCall != null && !rankListBeanCall.isCanceled()){
            rankListBeanCall.cancel();
        }
    }
}
