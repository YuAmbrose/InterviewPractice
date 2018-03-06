package com.example.interviewpractice.mvp.category;

import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.EyCategoryBean;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.http.IBaseRequestListCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class CategoryRequestPresenter extends AbstractMvpPersenter<CategoryRequestView> {
    private CategoryRequestModel categoryRequestModel;
    public CategoryRequestPresenter(){
        categoryRequestModel=new CategoryRequestModel(MyApplication.getContext());
    }

    public void clickRequest(){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                categoryRequestModel.RequestCategory(new IBaseRequestCallBack<EyCategoryBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(EyCategoryBean eyCategoryBean) {
                        if(getmMvpView() != null){
                            getmMvpView().resultSuccess(eyCategoryBean);
                        }
                    }
                });

            }
        },1);
    }

    public void interruptHttp(){
        categoryRequestModel.interruptHttp();
    }
}