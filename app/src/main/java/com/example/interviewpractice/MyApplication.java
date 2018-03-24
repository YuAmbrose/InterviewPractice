package com.example.interviewpractice;

import android.app.Application;
import android.content.Context;

import com.example.interviewpractice.utils.util.AppContextUtil;
import com.example.interviewpractice.utils.util.ScreenUtil;
import com.tencent.smtt.sdk.QbSdk;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2017/12/26.
 */

public class MyApplication extends Application {
    public static Context applicationContext;
    public static Context getContext() {
        return applicationContext;
    }

    private void initX5Core() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功
                //否则表示x5内核加载失败，会自动切换到系统内核。
            }
            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        AppContextUtil.init(this);
        ScreenUtil.init(this);
        Bmob.initialize(this, "3294a0f092543dc76c82b6b04134ac6f");
        applicationContext = this;
        initX5Core();
    }
}

