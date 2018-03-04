package com.example.interviewpractice.mvp.movieDetail;

import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

/**
 * Created by 鱼握拳 on 2018/2/24.
 */

public interface MovieRequestView extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(MovieDetailBean result);
    void resultFailure(String result);

}
