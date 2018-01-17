package com.example.interviewpractice.v_layout.holder;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;
import com.example.interviewpractice.enity.RankListBean;
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
    private RankListFragmentAdapter rankListFragmentAdapter;
    private Fragment  fragment=new Fragment();
    private Context context;
    public TabHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RankListBean mData) {
        super.setData(ps, mData);
        rankListFragmentAdapter = new RankListFragmentAdapter(fragment.getFragmentManager());
//        rankListFragmentAdapter = new RankListFragmentAdapter();
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
