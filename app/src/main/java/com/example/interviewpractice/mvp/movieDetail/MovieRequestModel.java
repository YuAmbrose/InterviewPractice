package com.example.interviewpractice.mvp.movieDetail;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by 鱼握拳 on 2018/2/24.
 */

public class MovieRequestModel extends BaseModel {
    private Call<MovieDetailBean> movieDetailBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  MovieRequestModel(Context mContext) {
        super();
        context = mContext;
        api = maoyanRetrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void RequestMovieDetail(String id, final IBaseRequestCallBack<MovieDetailBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getMovieDetai(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MovieDetailBean>() {
                    @Override
                    public void accept(MovieDetailBean movieDetailBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(movieDetailBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(movieDetailBeanCall != null && !movieDetailBeanCall.isCanceled()){
            movieDetailBeanCall.cancel();
        }
    }
}
