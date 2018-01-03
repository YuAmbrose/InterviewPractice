package com.example.interviewpractice.app;

import com.example.interviewpractice.enity.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public interface Api {
    //开眼baseUrl http://baobab.kaiyanapp.com/api/;
    /**
     * 首页banner
     * @return
     */
//    @Headers("Cache-Control: public, max-age=86400")
    @GET("v4/tabs/selected")
    Observable<BannerBean> getMessage();

    @GET("v3/ranklist")
    Observable<BannerBean> getRankList(@Query("strategy") String strategy,
                                       @Query("start")int start,
                                       @Query("num") int num);
}
