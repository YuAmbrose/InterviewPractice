package com.example.interviewpractice.mvp.article;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.ArticleBean;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by 鱼握拳 on 2018/3/8.
 */

public class ArticleModel extends BaseModel {
    private Call<ArticleBean> articleBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  ArticleModel(Context mContext){
        super();
        context = mContext;
        api =articleManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void RequestArticle(String type,final IBaseRequestCallBack<ArticleBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getArt(type)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ArticleBean>() {
                    @Override
                    public void accept(ArticleBean bean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(articleBeanCall != null && !articleBeanCall.isCanceled()){
           articleBeanCall.cancel();
        }
    }
}
