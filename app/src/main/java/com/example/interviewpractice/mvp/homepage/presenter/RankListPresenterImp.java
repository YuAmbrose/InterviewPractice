package com.example.interviewpractice.mvp.homepage.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.homepage.base.RankListBasePresenterImp;
import com.example.interviewpractice.mvp.homepage.model.RankListModelImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;

/**
 * Created by Administrator on 2018/1/5.
 */

public class RankListPresenterImp extends RankListBasePresenterImp<RankListView,RankListBean> implements RankListPresenter {
    private RankListModelImp rankListModelImp=null;
    private Context context;
    /**
     * @param view 具体业务的视图接口对象
     * @descriptoin 构造方法
     */
    public RankListPresenterImp(RankListView view,Context context) {
        super(view);
        this.context=context;
        this.rankListModelImp=new RankListModelImp(context);
    }

    @Override
    public void loadRanklist(String strategy, int start, int num) {
        rankListModelImp.loadRankList(strategy,start,num,this);
    }

    @Override
    public void loadSelect(int start,int num) {
        rankListModelImp.loadSelected(start,num,this);
    }


}
