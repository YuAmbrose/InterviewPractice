package com.example.interviewpractice.mvp.forum;

import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.mvp.EyDetail.IMvpBaseView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/24.
 */

public interface PostView extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(List<Post> result);
    void resultFailure(String result);
}
