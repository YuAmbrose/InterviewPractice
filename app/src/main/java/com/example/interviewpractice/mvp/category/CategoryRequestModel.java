package com.example.interviewpractice.mvp.category;

import android.content.Context;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.EyCategoryBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.http.IBaseRequestListCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class CategoryRequestModel extends BaseModel {
    private Call<EyCategoryBean> categoryBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public CategoryRequestModel(Context mContext){
        super();
        context = mContext;
        api =retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void  RequestCategory(final IBaseRequestCallBack<EyCategoryBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<EyCategoryBean>() {
                    @Override
                    public void accept(EyCategoryBean eyCategoryBean) throws Exception {
//                        List<EyCategoryBean> beans=new ArrayList<>();
//                        beans.add(eyCategoryBean);
                        iBaseRequestCallBack.requestSuccess(eyCategoryBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(categoryBeanCall!= null && !categoryBeanCall.isCanceled()){
            categoryBeanCall.cancel();
        }
    }
}
