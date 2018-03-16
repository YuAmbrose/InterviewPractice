package com.example.interviewpractice.mvp.search;

import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/15.
 */

public interface SearchRequestView extends IMvpBaseView {
    void requestLoading();

    void resultSuccess(RankListBean result);

    void  hotSuccess(List<String> list);

    void resultFailure(String result);
}
