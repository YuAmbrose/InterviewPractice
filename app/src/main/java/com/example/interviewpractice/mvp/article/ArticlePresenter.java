package com.example.interviewpractice.mvp.article;

import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.ArticleBean;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.http.IBaseRequestCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;


/**
 * Created by 鱼握拳 on 2018/3/8.
 */

public class ArticlePresenter  extends AbstractMvpPersenter<ArticleView> {
    private ArticleModel articleModel;
    public ArticlePresenter(){
        articleModel=new ArticleModel(MyApplication.getContext());
    }
    public void clickRequest(final String type){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                articleModel.RequestArticle(type,new IBaseRequestCallBack<ArticleBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(ArticleBean bean) {
                        if(getmMvpView() != null){
                            getmMvpView().resultSuccess(bean);
                        }
                    }
                });

            }
        },1);
    }

    public void interruptHttp(){
        articleModel.interruptHttp();
    }
}
