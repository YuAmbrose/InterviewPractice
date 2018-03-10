package com.example.interviewpractice.mvp.CagDetail;

import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.CagAuthorBean;
import com.example.interviewpractice.enity.CategoryDetailInfo;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;
import com.example.interviewpractice.mvp.homepage.base.IBaseView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/9.
 */

public interface CagDetailView  extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(CategoryDetailInfo result);
    void AuthorSuccess(CagAuthorBean  authorBean);
    void AllSuccess(RankListBean rankListBean);
    void resultFailure(String result);
}
