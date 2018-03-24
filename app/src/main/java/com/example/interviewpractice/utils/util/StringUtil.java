package com.example.interviewpractice.utils.util;


import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/2/10.
 */

public class StringUtil {

    /**
     * 将数字转为带单位(万)
     */
    public static String changeNumToCN(int num) {
        DecimalFormat format = new DecimalFormat("0.0");
        int u = (int) Math.floor(Math.log10(num));
        if (u >= 5) {
            return String.format("%s万", format.format(num / 10000.0));
        } else return String.format("%s", num);
    }


}
