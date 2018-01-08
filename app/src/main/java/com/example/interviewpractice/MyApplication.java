package com.example.interviewpractice;

import android.app.Application;
import android.content.Context;

import com.example.interviewpractice.utils.AppContextUtil;
import com.example.interviewpractice.utils.ScreenUtil;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2017/12/26.
 */

public class MyApplication extends Application {
    public static Context applicationContext;
    public static Context getContext() {
        return applicationContext;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        AppContextUtil.init(this);
        ScreenUtil.init(this);
        Bmob.initialize(this, "3294a0f092543dc76c82b6b04134ac6f");
        applicationContext = this;
    }
}

