package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.ui.baseView.BaseFragment;


public class ForumFragment extends BaseFragment{
    private static final String TAG = "ForumFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_forum, container, false);

        return view;
    }

}
