package com.example.interviewpractice.weight;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/1/11.
 */

public class FatRecyclerview extends BetterRecyclerView {
    public FatRecyclerview(Context context) {
        super(context);
    }

    public FatRecyclerview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FatRecyclerview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    /* do nothing */
    }
}
