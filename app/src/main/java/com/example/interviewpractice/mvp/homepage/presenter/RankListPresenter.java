package com.example.interviewpractice.mvp.homepage.presenter;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface RankListPresenter{
        void loadRanklist(String strategy,int start,int num);
        void loadSelect(int start,int num);
        void loadListAuthor(String strategy,String id,int start,int num);
}
