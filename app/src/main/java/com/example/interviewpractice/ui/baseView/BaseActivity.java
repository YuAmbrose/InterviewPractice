package com.example.interviewpractice.ui.baseView;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.qmuiteam.qmui.arch.QMUIFragmentActivity;


/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public  abstract class BaseActivity extends QMUIFragmentActivity {
    /**
     * 获取状态栏的高度
     * @param fragment
     * @return
     */
    public int getStatusBarHeight(Fragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }

    @Override
    protected abstract int getContextViewId();

    /**
     * 切换fragment
     * @param fragment
     */

}
