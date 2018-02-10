package com.example.interviewpractice.mvp.discover;

/**
 * Created by 鱼握拳 on 2018/1/27.
 */

public abstract class AbstractMvpPersenter<V extends IMvpBaseView> {

    private V mMvpView;

    /**
     * 绑定V层
     * @param view
     */
    public void attachMvpView(V view){
        this.mMvpView = view;
    }

    /**
     * 解除绑定V层
     */
    public void detachMvpView(){
        mMvpView = null;
    }

    /**
     * 获取V层
     * @return
     */
    public V getmMvpView() {
        return mMvpView;
    }
}