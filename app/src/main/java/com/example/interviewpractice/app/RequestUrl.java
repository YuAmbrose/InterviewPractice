package com.example.interviewpractice.app;

/**
 * Created by Administrator on 2018/1/18.
 */

public class RequestUrl {
    //开眼baseUrl    start=0&num=10
    public static final  String BaseUrl="http://baobab.kaiyanapp.com/api/";

    //根据Id获取作者的详情
    //http://baobab.kaiyanapp.com/api/v4/pgcs/detail/tab?id=2203
    public static final  String pgcDetail=BaseUrl+"v3/pgc/videos?pgcId=56";
    //获取全部作者
    public static final  String pgc=BaseUrl+"v4/pgcs/all";

    //首页每日
    public static final  String feed=BaseUrl+"v2/feed";
    //视频的详细信息
    public static final  String videoDetail=BaseUrl+"v1/video/2492";
    //评论信息
    public static final  String replay="v1/replies/video?id=2492";

    //根据分类id获取该分类的全部信息
    //http://baobab.kaiyanapp.com/api/v4/categories/detail/tab?id=2
    public static final  String cagDetail=BaseUrl+"v3/categories/detail?id=18";
    //更多分类，一共有17个
    public static final  String CagMore=BaseUrl+"v2/categories";
    //给分类下最受欢迎
    public static final  String cagPopular="v3/categories/videoList?id=2&strategy=mostPopular&%20start=0&num=10";
    //热门视频，更新很快。很多数据
    public static final  String hot=BaseUrl+"v4/discovery/hot";


    //根据输入内容（query）搜索视频
    public static final  String query=BaseUrl+"v1/search?query=Android";
    //热门搜索词汇
    public static final  String queryWord=BaseUrl+"v3/queries/hot";

    /**
     * 知乎日报
     */
    public static final String ZHI_HU_BaseURL = "http://news-at.zhihu.com/api/4/";
    // news/hot 热门
    //知乎日报
    //news/latest
//    http://news-at.zhihu.com/api/4/news/9666744
   // http://news-at.zhihu.com/api/4/section/86
 //   http://news-at.zhihu.com/api/4/sections

    //随机文章
    public static  final String article="https://interface.meiriyiwen.com/article/random";
    //今日文章
    public static  final String todayarticle="https://interface.meiriyiwen.com/article/today";
    //图片格式转换
    //final String imgUrl = ImgSizeUtil.resetPicUrl(item.getImg(), ".webp@171w_240h_1e_1c_1l");

    //http://api.maoyan.com/mmdb/movie/v3/list/hot.json  热门影片。有mp4，需要转换图片
    //http://api.maoyan.com/mmdb/movie/lp/list.json  待映-预告片推荐  有mp4，不需要转换图片
    //http://api.maoyan.com/mmdb/movieboard/fixedboard/7.json  每日热映口碑榜 没有mp4 需要转换图片
    //http://api.maoyan.com/mmdb/movieboard/fixedboard/6.json   猫眼想看月度榜 没有mp4 需要转换图片
    //http://api.maoyan.com/mmdb/movieboard/fixedboard/4.json   猫眼经典Top100 没有mp4 需要转换图片
    //http://api.maoyan.com/mmdb/movieboard/fixedboard/1.json   "每日热映票房榜" 没有mp4 需要转换图片
    //http://api.maoyan.com/mmdb/movie/v2/list/rt/order/coming.json  准备上映  有mp4，需要转换图片
    //http://m.maoyan.com/cinemas.json  附近影院
    //http://api.maoyan.com/mmdb/movie/v5/1199974.json  电影详细信息

    //https://app.vmovier.com/apiv3/cate/getList
    //https://app.vmovier.com/apiv3/index/index
    //URL	https://app.vmovier.com/apiv3/post/getPostByTab
    //URL	https://app.vmovier.com/apiv3/post/getPostInCate
    //URL	https://app.vmovier.com/apiv3/index/getBanner

    //URL	http://baobab.kaiyanapp.com/api/v5/index/tab/list?
    //URL	http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0
    //URL	http://baobab.kaiyanapp.com/api/v2/notification
    //URL	http://baobab.kaiyanapp.com/api/v1/tag/videos?id=52
    //URL	http://baobab.kaiyanapp.com/api/v1/tag/dynamics?
}
