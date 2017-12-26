package com.example.interviewpractice;

import android.app.Application;
import android.content.Context;

import com.example.interviewpractice.utils.AppContextUtil;

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
        applicationContext = this;
    }
}

