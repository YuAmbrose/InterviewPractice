package com.example.interviewpractice.mvp.search;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;
import com.example.interviewpractice.mvp.movieDetail.MovieRequestView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/15.
 */

public class SearchRequestPresenter extends AbstractMvpPersenter<SearchRequestView> {
    private final  SearchRequestModel searchRequestModel;
    public SearchRequestPresenter(){
        searchRequestModel=new SearchRequestModel(MyApplication.getContext());
    }
    public void clickRequest(final int start, final int num, final String query){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                searchRequestModel.RequestQuery(start,num,query, new IBaseRequestCallBack<RankListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(RankListBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().resultSuccess(callBack);
                        }
                    }

            });
            }
        },1);
    }
    public void clickRequestList(){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                searchRequestModel.RequestList(new IBaseListCallBack<List<String>>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(List<List<String>> callBack) {

                    }


                    @Override
                    public void requestList(List<String> callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().hotSuccess(callBack);
                        }
                    }
                });
            }
        },1);
    }
    public void interruptHttp(){
        searchRequestModel.interruptHttp();
    }
}
