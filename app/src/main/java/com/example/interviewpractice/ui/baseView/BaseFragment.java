package com.example.interviewpractice.ui.baseView;

import android.support.v4.app.Fragment;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public class BaseFragment extends Fragment {
    private boolean isInit;
    private boolean isLoad;
    public int getStatusBarHeight(BaseFragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        loadData();
    }

    private void loadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoadEveryTime();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
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
