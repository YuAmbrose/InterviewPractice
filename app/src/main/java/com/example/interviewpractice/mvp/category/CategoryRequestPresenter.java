package com.example.interviewpractice.mvp.category;

import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.YoutubeBean;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;

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
                categoryRequestModel.RequestCategory(new IBaseListCallBack<Cag>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(List<Cag> callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().resultSuccess(callBack);
                        }
                    }

                    @Override
                    public void requestList(List<String> callBack) {

                    }


                });

            }
        },1);
    }
    public void  requesYoutube(final String id){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                categoryRequestModel.RequestCagDetail(id,new IBaseRequestCallBack<YoutubeBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(YoutubeBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successYou(callBack);
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