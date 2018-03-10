package com.example.interviewpractice.http;

import com.example.interviewpractice.enity.Cag;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/9.
 */

public interface ICagRequestCallBack<T>{
    void requestError(Throwable throwable);
//    void requestAuthorError(Throwable throwable);
//    void requestAllError(Throwable throwable);
    /**
     * @descriptoin	请求成功
     */
    void requestSuccess(T callBack);

//    void requestAuthorSuccess(T callBack);
//    void requestAllSuccess(T callBack);


}
