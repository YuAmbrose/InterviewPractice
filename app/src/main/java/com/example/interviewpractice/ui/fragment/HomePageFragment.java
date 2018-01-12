package com.example.interviewpractice.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.EntranceAdapter;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.adapter.adapter.PgcAdapter;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.presenter.BannerPresenterImp;
import com.example.interviewpractice.mvp.presenter.CagPesenterImp;
import com.example.interviewpractice.mvp.presenter.PgcPresenterImp;
import com.example.interviewpractice.mvp.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.view.BannerView;
import com.example.interviewpractice.mvp.view.CategorytabView;
import com.example.interviewpractice.mvp.view.PgcView;
import com.example.interviewpractice.mvp.view.RankListView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.v_layout.VBaseAdapter;
import com.example.interviewpractice.v_layout.holder.BannerHolder;
import com.example.interviewpractice.v_layout.holder.CagHolder;
import com.example.interviewpractice.v_layout.holder.PgcHolder;
import com.example.interviewpractice.weight.FatRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment implements BannerView, CategorytabView, RankListView, PgcView {
    //    @BindView(R.id.banner)
//    Banner banner;
//    @BindView(R.id.main_home_entrance_vp)
//    ViewPager entranceViewPager;
//    @BindView(R.id.main_home_entrance_indicator)
//    IndicatorView entranceIndicatorView;
//    @BindView(R.id.home_entrance)
//    LinearLayout homeEntranceLayout;
//
//    @BindView(R.id.easyrecycler)
//    EasyRecyclerView easyrecycler;
//    @BindView(R.id.pgc_recyclerview)
//    EasyRecyclerView pgcRecyclerview;
    private static final String TAG = "HomePageFragment";
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private VBaseAdapter banneradapter,pAdapter,cagAdapter;
    private List<BannerBean.IssueListBean> listBeansa;
    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());
    private CagPesenterImp cagPesenterImp = new CagPesenterImp(this, getContext());
    public static final int HOME_ENTRANCE_PAGE_SIZE = 10;//首页菜单单页显示数量
    private EntranceAdapter entranceAdapter;
    private HomeRecyclervAdapter homeRecyclervAdapter;
    private List<RankListBean.ItemListBean> itemListBeans;
    private List<PgcBean.ItemListBean> pgcBeans;
    private   List<CategoryTab> cag = new ArrayList<>();
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
    private PgcPresenterImp pgcPresenterImp = new PgcPresenterImp(this, getContext());
    private PgcAdapter pgcAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
//
//        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        pgcRecyclerview.setLayoutManager(layoutManager);
//        pgcAdapter=new PgcAdapter(getContext());
////        StaggeredGridLayoutManager pgcGridLayoutManager = new StaggeredGridLayoutManager(10, StaggeredGridLayoutManager.HORIZONTAL);
////        pgcAdapter=new PgcAdapter(getContext());
////        pgcRecyclerview.setLayoutManager(pgcGridLayoutManager);
//        pgcRecyclerview.setAdapter(pgcAdapter);
//
//
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
//        homeRecyclervAdapter = new HomeRecyclervAdapter(getContext());
//        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
//        easyrecycler.setAdapter(homeRecyclervAdapter);

        pgcPresenterImp.loadPgc();
        rankListPresenterImp.loadSelect();
        bannerPresenterImp.loadBanner();
        cagPesenterImp.categoryTabPes();
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        //设置缓存view个数(当视图中view的个数很多时，设置合理的缓存大小，防止来回滚动时重新创建 View)
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        initAdapter();
        return view;
    }

    private void initAdapter() {
        banneradapter = new VBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_banner)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(BannerHolder.class);
        pAdapter = new VBaseAdapter(mContext)
                .setData(new ArrayList<PgcBean>())
                .setLayout(R.layout.vlayout_home_pgc)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(PgcHolder.class);
        cagAdapter= new VBaseAdapter(mContext)
                .setData(new ArrayList<CategoryTab>())
                .setLayout(R.layout.vlayout_home_cag)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(CagHolder.class);
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(pAdapter);
        delegateAdapter.addAdapter(cagAdapter);
        mRecycler.setAdapter(delegateAdapter);

    }

    @Override
    public void loadDataError(Throwable throwable) {
        bannerPresenterImp.requestError(throwable);
    }




    @Override
    public void loadPgc(PgcBean pData) {
        List<PgcBean> c = new ArrayList<>();
        c.add(pData);
        pAdapter.setData(c);
        pAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadDataSuccess(BannerBean mData) {
        List<BannerBean> b = new ArrayList<BannerBean>();
        b.add(mData);
        banneradapter.setData(b);
        banneradapter.notifyDataSetChanged();

    }


    /**
     * 分类栏的实现
     *
     * @param tList
     */
    @Override
    public void loadCagSuccess(CategoryTab tList) {
        Log.e(TAG, "======"+tList.getType()+tList.getId()+tList.getTypeIcon());
        cag.add(tList);
        Log.e(TAG, "******     -  "+cag.size() );
        cagAdapter.setData(cag);
        cagAdapter.notifyDataSetChanged();

//        if (tList.toString().isEmpty()) {
//        } else {
//        }
//        if (homeEntrances.size() <= 10) {
//            init();
//            entranceIndicatorView.setVisibility(View.GONE);
//        } else {
//            entranceIndicatorView.setVisibility(View.VISIBLE);
//            init();
//        }
    }

    /***
     * 初始化分类栏的滑动
     */
//    public void init() {
//        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f));
////        FrameLayout.LayoutParams entrancelayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f + 70));
//        LinearLayout.LayoutParams entrancelayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 2.0f + 70));
//        homeEntranceLayout.setLayoutParams(entrancelayoutParams);
//        entranceViewPager.setLayoutParams(layoutParams12);
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        int pageSize = HOME_ENTRANCE_PAGE_SIZE;
//        int pageCount = (int) Math.ceil(homeEntrances.size() * 1.0 / pageSize);
//        List<View> viewList = new ArrayList<View>();
//        for (int index = 0; index < pageCount; index++) {
//            RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.item_home_entrance_vp, entranceViewPager, false);
//            recyclerView.setLayoutParams(layoutParams12);
//            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
//            entranceAdapter = new EntranceAdapter(getContext(), homeEntrances, index, HOME_ENTRANCE_PAGE_SIZE);
//            recyclerView.setAdapter(entranceAdapter);
//            viewList.add(recyclerView);
//        }
//        CagegoryViewPagerAdapter adapter = new CagegoryViewPagerAdapter(viewList);
//        entranceViewPager.setAdapter(adapter);
//        entranceIndicatorView.setIndicatorCount(entranceViewPager.getAdapter().getCount());
//        entranceIndicatorView.setCurrentIndicator(entranceViewPager.getCurrentItem());
//        entranceAdapter.notifyDataSetChanged();
//        entranceViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                entranceIndicatorView.setCurrentIndicator(position);
//            }
//        });
//    }

    /**
     * 热门recyclerview
     *
     * @param rData
     */
    @Override
    public void rankSuccess(RankListBean rData) {
        rData.getItemList().remove(0);
        rData.getItemList().remove(1);
        itemListBeans = rData.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);
    }

    @Override
    public void selectSuccess(RankListBean sData) {

    }


    @Override
    public void onPause() {
        super.onPause();

    }

    public void onStart() {
        super.onStart();
        //开始轮播

    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播

    }
}