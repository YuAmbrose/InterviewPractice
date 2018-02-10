package com.example.interviewpractice.mvp.discover.base;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMovieBasePresenterImp <V extends  HotMovieBaseView,T> implements IBaseRequestCallBack<T>{
   private HotMovieBaseView hotMovieBaseView;
   public  HotMovieBasePresenterImp(V view){
       this.hotMovieBaseView=view;
   }
    @Override
    public void requestError(Throwable throwable) {

    }

    @Override
    public void requestSuccess(T callBack) {
    hotMovieBaseView.loadSuccess(callBack);
    }
}
