package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;
import com.example.interviewpractice.ui.baseView.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class DiscoverFragment extends BaseFragment {

    private static final String TAG = "DiscoverFragment";
    @BindView(R.id.discover_toolbar)
    Toolbar discoverToolbar;
    @BindView(R.id.ranklisttablayout)
    TabLayout ranklisttablayout;
    @BindView(R.id.ranklistviewpager)
    ViewPager ranklistviewpager;
    @BindView(R.id.barlayout)
    LinearLayout barlayout;
    private RankListFragmentAdapter rankListFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, view);
        discoverToolbar.setPadding(0, getStatusBarHeight(this), 0, 0);
        rankListFragmentAdapter = new RankListFragmentAdapter(getFragmentManager());
        ranklistviewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                JCVideoPlayer.releaseAllVideos();
            }
        });
        ranklistviewpager.setAdapter(rankListFragmentAdapter);
        ranklistviewpager.setOffscreenPageLimit(3);
        ranklisttablayout.setupWithViewPager(ranklistviewpager);
        return view;
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: " );
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: " );
        super.onStop();
    }
}
