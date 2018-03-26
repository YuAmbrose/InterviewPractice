package com.example.interviewpractice.mvp.start;

import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;
import com.example.interviewpractice.mvp.forum.PostModel;
import com.example.interviewpractice.mvp.forum.PostView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/26.
 */

public class BmobPresenter extends AbstractMvpPersenter<BmobView> {
    private BmobModel model;
    public BmobPresenter() {
        model=new BmobModel(MyApplication.getContext());
    }
    public void clickPost(final int page, final int actionType) {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                model.RequestBmob(page,actionType,new IBaseListCallBack<RecomendarMovie>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(List<RecomendarMovie> callBack) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultSuccess(callBack);
                        }
                    }

                    @Override
                    public void requestList(List<String> callBack) {

                    }
                });

            }
        }, 1);
    }

    public void interruptHttp() {
        model.interruptHttp();
    }
}
