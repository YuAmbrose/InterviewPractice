package com.example.interviewpractice.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by 鱼握拳 on 2018/3/18.
 */

public class UtilsHelp {
    /**
     *  //强制隐藏键盘
     * @param context
     * @param view
     * @param isShow
     */
    public static void setSoftInputActive(Context context, View view, boolean isShow) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.
                INPUT_METHOD_SERVICE);
        if (isShow) {
            imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        } else {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
