package com.example.interviewpractice.base;

import java.util.List;

/**
 * 描述：请求数据的回调接口
 * Presenter用于接受model获取（加载）数据后的回调
 * 作者：dc on 2017/2/16 11:22
 * 邮箱：597210600@qq.com
 */
public interface IBaseRequestCallBack<T> {

    /**
     * @descriptoin	请求之前的操作
     */
    void beforeRequest();
    /**
     * @descriptoin	请求完成
     */
    void requestComplete();

    /**
     * @descriptoin	请求异常
     */
    void requestError(Throwable throwable);

    /**
     * @descriptoin	请求成功
     */
    void requestSuccess(T callBack);

    void listSuccess(List<T> callback);
}
