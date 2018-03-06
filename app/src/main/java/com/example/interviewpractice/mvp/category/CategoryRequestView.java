package com.example.interviewpractice.mvp.category;

import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.EyCategoryBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public interface CategoryRequestView extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(EyCategoryBean result);
    void resultFailure(String result);

}

