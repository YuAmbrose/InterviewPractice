package com.example.interviewpractice.mvp.base;

import java.util.List;

/**
 * Created by Administrator on 2018/1/2.
 */

public interface CagBaseView<T> {
    void loadCagSuccess(List<T> tData);
}
