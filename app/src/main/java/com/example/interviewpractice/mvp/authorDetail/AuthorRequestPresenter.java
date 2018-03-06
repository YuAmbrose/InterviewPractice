package com.example.interviewpractice.mvp.authorDetail;

import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;
import com.example.interviewpractice.mvp.movieDetail.MovieRequestView;

/**
 * Created by 鱼握拳 on 2018/3/5.
 */

public class AuthorRequestPresenter  extends AbstractMvpPersenter<AuthorRequestView> {
    private final AuthorRequestModel authorRequestModel;
    public AuthorRequestPresenter(){
        authorRequestModel=new AuthorRequestModel(MyApplication.getContext());
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
            authorRequestModel.RequestAuthoretail(Id, new IBaseRequestCallBack<AuthorDetailBean>() {
                @Override
                public void requestError(Throwable throwable) {
                    if(getmMvpView() != null){
                        getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                    }
                }
                @Override
                public void requestSuccess(AuthorDetailBean movieDetailBean) {
                    if(getmMvpView() != null){
                        getmMvpView().resultSuccess(movieDetailBean);
                    }
                }
            });

        }
    },1);
}

    public void interruptHttp(){
        authorRequestModel.interruptHttp();
    }
}
