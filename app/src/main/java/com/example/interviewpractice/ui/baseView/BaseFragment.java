package com.example.interviewpractice.ui.baseView;

import android.support.v4.app.Fragment;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public class BaseFragment extends Fragment {
    public int getStatusBarHeight(BaseFragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }
}
