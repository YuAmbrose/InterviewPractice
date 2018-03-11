package com.example.interviewpractice.mvp.EyDetail;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.EyReplyBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author 刘镓旗
 * @date 2017/11/17
 * @description
 */
public class RequestPresenter extends AbstractMvpPersenter<RequestView>{

    private final RequestMode mRequestMode;

    public RequestPresenter() {
        this.mRequestMode = new RequestMode(MyApplication.getContext());
    }

    public void clickRequest(final String Id){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRequestMode.RequesetReComender(Id, new IBaseRequestCallBack<RankListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(RankListBean rankListBean) {
                        if(getmMvpView() != null){
                            getmMvpView().resultRecomendar(rankListBean);
                        }
                    }
                });
                mRequestMode.RequestReply(Id, new IBaseRequestCallBack<EyReplyBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(EyReplyBean eyReplyBean) {
                        if(getmMvpView() != null){
                            getmMvpView().resultReply(eyReplyBean);
                        }
                    }
                });
                mRequestMode.request(Id, new IBaseRequestCallBack<EyDetailBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(EyDetailBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().resultSuccess(callBack);
                        }
                    }
                });
            }
        },1);
    }

    public void interruptHttp(){
        mRequestMode.interruptHttp();
    }
}
