package com.example.interviewpractice.mvp.CagDetail;

import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.ArticleBean;
import com.example.interviewpractice.enity.CagAuthorBean;
import com.example.interviewpractice.enity.CategoryDetailInfo;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;


/**
 * Created by 鱼握拳 on 2018/3/9.
 */

public class CagDetailPresenter extends AbstractMvpPersenter<CagDetailView> {
    private CagDetailModel cagDetailModel;
    public CagDetailPresenter(){
        cagDetailModel=new CagDetailModel(MyApplication.getContext());
    }
    public void interruptHttp(){
       cagDetailModel.interruptHttp();
    }
    public void clickRequest(final String id){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cagDetailModel.RequestCagDetail(id,new IBaseRequestCallBack<CategoryDetailInfo>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(CategoryDetailInfo categoryDetailInfo) {
                        if(getmMvpView() != null){

                            getmMvpView().resultSuccess(categoryDetailInfo);
                        }
                    }
                });
//                cagDetailModel.RequestAll(id, 0, 10, new IBaseRequestCallBack<RankListBean>() {
//                    @Override
//                    public void requestError(Throwable throwable) {
//                        if(getmMvpView() != null){
//                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
//                        }
//                    }
//
//                    @Override
//                    public void requestSuccess(RankListBean rankListBean) {
//                        if(getmMvpView() != null){
//                            getmMvpView().AllSuccess(rankListBean);
//                        }
//                    }
//                });
//                cagDetailModel.RequestAuthor(id,0,5, new IBaseRequestCallBack<CagAuthorBean>() {
//                    @Override
//                    public void requestError(Throwable throwable) {
//                        if(getmMvpView() != null){
//                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
//                        }
//                    }
//
//                    @Override
//                    public void requestSuccess(CagAuthorBean callBack) {
//                        if(getmMvpView() != null){
//                            getmMvpView().AuthorSuccess(callBack);
//                        }
//                    }
//                });

            }
        },1);
    }
    public void clickAllRequest(final String id, final int start, final int num){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cagDetailModel.RequestAll(id, start, num, new IBaseRequestCallBack<RankListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(RankListBean rankListBean) {
                        if(getmMvpView() != null){
                            getmMvpView().AllSuccess(rankListBean);
                        }
                    }
                });

            }
        },1);
    }
    public void clickAuthorRequest(final String id, final int start, final int num){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cagDetailModel.RequestAuthor(id,start,num, new IBaseRequestCallBack<CagAuthorBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    public void requestSuccess(CagAuthorBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().AuthorSuccess(callBack);
                        }
                    }
                });
            }
        },1);
    }
}
