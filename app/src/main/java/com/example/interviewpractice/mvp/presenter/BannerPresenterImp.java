package com.example.interviewpractice.mvp.presenter;

import android.content.Context;

import com.example.interviewpractice.mvp.base.BasePresenterImp;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.mvp.model.BannerModelImp;
import com.example.interviewpractice.mvp.view.BannerView;

/**
 * Created by Administrator on 2017/12/26.
 */

public class BannerPresenterImp  extends BasePresenterImp<BannerView,BannerBean> implements BannerPresenter{
    private Context context=null;
    private BannerModelImp bannerModelImp=null;
    /**
     * @param view 具体业务的视图接口对象
     * @descriptoin 构造方法
     */
    public BannerPresenterImp(BannerView view,Context context) {
        super(view);
        this.context=context;
        this.bannerModelImp= new BannerModelImp(context);
    }


    @Override
    public void loadBanner() {
       bannerModelImp.loadBanner(this);
    }



    @Override
    public void onUnsubscribe() {
        bannerModelImp.onUnsubscribe();
    }



//
//    @Override
//    public void loadRanklist(String strategy,int start,int num) {
//        bannerModelImp.loadRanklist(strategy,start,num,this);
//    }

}
