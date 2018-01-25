package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.FragmentViewPagerAdapter;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;
import com.example.interviewpractice.ui.baseView.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;


public class DiscoverFragment extends BaseFragment {

    private static final String TAG = "DiscoverFragment";
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private List<String> titles;
    private List<Fragment> fragments;
    private int[] tabIcons = {R.drawable.select_movie, R.drawable.select_start};
//    @BindView(R.id.topbar)
//    QMUITopBar mTopBar;
    @BindView(R.id.statebar)
    View statebarHeight;

//    @BindView(R.id.ranklisttablayou)
//    TabLayout ranklisttablayout;
//    @BindView(R.id.ranklistviewpage)
//    ViewPager ranklistviewpager;

    private RankListFragmentAdapter rankListFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, view);
        fragments = new ArrayList<>();
        fragments.add(new HomeMovieFragment());
        fragments.add(new StartFragment());
        titles = new ArrayList<>();
        titles.add("One");
        titles.add("Two");
        titles = new ArrayList<>();
        titles.add("One");
        titles.add("Two");
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        viewPager.setCurrentItem(1);
        viewPager.setCurrentItem(0);//直接设置0的话竟然不起作用,好吧.就这样迂回一下吧
//        mTopBar.setTitle("发现");
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) statebarHeight.getLayoutParams();//获取当前控件的布局对象
        params.height=getStatusBarHeight(this);//设置当前控件布局的高度
        statebarHeight.setLayoutParams(params);//将设置好的布局参数应用到控件中

//        rankListFragmentAdapter = new RankListFragmentAdapter(getFragmentManager());
         viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
               JZVideoPlayer.releaseAllVideos();
            }
        });
//        ranklistviewpager.setAdapter(rankListFragmentAdapter);
//        ranklistviewpager.setOffscreenPageLimit(3);
//        ranklisttablayout.setupWithViewPager(ranklistviewpager);
        return view;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setCustomView(getTabView(0));
        tabLayout.getTabAt(1).setCustomView(getTabView(1));
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_tab, null);
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        img_title.setImageResource(tabIcons[position]);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setText(titles.get(position));
        return view;
    }


    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            JZVideoPlayer.releaseAllVideos();
        }
    }


}
