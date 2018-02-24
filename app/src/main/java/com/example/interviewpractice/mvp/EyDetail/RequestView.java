package com.example.interviewpractice.mvp.EyDetail;

import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.RankListBean;


/**
 * @author 刘镓旗
 * @date 2017/11/17
 * @description
 */
public interface RequestView extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(EyDetailBean result);
    void resultFailure(String result);
    void resultRecomendar(RankListBean rankListBean);
}
