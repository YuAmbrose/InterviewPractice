package com.example.interviewpractice.v_layout.holder;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.ui.fragment.HomePageFragment;
import com.example.interviewpractice.v_layout.VBaseHolder;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2018/1/11.
 */

public class TabHolder extends VBaseHolder<RankListBean> {
    @BindView(R.id.ranklisttablayout)
    TabLayout ranklisttablayout;
    @BindView(R.id.ranklistviewpager)
    ViewPager ranklistviewpager;
    private static final String TAG = "TabHolder";
    private FragmentManager fragmentManager;
    private RankListFragmentAdapter rankListFragmentAdapter;
    private HomePageFragment fragment;
    public TabHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RankListBean mData) {
        super.setData(ps, mData);
        Log.e(TAG, "排行榜————"+mData.getItemList().size() );
        fragment=new HomePageFragment();
        fragmentManager=fragment.getFragmentManager();
        rankListFragmentAdapter = new RankListFragmentAdapter(fragmentManager);
        ranklistviewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                JCVideoPlayer.releaseAllVideos();
            }
        });
        ranklistviewpager.setAdapter(rankListFragmentAdapter);
        ranklistviewpager.setOffscreenPageLimit(3);
        ranklisttablayout.setupWithViewPager(ranklistviewpager);
    }
}
