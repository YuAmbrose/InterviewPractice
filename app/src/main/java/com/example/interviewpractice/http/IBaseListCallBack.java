package com.example.interviewpractice.http;

import com.example.interviewpractice.enity.EyCategoryBean;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public interface IBaseListCallBack<T> {
    /**
     * @descriptoin	请求异常
     */
    void requestError(Throwable throwable);

    /**
     * @descriptoin	请求成功
     */
//    void requestSuccess(List<T> callBack);

    void requestSuccess(EyCategoryBean eyCategoryBean);
}
