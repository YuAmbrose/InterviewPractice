package com.example.interviewpractice.app;

import java.net.URL;

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


    //https://app.vmovier.com/apiv3/cate/getList
    //https://app.vmovier.com/apiv3/index/index
    //URL	https://app.vmovier.com/apiv3/post/getPostByTab
    //URL	https://app.vmovier.com/apiv3/post/getPostInCate
    //URL	https://app.vmovier.com/apiv3/index/getBanner

    //URL	http://baobab.kaiyanapp.com/api/v5/index/tab/list?udid=5229c3d8b36345c5a63896eab40bb3f25fd15479&vc=254&vn=3.14&deviceModel=MI%204W&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23
    //URL	http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0&udid=5229c3d8b36345c5a63896eab40bb3f25fd15479&vc=254&vn=3.14&deviceModel=MI%204W&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23
    //URL	http://baobab.kaiyanapp.com/api/v2/notification?udid=5229c3d8b36345c5a63896eab40bb3f25fd15479&vc=254&vn=3.14&deviceModel=MI%204W&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23
//URL	http://baobab.kaiyanapp.com/api/v1/tag/videos?id=52&udid=5229c3d8b36345c5a63896eab40bb3f25fd15479&vc=254&vn=3.14&deviceModel=MI%204W&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23
    //URL	http://baobab.kaiyanapp.com/api/v1/tag/dynamics?id=52&udid=5229c3d8b36345c5a63896eab40bb3f25fd15479&vc=254&vn=3.14&deviceModel=MI%204W&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23
}
