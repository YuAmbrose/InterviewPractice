package com.example.interviewpractice.mvp.category;

import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.YoutubeBean;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public interface CategoryRequestView extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(List<Cag> result);
    void resultFailure(String result);
    void successYou(YoutubeBean youtubeBean);
}

