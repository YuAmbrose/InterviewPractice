package com.example.interviewpractice.v_layout.holder.home;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.ui.fragment.HomePageFragment;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;

import butterknife.BindView;


/**
 * Created by Administrator on 2018/1/11.
 */

public class TabHolder extends VlayoutBaseHolder<RankListBean> {
    @BindView(R.id.ranklisttablayout)
    TabLayout ranklisttablayout;
    @BindView(R.id.ranklistviewpager)
    ViewPager ranklistviewpager;
    private RankListFragmentAdapter rankListFragmentAdapter;
    private static final String TAG = "TabHolder";

    private Activity activity;
    private Fragment fragment=new HomePageFragment();
    public TabHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RankListBean mData) {
        super.setData(ps, mData);
//        android.app.FragmentManager fragmentManager = mC.getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


//        rankListFragmentAdapter = new RankListFragmentAdapter(fragmentTransaction);



        ranklistviewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
//                JCVideoPlayer.releaseAllVideos();
            }
        });
        ranklistviewpager.setAdapter(rankListFragmentAdapter);
        ranklistviewpager.setOffscreenPageLimit(3);
        ranklisttablayout.setupWithViewPager(ranklistviewpager);
    }
    @Override
    public void init() {
        super.init();
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
