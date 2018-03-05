package com.example.interviewpractice.mvp.authorDetail;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by 鱼握拳 on 2018/3/5.
 */

public class AuthorRequestModel extends BaseModel {
    private Call<AuthorDetailBean> movieDetailBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    AuthorRequestModel(Context mContext){
        super();
        context = mContext;
        api =retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void RequestAuthoretail(String id, final IBaseRequestCallBack<AuthorDetailBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getAuthor(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AuthorDetailBean>() {
                    @Override
                    public void accept(AuthorDetailBean authorDetailBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(authorDetailBean);
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
