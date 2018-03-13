package com.example.interviewpractice.adapter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.interviewpractice.ui.fragment.RankListFragment;

/**
 * Created by Administrator on 2018/1/2.
 */

public class RankListFragmentAdapter extends FragmentPagerAdapter {
    public final int MovieCOUNT=3;
    private String[] type=new String[]{"周排行","月排行","总排行"};
    public RankListFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return RankListFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return MovieCOUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return type[position];
    }


}
