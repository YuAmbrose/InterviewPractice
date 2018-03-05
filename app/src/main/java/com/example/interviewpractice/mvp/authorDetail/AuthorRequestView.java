package com.example.interviewpractice.mvp.authorDetail;

import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

/**
 * Created by 鱼握拳 on 2018/3/5.
 */

public interface AuthorRequestView extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(AuthorDetailBean result);
    void resultFailure(String result);

}

