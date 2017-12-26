package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.ui.baseView.BaseFragment;


public class MineFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }


}
