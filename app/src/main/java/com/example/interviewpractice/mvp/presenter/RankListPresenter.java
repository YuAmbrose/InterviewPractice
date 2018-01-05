package com.example.interviewpractice.mvp.presenter;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface RankListPresenter{
        void loadRanklist(String strategy,int start,int num);
        void loadSelect();
}
