package com.example.interviewpractice.base;

/**
 * 描述：视图基类
 */
public interface IBaseView<T> {
    /**
     * @descriptoin	请求前加载progress
     */
    void showProgress();

    /**
     * @descriptoin	请求结束之后隐藏progress
     */
    void disimissProgress();

    /**
     * @descriptoin	请求数据成功
     */
    void loadDataSuccess(T tData);



    /**
     * @descriptoin	请求数据错误
     */
    void loadDataError(Throwable throwable);
}
