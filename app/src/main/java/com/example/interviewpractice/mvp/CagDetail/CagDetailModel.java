package com.example.interviewpractice.mvp.CagDetail;

import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.ArticleBean;
import com.example.interviewpractice.enity.CagAuthorBean;
import com.example.interviewpractice.enity.CategoryDetailInfo;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.http.ICagRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by 鱼握拳 on 2018/3/9.
 */

public class CagDetailModel extends BaseModel {

    private Call<CagAuthorBean> cagAuthorBeanCall;
    private Call<RankListBean>  rankListBeanCall;
    private Call<CategoryDetailInfo> categoryDetailInfoCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public CagDetailModel(Context mContext){
        super();
        context = mContext;
        api =retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void RequestCagDetail(String id,final IBaseRequestCallBack<CategoryDetailInfo> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getCagDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CategoryDetailInfo>() {
                    @Override
                    public void accept(CategoryDetailInfo categoryDetailInfo) throws Exception {
                        iBaseRequestCallBack.requestSuccess(categoryDetailInfo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void RequestAll(String id,int  start,int num,final IBaseRequestCallBack<RankListBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getCagAll(id,start,num)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RankListBean>() {
                    @Override
                    public void accept(RankListBean rankListBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(rankListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void RequestAuthor(String id,int  start,int num,final IBaseRequestCallBack<CagAuthorBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getCagAuthor(id,start,num)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CagAuthorBean>() {
                    @Override
                    public void accept(CagAuthorBean cagAuthorBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(cagAuthorBean);
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(cagAuthorBeanCall!= null && !cagAuthorBeanCall.isCanceled()){
            cagAuthorBeanCall.cancel();
        }
        if(rankListBeanCall!= null && !rankListBeanCall.isCanceled()){
            rankListBeanCall.cancel();
        }
        if(categoryDetailInfoCall!= null && !categoryDetailInfoCall.isCanceled()){
            categoryDetailInfoCall.cancel();
        }
    }
}
