package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DiscoverFragment extends BaseFragment {

    private static final String TAG = "DiscoverFragment";

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
//    @BindView(R.id.ranklisttablayout)
//    TabLayout ranklisttablayout;
//    @BindView(R.id.ranklistviewpager)
//    ViewPager ranklistviewpager;

    private RankListFragmentAdapter rankListFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, view);
        mTopBar.setTitle("发现");
//        rankListFragmentAdapter = new RankListFragmentAdapter(getFragmentManager());
//        ranklistviewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
//            @Override
//            public void onPageSelected(int position) {
//                JCVideoPlayer.releaseAllVideos();
//            }
//        });
//        ranklistviewpager.setAdapter(rankListFragmentAdapter);
//        ranklistviewpager.setOffscreenPageLimit(3);
//        ranklisttablayout.setupWithViewPager(ranklistviewpager);
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
