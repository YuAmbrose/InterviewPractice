package com.example.interviewpractice.app;

import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.EyCategoryBean;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.enity.ZhihuHotBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public interface Api {
    //开眼baseUrl http://baobab.kaiyanapp.com/api/;
    /**
     * 首页banner
     */
//    @Headers("Cache-Control: public, max-age=86400")
    @GET("v2/feed")
    Observable<BannerBean> getMessage();

    /**
     * 开眼排行榜
     */
    @GET("v3/ranklist")
    Observable<RankListBean> getRankList(@Query("strategy") String strategy,
                                         @Query("start")int start,
                                         @Query("num") int num);
/**
 * 该Id相似内容
 */
@GET("v4/video/related")
Observable<RankListBean> getRecomendar(@Query("id") String id);
    /**
     *开眼热门内容
     */
    @GET("v4/discovery/hot")
    Observable<RankListBean> getSelected( @Query("start")int start,
                                          @Query("num") int num);

    /**
     * 开眼作者
     * @return
     */
    @GET("v4/pgcs/all")
    Observable<PgcBean> getPgc( @Query("start")int start,
                                @Query("num") int num);
    /**
     * 知乎日报
     */
    @GET("news/hot")
    Observable<ZhihuHotBean> getZHot();

    /**
     * 热门电影
     */
    @GET("movieboard/fixedboard/7.json")
    Observable<HotMovieBean> getHotMovie();
    /**
     * 预告片
     */
    @GET("movie/lp/list.json")
    Observable<PrevueBean> getComingMovie();
    /**
     * 即将上映
     */
    @GET("movie/v2/list/rt/order/coming.json")
    Observable<ComingMovieBean> getComingList();
    /**
     * 开眼视频详细信息
     */
    @GET("v1/video/{id}" )
    Observable<EyDetailBean> getEyDetail(@Path("id") String id);

    /**
     * 作者详情信息
     */
    @GET("v4/pgcs/detail/tab")
    Observable<AuthorDetailBean> getAuthor(@Query("id") String id);

    @GET("v4/pgcs/videoList")
    Observable<RankListBean> getAuthorList( @Query("strategy") String strategy,
                                            @Query("id") String id,
                                           @Query("start")int start,
                                           @Query("num") int num);
    /**
     * 开眼分类内容
     */
    @GET("v4/categories/all")
    Observable<EyCategoryBean> getCategories();
    /**
    /**
     * 猫眼详细视频
     */
    @GET("movie/v5/{id}.json")
    Observable<MovieDetailBean> getMovieDetai(@Path("id") String  id);
}
