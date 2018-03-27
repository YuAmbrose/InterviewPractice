package com.example.interviewpractice.adapter.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.interviewpractice.ui.fragment.RankListFragment;
import com.example.interviewpractice.ui.fragment.childFragment.AuthorDetailFragment;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class AuthorListFragmentAdapter extends FragmentPagerAdapter {
    public final int MovieCOUNT=2;
    private String[] type=new String[]{"全部作品","最受欢迎"};
    public AuthorListFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return AuthorDetailFragment.newInstance(position);
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

