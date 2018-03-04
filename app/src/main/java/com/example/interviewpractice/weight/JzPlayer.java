package com.example.interviewpractice.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 鱼握拳 on 2018/2/17.
 */

public class JzPlayer extends JZVideoPlayerStandard {


    public JzPlayer(Context context) {
        super(context);
    }

    public JzPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setUp(String url, int screen, Object... objects) {
        super.setUp(url, screen, objects);
        if (currentScreen == SCREEN_WINDOW_NORMAL
                || currentScreen == SCREEN_WINDOW_LIST){
            backButton.setVisibility(View.VISIBLE);
        }else {
            backButton.setVisibility(View.VISIBLE);
        }
    }



    @Override
    public void onStatePlaying() {
        super.onStatePlaying();
//        backButton.setVisibility(VISIBLE);
    }
}
