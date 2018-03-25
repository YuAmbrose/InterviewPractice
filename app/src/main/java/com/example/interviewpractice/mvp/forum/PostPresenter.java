package com.example.interviewpractice.mvp.forum;

import android.os.Handler;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpPersenter;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/24.
 */

public class PostPresenter extends AbstractMvpPersenter<PostView> {
    private PostModel postModel;

    public PostPresenter() {
        postModel = new PostModel(MyApplication.getContext());
    }

    public void clickPost(final int page, final int actionType) {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                postModel.RequestPost(page,actionType,new IBaseListCallBack<Post>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(List<Post> callBack) {
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
        postModel.interruptHttp();
    }
}
