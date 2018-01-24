package com.example.interviewpractice.mvp.homepage.base;

import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.http.IBaseRequestListCallBack;

import java.util.List;

/**
 * Created by Administrator on 2018/1/2.
 */

public class CagBasePresenterImp <V extends CagBaseView, T> implements IBaseRequestListCallBack<T> {

    private CagBaseView cagBaseView = null;  //基类视图
    public CagBasePresenterImp (V view) {
        this.cagBaseView = view;
    }


    /**
     * @descriptoin	请求成功获取成功之后的数据信息
     */
    @Override
    public void requestSuccess(List<CategoryTab> callBack) {
        cagBaseView.loadCagSuccess(callBack);
    }
}
