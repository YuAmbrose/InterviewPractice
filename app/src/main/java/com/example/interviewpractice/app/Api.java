package com.example.interviewpractice.app;

import com.example.interviewpractice.enity.ArticleBean;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.enity.CagAuthorBean;
import com.example.interviewpractice.enity.CategoryDetailInfo;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.EyReplyBean;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.enity.UpdateAppInfo;
import com.example.interviewpractice.enity.YoutubeBean;
import com.example.interviewpractice.enity.ZhihuHotBean;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
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
    @GET("v3/categories/videoList")
    Observable<RankListBean> getPopular(@Query("strategy") String strategy,
                                        @Query("id") String id,
                                         @Query("start") int start,
                                         @Query("num") int num);
    /**
     * 开眼排行榜
     */
    @GET("v3/ranklist")
    Observable<RankListBean> getRankList(@Query("strategy") String strategy,
                                         @Query("start") int start,
                                         @Query("num") int num);
    /**
     * 该Id相似内容
     */
    @GET("v4/video/related")
    Observable<RankListBean> getRecomendar(@Query("id") String id);

    /**
     * 开眼热门内容
     */
    @GET("v4/discovery/hot")
    Observable<RankListBean> getSelected(@Query("start") int start,
                                         @Query("num") int num);
/**
 * 热门搜索
 */
    @GET("v3/queries/hot")
    Observable<List<String>> getQueriesHotData();
    /**
     * 搜索
     */
    @GET("v1/search")
    Observable<RankListBean> getQuery(@Query("start") int start,
                                         @Query("num") int num,
                                        @Query("query") String search);
    /**
     * 开眼作者
     *
     * @return
     */
    @GET("v4/pgcs/all")
    Observable<PgcBean> getPgc(@Query("start") int start,
                               @Query("num") int num,
                                @Query("udid") String  udid);

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
    @GET("v1/video/{id}")
    Observable<EyDetailBean> getEyDetail(@Path("id") String id);

    /**
     * 作者详情信息
     */
    @GET("v5/userInfo/tab")
    Observable<AuthorDetailBean> getAuthor(@Query("id") String id,
                                           @Query("userType") String userType,
                                           @Query("udid") String udid);

    @GET("v4/pgcs/videoList")
    Observable<RankListBean> getAuthorList(@Query("strategy") String strategy,
                                           @Query("id") String id,
                                           @Query("start") int start,
                                           @Query("num") int num);
    /**
     * 开眼评论
     */
    @GET("v1/replies/video")
    Observable<EyReplyBean> getReply(@Query("id") String id);

    /**
     * 开眼分类内容
     */
    @GET("v4/categories/all")
    Observable<Cag> getCategories();

    /**
     * /**
     * 猫眼详细视频
     */
    @GET("movie/v5/{id}.json")
    Observable<MovieDetailBean> getMovieDetai(@Path("id") String id);

    /**
     * 随机文章
     */
    @Headers("User-Agent: Your-App-Name")
    @GET("{type}")
    Observable<ArticleBean> getArt(@Path("type") String type);
    /**
     * 分类详情页面
     */
    @GET("v4/categories/detail/tab")
    Observable<CategoryDetailInfo> getCagDetail(@Query("id") String id);
    /**
     * 分类全部
     */
    @GET("v4/categories/videoList")
    Observable<RankListBean> getCagAll(@Query("id") String id,
                                         @Query("start") int start,
                                         @Query("num") int num);
    /**
     * 分类作者
     */
    @GET("v4/categories/detail/pgcs")
    Observable<CagAuthorBean> getCagAuthor(@Query("id") String id,
                                           @Query("start") int start,
                                           @Query("num") int num);
    /**
     * 更新App接口
     */
    @GET("5aa409d0ca87a87c64766e8b?")
    Observable<UpdateAppInfo> getUpdateInfo(@Query("api_token") String api_token);

    /**
     * youtube api
     */
    @GET("playlistItems?part=snippet&maxResults=50&key=AIzaSyAfyOOKJSBjjvborWWbB2p4uh4oCVlIj8k")
    Observable<YoutubeBean> getYoutube(@Query("playlistId") String playlistId);
}
