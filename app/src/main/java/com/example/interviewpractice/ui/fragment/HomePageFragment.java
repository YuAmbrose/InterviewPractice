package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.CagegoryViewPagerAdapter;
import com.example.interviewpractice.adapter.adapter.EntranceAdapter;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.presenter.BannerPresenterImp;
import com.example.interviewpractice.presenter.CagPesenterImp;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.GlideImageLoader;
import com.example.interviewpractice.utils.ScreenUtil;
import com.example.interviewpractice.view.BannerView;
import com.example.interviewpractice.view.CategorytabView;
import com.example.interviewpractice.weight.IndicatorView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment implements BannerView,CategorytabView{
    public static final int HOME_ENTRANCE_PAGE_SIZE = 10;//首页菜单单页显示数量
    private static final String TAG = "HomePageFragment";
    private ViewPager entranceViewPager;
    private LinearLayout homeEntranceLayout;
    private IndicatorView entranceIndicatorView;

    @BindView(R.id.banner)
    Banner banner;
//    @BindView(R.id.main_home_entrance_vp)
//    ViewPager entranceViewPager;
//    @BindView(R.id.main_home_entrance_indicator)
//    IndicatorView entranceIndicatorView;
//    @BindView(R.id.home_entrance)
//    LinearLayout homeEntranceLayout;
    private  EntranceAdapter entranceAdapter;
    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());
    private CagPesenterImp cagPesenterImp=new CagPesenterImp((CategorytabView) this,getContext());
    private List<CategoryTab> homeEntrances=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        homeEntranceLayout = (LinearLayout) view.findViewById(R.id.home_entrance);
        entranceViewPager = (ViewPager) view.findViewById(R.id.main_home_entrance_vp);
        entranceIndicatorView = (IndicatorView) view.findViewById(R.id.main_home_entrance_indicator);
        bannerPresenterImp. loadBanner();
        cagPesenterImp.categoryTabPes();
        return view;
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void disimissProgress() {

    }




    @Override
    public void loadDataError(Throwable throwable) {
//        bannerPresenterImp.requestError(throwable);
    }

    @Override
    public void loadCagSuccess(CategoryTab tList) {
        homeEntrances.add(tList);
        if (homeEntrances.size()==1){
            init();
        }
    }
    private void init() {
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f));
        //首页菜单分页
        LinearLayout.LayoutParams entrancelayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f + 70));
        homeEntranceLayout.setLayoutParams(entrancelayoutParams);
        entranceViewPager.setLayoutParams(layoutParams12);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        //将RecyclerView放至ViewPager中：
        int pageSize = HOME_ENTRANCE_PAGE_SIZE;
        //一共的页数等于 总数/每页数量，并取整。
        int pageCount = (int) Math.ceil(homeEntrances.size() * 1.0 / pageSize);
        List<View> viewList = new ArrayList<View>();
        for (int index = 0; index < pageCount; index++) {
            //每个页面都是inflate出一个新实例
            RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.item_home_entrance_vp, entranceViewPager, false);
            recyclerView.setLayoutParams(layoutParams12);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
            entranceAdapter = new EntranceAdapter(getContext(), homeEntrances, index, HOME_ENTRANCE_PAGE_SIZE);
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
    @Override
    public void loadDataSuccess(BannerBean tData) {
        Log.e(TAG, "loadDataSuccess: " );
        if (tData.getItemList() != null) {
            List<String> listImage = new ArrayList<>();
            List<String> listTitle = new ArrayList<>();
            for (int i = 3; i < 6; i++) {
                if (i == 6) {
                } else {
                    if (tData.getItemList().get(i).getData().getCover().getFeed() != null && tData.getItemList().get(i).getData().getTitle() != null) {
                        listImage.add(tData.getItemList().get(i).getData().getCover().getFeed());
                        listTitle.add(tData.getItemList().get(i).getData().getTitle());
                    } else {
                        Log.e(TAG, "出错了");
                    }
                }
            }
            banner.setImages((List<?>) listImage)
                    .setImageLoader(new GlideImageLoader())
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setBannerTitles(listTitle)
                    .isAutoPlay(true);
            banner.start();
        }
    }



    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
