package com.example.interviewpractice.mvp.EyDetail;

import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.EyReplyBean;
import com.example.interviewpractice.enity.RankListBean;


/**
 * @date 2018/2/17
 * @description
 */
public interface RequestView extends IMvpBaseView {
    void requestLoading();
    void resultSuccess(EyDetailBean result);
    void resultFailure(String result);
    void resultRecomendar(RankListBean rankListBean);
    void  resultReply(EyReplyBean replyBean);
}
