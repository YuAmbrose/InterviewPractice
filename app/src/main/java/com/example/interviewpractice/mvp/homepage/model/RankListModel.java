package com.example.interviewpractice.mvp.homepage.model;

import com.example.interviewpractice.http.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface RankListModel<T> {
    void loadRankList(String strategy,int start,int num,IBaseRequestCallBack<T> iBaseRequestCallBack);
    void loadSelected(int start,int num,IBaseRequestCallBack<T> iBaseRequestCallBack);
    void loadListAuthor(String strategy,String id,int start,int num,IBaseRequestCallBack<T> iBaseRequestCallBack);
    void loadPopular(String strategy,String id,int start,int num,IBaseRequestCallBack<T> iBaseRequestCallBack);
    void loadCagList(String id,int start,int num,IBaseRequestCallBack<T> iBaseRequestCallBack);
}
