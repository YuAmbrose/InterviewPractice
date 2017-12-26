package com.example.interviewpractice;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;


import com.example.interviewpractice.base.BaseActivity;
import com.example.interviewpractice.utils.BottomNavigationViewHelper;


public class MainActivity extends BaseActivity{
    private BottomNavigationView mBottomNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar= (BottomNavigationView) findViewById(R.id.bottomnavgationview);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationBar);

    }
}
