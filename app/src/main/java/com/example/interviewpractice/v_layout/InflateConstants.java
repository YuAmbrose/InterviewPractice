package com.example.interviewpractice.v_layout;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类名: {@link InflateConstants}
 * <br/> 功能描述: 存储全局数据的基本类
 * <br/> 作者: MouTao
 * <br/> 时间: 2017/5/19
 */
public class InflateConstants {

    /**
     * inflater 实例
     */
    private static LayoutInflater inflater;


    /**
     * view 实例
     *
     * @param context
     * @param parent
     * @param res
     * @return
     */
    public static View inflate(Context context, ViewGroup parent, int res) {
        if (inflater == null) {
            inflater = LayoutInflater.from(context);
        }
        return inflater.inflate(res, parent, false);

    }

}
