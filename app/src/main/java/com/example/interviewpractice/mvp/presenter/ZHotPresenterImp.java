package com.example.interviewpractice.mvp.presenter;

import android.content.Context;

import com.example.interviewpractice.enity.ZhihuHotBean;
import com.example.interviewpractice.mvp.base.ZHotBasePrsenterImp;
import com.example.interviewpractice.mvp.model.ZHotModelImp;
import com.example.interviewpractice.mvp.view.ZHotView;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ZHotPresenterImp extends ZHotBasePrsenterImp<ZHotView,ZhihuHotBean> implements ZHotPresenter {
    private Context context=null;
    private ZHotModelImp zHotModelImp=null;
    /**
     * @param view 具体业务的视图接口对象
     * @descriptoin 构造方法
     */
    public ZHotPresenterImp(ZHotView view, Context context) {
        super(view);
        this.context=context;
        this.zHotModelImp= new ZHotModelImp(context);
    }

    @Override
    public void loadZhiHuNews() {
            zHotModelImp.loadHotNews(this);
    }
}
