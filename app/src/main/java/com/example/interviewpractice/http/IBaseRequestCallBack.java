package com.example.interviewpractice.http;

/**
 * 描述：请求数据的回调接口
 * Presenter用于接受model获取（加载）数据后的回调
 */
public interface IBaseRequestCallBack<T> {


    /**
     * @descriptoin	请求异常
     */
    void requestError(Throwable throwable);

    /**
     * @descriptoin	请求成功
     */
    void requestSuccess(T callBack);
}
