package com.example.interviewpractice.mvp.start;

import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/26.
 */

public interface BmobView  extends IMvpBaseView {
    void requestLoading();

    void resultSuccess(List<RecomendarMovie> result);

    void resultFailure(String result);
}
