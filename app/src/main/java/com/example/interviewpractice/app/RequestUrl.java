package com.example.interviewpractice.app;

/**
 * Created by Administrator on 2018/1/18.
 */

public class RequestUrl {
    //开眼baseUrl    start=0&num=10
    public static final  String BaseUrl="http://baobab.kaiyanapp.com/api/";

    //根据Id获取作者的详情
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

}
