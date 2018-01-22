package com.example.interviewpractice.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
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
import com.example.interviewpractice.v_layout.ItemListener;
import com.example.interviewpractice.v_layout.VlayoutBaseAdapter;
import com.example.interviewpractice.v_layout.holder.BannerHolder;
import com.example.interviewpractice.v_layout.holder.GridHolder;
import com.example.interviewpractice.v_layout.holder.HeadHolder;
import com.example.interviewpractice.v_layout.holder.PgcHolder;
import com.example.interviewpractice.v_layout.holder.SelectHolder;
import com.example.interviewpractice.weight.FatRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment implements CategorytabView, BannerView, RankListView, PgcView{
    private static final String TAG = "HomePageFragment";
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    private Context mContext;

    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter banneradapter, pAdapter,setlectAdapter, headAdapter, textAdapter, gridAdapter;

    private List<BannerBean.IssueListBean> listBeansa;
    private List<RankListBean> itemListBeans = new ArrayList<>();
    private List<PgcBean.ItemListBean> pgcBeans;
    private List<CategoryTab> cag = new ArrayList<>();

    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
    private PgcPresenterImp pgcPresenterImp = new PgcPresenterImp(this, getContext());
    private CagPesenterImp cagPesenterImp = new CagPesenterImp(this, getContext());

    private HomeRecyclervAdapter homeRecyclervAdapter=new HomeRecyclervAdapter(getContext());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        cagPesenterImp.categoryTabPes();
        bannerPresenterImp.loadBanner();
        pgcPresenterImp.loadPgc();
        rankListPresenterImp.loadSelect(10, 10);

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        initAdapter();
        return view;
    }

    private void initAdapter() {
        banneradapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_banner)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(BannerHolder.class)
                .setListener(new ItemListener<BannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, BannerBean mData) {
                        Toast.makeText(MyApplication.getContext(), mData.getIssueList().get(0).getItemList().get(position + 1).getData().getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
        pAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<PgcBean>())
                .setLayout(R.layout.vlayout_home_pgc)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(PgcHolder.class);
//                .setListener(new ItemListener<PgcBean>() {
//                    @Override
//                    public void onItemClick(View view, int position, PgcBean mData) {
//                        Toast.makeText(MyApplication.getContext(), mData.getItemList().get(position).getData().getId(), Toast.LENGTH_SHORT).show();
//                    }
//                });
        headAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<String>())
                .setLayout(R.layout.vlayout_home_head)
                .setLayoutHelper(getScrollLayoutHelper())
                .setHolder(HeadHolder.class);
        gridAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<CategoryTab>())
                .setLayout(R.layout.vlayout_home_grid)
                .setHolder(GridHolder.class)
                .setLayoutHelper(getGridLayoutHelper())
                .setListener(new ItemListener<CategoryTab>() {
                    @Override
                    public void onItemClick(View view, int position, CategoryTab mData) {
                        Toast.makeText(MyApplication.getContext(), mData.getType(), Toast.LENGTH_SHORT).show();
                    }
                });
//        rankAdapter=new VlayoutBaseAdapter(mActivity)
//                .setData(new ArrayList<RankListBean>())
//                .setLayout(R.layout.vlayout_home_ranklist)
//                .setLayoutHelper(new LinearLayoutHelper())
//                .setHolder(TabHolder.class);
        setlectAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<RankListBean>())
                .setLayout(R.layout.vlayout_home_select)
                .setLayoutHelper(new LinearLayoutHelper())
                .setListener(new ItemListener<RankListBean>() {
                    @Override
                    public void onItemClick(View view, int position, RankListBean mData) {
                        Toast.makeText(MyApplication.getContext(), mData.getItemList().get(position).getData().getTitle(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setHolder(SelectHolder.class);
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(headAdapter);
        delegateAdapter.addAdapter(pAdapter);
//        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(setlectAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }

    private LayoutHelper getGridLayoutHelp() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        //是否自动扩展
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setPadding(0, 30, 0, 10);
        gridLayoutHelper.setBgColor(Color.parseColor("#FFFFFF"));
        gridLayoutHelper.setVGap(20);
        return gridLayoutHelper;
    }

    private LayoutHelper getGridLayoutHelper() {
        GridLayoutHelper gridHelper = new GridLayoutHelper(4);
        gridHelper.setMarginTop(20);
        gridHelper.setWeights(new float[]{25.0f, 25.0f, 25.0f, 25.0f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(4);
        //设置水平方向条目的间隔
        gridHelper.setHGap(4);
        gridHelper.setMarginLeft(15);
        gridHelper.setMarginBottom(15);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        return gridHelper;
    }

    private LayoutHelper getScrollLayoutHelper() {
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(0, 0);
        scrollFixLayoutHelper.setShowType(2);
        scrollFixLayoutHelper.setPadding(0, getStatusBarHeight(this), 0, 0);
        scrollFixLayoutHelper.setSketchMeasure(true);
//        scrollFixLayoutHelper.setFixViewAnimatorHelper(onGetFixViewAppearAnimator());
        return scrollFixLayoutHelper;
    }

    public ViewPropertyAnimator GetFixViewAppearAnimator(View fixView) {
        int height = fixView.getMeasuredHeight();
        fixView.setTranslationY(-height);
        return fixView.animate().translationYBy(height).alpha(1.0f).setDuration(500);
    }
    private LayoutHelper getWaterHelper() {
        StaggeredGridLayoutHelper staggerHelper = new StaggeredGridLayoutHelper(2, 8);
        staggerHelper.setMargin(0, 20, 0, 10);
        return staggerHelper;
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
        List<BannerBean> b = new ArrayList<>();
        b.add(mData);
        banneradapter.setData(b);
        banneradapter.notifyDataSetChanged();
    }

    /**
     * 热门recyclerview
     *
     * @param rData
     */
    @Override
    public void rankSuccess(RankListBean rData) {
        itemListBeans.add(rData);
        setlectAdapter.setData(itemListBeans);
        setlectAdapter.notifyDataSetChanged();

        headAdapter.setData(itemListBeans);
        headAdapter.notifyDataSetChanged();
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
//        banner.startAutoPlay();
        //开始轮播
    }

    @Override
    public void onStop() {
        super.onStop();
//        banner.stopAutoPlay();
        //结束轮播
    }

    @Override
    public void loadCagSuccess(List<CategoryTab> tData) {
        gridAdapter.setData(tData);
        gridAdapter.notifyDataSetChanged();
    }
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
//            banner.stopAutoPlay();
        }
    }
}