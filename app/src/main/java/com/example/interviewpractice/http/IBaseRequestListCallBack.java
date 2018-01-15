package com.example.interviewpractice.http;

import com.example.interviewpractice.enity.CategoryTab;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */

public interface IBaseRequestListCallBack<T> {
    void requestSuccess(List<CategoryTab> callBack);
}
