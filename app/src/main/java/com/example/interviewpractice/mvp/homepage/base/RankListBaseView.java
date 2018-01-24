package com.example.interviewpractice.mvp.homepage.base;

/**
 * Created by Administrator on 2018/1/5.
 */

public interface RankListBaseView<T> {
    void rankSuccess(T rData);
    void selectSuccess(T  sData);

}
