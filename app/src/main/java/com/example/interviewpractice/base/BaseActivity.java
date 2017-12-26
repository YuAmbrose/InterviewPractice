package com.example.interviewpractice.base;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public class BaseActivity extends AppCompatActivity {
    /**
     * 获取状态栏的高度
     * @param fragment
     * @return
     */
    public int getStatusBarHeight(Fragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }
}
