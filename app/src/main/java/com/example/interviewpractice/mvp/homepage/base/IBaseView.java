package com.example.interviewpractice.mvp.homepage.base;

/**
 * 描述：视图基类
 */
public interface IBaseView<T> {

    /**
     * @descriptoin	请求数据成功
     */
    void loadDataSuccess(T tData);



    /**
     * @descriptoin	请求数据错误
     */
    void loadDataError(Throwable throwable);
}
