package com.example.interviewpractice.mvp.article;

import com.example.interviewpractice.enity.ArticleBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;
import com.example.interviewpractice.mvp.homepage.base.IBaseView;

/**
 * Created by 鱼握拳 on 2018/3/8.
 */

public interface ArticleView  extends IMvpBaseView{
    void requestLoading();
    void resultSuccess(ArticleBean result);
    void resultFailure(String result);
}
