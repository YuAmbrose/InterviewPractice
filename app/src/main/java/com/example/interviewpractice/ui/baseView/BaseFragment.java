package com.example.interviewpractice.ui.baseView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public  abstract class BaseFragment extends Fragment {
    private boolean isInit;
    private boolean isLoad;



    public int getStatusBarHeight(BaseFragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }

}
