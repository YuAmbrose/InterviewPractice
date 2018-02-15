package com.example.interviewpractice.ui.fragment.childFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BlankFragment extends Fragment {
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this, view);
        RankListFragmentAdapter rankListFragmentAdapter = new RankListFragmentAdapter(getFragmentManager());
        viewpager.setAdapter(rankListFragmentAdapter);
        viewpager.setOffscreenPageLimit(3);
        tablayout.setupWithViewPager(viewpager);
        return view;
    }

}
