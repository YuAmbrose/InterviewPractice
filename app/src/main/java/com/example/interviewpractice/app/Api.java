package com.example.interviewpractice.app;

import com.example.interviewpractice.enity.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public interface Api {
    @GET("selected?v2/feed/")
    Observable<BannerBean> getMessage();
}
