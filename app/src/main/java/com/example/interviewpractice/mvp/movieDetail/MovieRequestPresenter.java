package com.example.interviewpractice.mvp.movieDetail;

import android.graphics.Movie;
import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;
import com.example.interviewpractice.mvp.EyDetail.RequestView;

/**
 * Created by 鱼握拳 on 2018/2/24.
 */

public class MovieRequestPresenter extends AbstractMvpPersenter<MovieRequestView> {
    private  final MovieRequestModel movieRequestModel; 
    public MovieRequestPresenter(){
        movieRequestModel=new MovieRequestModel(MyApplication.getContext());
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
               movieRequestModel.RequestMovieDetail(Id, new IBaseRequestCallBack<MovieDetailBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                   @Override
                   public void requestSuccess(MovieDetailBean movieDetailBean) {
                       if(getmMvpView() != null){
                           getmMvpView().resultSuccess(movieDetailBean);
                       }
                   }
                });

            }
        },1);
    }

    public void interruptHttp(){
       movieRequestModel.interruptHttp();
    }
}
