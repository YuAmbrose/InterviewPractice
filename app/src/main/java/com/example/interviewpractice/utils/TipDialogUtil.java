package com.example.interviewpractice.utils;

import android.content.Context;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.text.DecimalFormat;

/**
 * Created by 鱼握拳 on 2018/3/14.
 */

public class TipDialogUtil {
    private QMUITipDialog tipDialog;
    public  void   getTip(Context context){
        tipDialog = new QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();

    }
}
