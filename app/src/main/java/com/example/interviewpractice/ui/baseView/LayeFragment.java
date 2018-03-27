package com.example.interviewpractice.ui.baseView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 鱼握拳 on 2018/3/27.
 */

public abstract class LayeFragment extends Fragment{
    public boolean mHaveLoadData; // 表示是否已经请求过数据
    private boolean isInit;
    private boolean isLoad;
    public boolean mLoadDataFinished; // 表示数据是否已经请求完毕
    private View mRootView;
    // 表示开始加载数据, 但不表示数据加载已经完成
    public abstract void loadDataStart();
    // 表示找控件完成, 给控件们设置数据不会报空指针了
    public boolean mViewInflateFinished;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            return mRootView;
        }
        mRootView = initRootView(inflater, container, savedInstanceState);
        findViewById(mRootView);
        mViewInflateFinished = true;
        return mRootView;
    }
    protected abstract void findViewById(View view);

    protected abstract View initRootView(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState);
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        /**
         * 如果还没有加载过数据 && 用户切换到了这个fragment,那就开始加载数据
         */

        if (!mHaveLoadData && isVisibleToUser) {
            loadDataStart();
            mHaveLoadData = true;
        }
    }

    protected void lazyLoadEveryTime() {

    }

    /**
     * 取消懒加载
     */
    protected void stopLoad() {

    }
}
