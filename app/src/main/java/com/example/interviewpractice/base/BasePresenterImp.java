package com.example.interviewpractice.base;

import java.util.List;

/**
 * 描述：
 *  * 代理对象的基础实现 ：  一些基础的方法
 * @param <V> 视图接口对象(view) 具体业务各自继承自IBaseView
 * @param <T> 业务请求返回的具体对象
 */
public class BasePresenterImp<V extends IBaseView , T> implements IBaseRequestCallBack<T> {

    private IBaseView iBaseView = null;  //基类视图

    /**
     * @descriptoin	 构造方法
     * @param view 具体业务的视图接口对象
     */
    public BasePresenterImp(V view) {
        this.iBaseView = view;
    }

    /**
     * @descriptoin	请求之前显示progress
     */
    @Override
    public void beforeRequest() {
        iBaseView.showProgress();
    }

    /**
     * @descriptoin	请求异常显示异常信息
     */
    @Override
    public void requestError(Throwable throwable) {
        iBaseView.loadDataError(throwable);
        iBaseView.disimissProgress(); //请求错误，提示错误信息之后隐藏progress
    }

    /**
     * @descriptoin	请求完成之后隐藏progress
     */
    @Override
    public void requestComplete()  {
        iBaseView.disimissProgress();
    }

    /**
     * @descriptoin	请求成功获取成功之后的数据信息
     */
    @Override
    public void requestSuccess(T callBack) {
        iBaseView.loadDataSuccess(callBack);
    }

    @Override
    public void listSuccess(List<T> callback) {

    }
}
