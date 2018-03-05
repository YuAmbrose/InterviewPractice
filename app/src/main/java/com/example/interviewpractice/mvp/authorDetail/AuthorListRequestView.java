package com.example.interviewpractice.mvp.authorDetail;

import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public interface AuthorListRequestView  extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(RankListBean result);
    void resultFailure(String result);

}
