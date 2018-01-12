package com.example.interviewpractice.v_layout.holder;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.CagegoryViewPagerAdapter;
import com.example.interviewpractice.adapter.adapter.EntranceAdapter;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.utils.ScreenUtil;
import com.example.interviewpractice.v_layout.VBaseHolder;
import com.example.interviewpractice.weight.IndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/11.
 */

public class CagHolder extends VBaseHolder<CategoryTab> {
    @BindView(R.id.main_home_entrance_vp)
    ViewPager entranceViewPager;
    @BindView(R.id.main_home_entrance_indicator)
    IndicatorView entranceIndicatorView;
    @BindView(R.id.home_entrance)
    LinearLayout homeEntranceLayout;
    private EntranceAdapter entranceAdapter;
    private List<CategoryTab> homeEntrances=new ArrayList<>();
    public static final int HOME_ENTRANCE_PAGE_SIZE = 10;//首页菜单单页显示数量
    private static final String TAG = "CagHolder";
    public CagHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, CategoryTab mData) {
        super.setData(ps, mData);
        homeEntrances.add(mData);
        Log.e(TAG, "setData: ====="+homeEntrances.size() );
        initViewpager();
//        if (homeEntrances.size() <= 10) {
//            initViewpager();
//            entranceIndicatorView.setVisibility(View.GONE);
//        } else {
//            entranceIndicatorView.setVisibility(View.VISIBLE);
//            initViewpager();
//        }
    }

    private void initViewpager() {
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f));
//        FrameLayout.LayoutParams entrancelayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f + 70));
        LinearLayout.LayoutParams entrancelayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f + 70));
        homeEntranceLayout.setLayoutParams(entrancelayoutParams);
        entranceViewPager.setLayoutParams(layoutParams12);
        LayoutInflater inflater = LayoutInflater.from(MyApplication.getContext());
        int pageSize = HOME_ENTRANCE_PAGE_SIZE;
        int pageCount = (int) Math.ceil(homeEntrances.size() * 1.0 / pageSize);
        List<View> viewList = new ArrayList<View>();
        for (int index = 0; index < pageCount; index++) {
            RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.item_home_entrance_vp, entranceViewPager, false);
            recyclerView.setLayoutParams(layoutParams12);
            recyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getContext(), 5));
            entranceAdapter = new EntranceAdapter(MyApplication.getContext(), homeEntrances, index, HOME_ENTRANCE_PAGE_SIZE);
            recyclerView.setAdapter(entranceAdapter);
            viewList.add(recyclerView);
        }
        CagegoryViewPagerAdapter adapter = new CagegoryViewPagerAdapter(viewList);
        entranceViewPager.setAdapter(adapter);
        entranceIndicatorView.setIndicatorCount(entranceViewPager.getAdapter().getCount());
        entranceIndicatorView.setCurrentIndicator(entranceViewPager.getCurrentItem());
        entranceAdapter.notifyDataSetChanged();
        entranceViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                entranceIndicatorView.setCurrentIndicator(position);
            }
        });
    }
}
