package com.example.interviewpractice.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.example.interviewpractice.MainActivity;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.enity.ZhihuHotBean;
import com.example.interviewpractice.mvp.homepage.presenter.BannerPresenterImp;
import com.example.interviewpractice.mvp.homepage.presenter.CagPesenterImp;
import com.example.interviewpractice.mvp.homepage.presenter.PgcPresenterImp;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.presenter.ZHotPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.BannerView;
import com.example.interviewpractice.mvp.homepage.view.CategorytabView;
import com.example.interviewpractice.mvp.homepage.view.PgcView;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.example.interviewpractice.mvp.homepage.view.ZHotView;
import com.example.interviewpractice.ui.activity.ArticleActivity;
import com.example.interviewpractice.ui.activity.AuthorDetailActivity;
import com.example.interviewpractice.ui.activity.CategoryActivity;
import com.example.interviewpractice.ui.activity.EDetailActivity;
import com.example.interviewpractice.ui.activity.MoreAuthorActivity;
import com.example.interviewpractice.ui.activity.RankActivity;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.v_layout.ItemListener;
import com.example.interviewpractice.v_layout.VlayoutBaseAdapter;
import com.example.interviewpractice.v_layout.holder.home.BannerHolder;
import com.example.interviewpractice.v_layout.holder.home.EndHolder;
import com.example.interviewpractice.v_layout.holder.home.GridHolder;
import com.example.interviewpractice.v_layout.holder.home.HeadHolder;
import com.example.interviewpractice.v_layout.holder.home.HotHeadHolder;
import com.example.interviewpractice.v_layout.holder.home.PgcHeadHolder;
import com.example.interviewpractice.v_layout.holder.home.PgcHolder;
import com.example.interviewpractice.v_layout.holder.home.SelectHolder;
import com.example.interviewpractice.v_layout.holder.home.ZHotHolder;
import com.example.interviewpractice.weight.FatRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment implements CategorytabView, BannerView, RankListView, PgcView, ZHotView {
    private static final String TAG = "HomePageFragment";
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    @BindView(R.id.home_fragment)
    LinearLayout home_Fragment;
    private Context mContext;

    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter banneradapter, pAdapter, setlectAdapter, headAdapter, textAdapter, gridAdapter, zhotAdapter, pgcAdapter, selectheadAdapter, hotheadAdapter, endAdapter;

    private List<BannerBean.IssueListBean> listBeansa;
    private List<RankListBean> itemListBeans = new ArrayList<>();
    private List<PgcBean.ItemListBean> pgcBeans;
    private List<CategoryTab> cag = new ArrayList<>();
    private List<ZhihuHotBean> zhihuHotBeans = new ArrayList<>();
    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
    private PgcPresenterImp pgcPresenterImp = new PgcPresenterImp(this, getContext());
    private CagPesenterImp cagPesenterImp = new CagPesenterImp(this, getContext());
    private ZHotPresenterImp zHotPresenterImp = new ZHotPresenterImp(this, getContext());
    private HomeRecyclervAdapter homeRecyclervAdapter = new HomeRecyclervAdapter(getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        cagPesenterImp.categoryTabPes();
        bannerPresenterImp.loadBanner();
        pgcPresenterImp.loadPgc(10,10);
        rankListPresenterImp.loadSelect(10, 20);
        zHotPresenterImp.loadZhiHuNews();
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
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
                        int id=mData.getIssueList().get(0).getItemList().get(position + 1).getData().getId();
                        Intent bannerIntent=new Intent(MyApplication.getContext(), EDetailActivity.class);
                        bannerIntent.putExtra("id",String.valueOf(id));
                        startActivity(bannerIntent);
//                        Toast.makeText(MyApplication.getContext(), mData.getIssueList().get(position).getItemList().get(position).getId(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onItemClick: "+mData.getIssueList().get(0).getItemList().get(position + 1).getData().getId() );
//                        Toast.makeText(MyApplication.getContext(), mData.getIssueList().get(0).getItemList().get(position + 1).getData().getSlogan(), Toast.LENGTH_SHORT).show();
                    }
                });
        pgcAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_pgchead)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(PgcHeadHolder.class)
                .setListener(new ItemListener() {
                    @Override
                    public void onItemClick(View view, int position, Object mData) {
                        Intent intent=new Intent(MyApplication.getContext(), MoreAuthorActivity.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
                    }
                });
        selectheadAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_selecthead)
                .setLayoutHelper(getLinearLayoutHelper())
                .setHolder(PgcHeadHolder.class)
                .setListener(new ItemListener() {
                    @Override
                    public void onItemClick(View view, int position, Object mData) {

                    }
                });
        endAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_end)
                .setLayoutHelper(getSingleLayoutHelper())
                .setHolder(EndHolder.class);
        hotheadAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_hothead)
                .setLayoutHelper(getLinearLayoutHelper())
                .setHolder(HotHeadHolder.class);
        pAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<PgcBean>())
                .setLayout(R.layout.vlayout_home_pgc)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(PgcHolder.class)
                .setListener(new ItemListener<PgcBean>() {
                    @Override
                    public void onItemClick(View view, int position, PgcBean mData) {
                        Intent anthorIntent=new Intent(MyApplication.getContext(), AuthorDetailActivity.class);
                        int id=mData.getItemList().get(position).getData().getId();
                        anthorIntent.putExtra("id",String.valueOf(id));
                        startActivity(anthorIntent);
                        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
                    }
                });

        headAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<String>())
                .setLayout(R.layout.vlayout_home_head)
                .setLayoutHelper(getScrollLayoutHelper())
                .setHolder(HeadHolder.class)
                .setListener(new ItemListener() {
            @Override
            public void onItemClick(View view, int position, Object mData) {
                Toast.makeText(MyApplication.getContext(), "886668", Toast.LENGTH_SHORT).show();
            }
        });
        gridAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<CategoryTab>())
                .setLayout(R.layout.vlayout_home_grid)
                .setLayoutHelper(getGridLayoutHelper())
                .setHolder(GridHolder.class)
                .setListener(new ItemListener<CategoryTab>() {
                    @Override
                    public void onItemClick(View view, int position, CategoryTab mData) {
                        switch (mData.getId()){
                            case "0":
                             Intent artIntent=new Intent(MyApplication.getContext(), ArticleActivity.class);
                             startActivity(artIntent);
                                break;
                            case "1":
                                Toast.makeText(MyApplication.getContext(), mData.getId(), Toast.LENGTH_SHORT).show();
                                break;
                            case "2":
                            Intent cagIntent =new Intent(MyApplication.getContext(), CategoryActivity.class);
                                startActivity(cagIntent);
                                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
                                break;
                            case "3":
                                Intent intent=new Intent(MyApplication.getContext(), RankActivity.class);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
                                break;
                                default:
                        }

                    }
                });
        zhotAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ZhihuHotBean>())
                .setLayoutHelper(new StaggeredGridLayoutHelper())
                .setLayout(R.layout.vlayout_home_zhhot)
                .setHolder(ZHotHolder.class);
        setlectAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<RankListBean>())
                .setLayoutHelper(new LinearLayoutHelper())
                .setLayout(R.layout.vlayout_home_select)
                .setHolder(SelectHolder.class)
                .setListener(new ItemListener<RankListBean>() {
                    @Override
                    public void onItemClick(View view, int position, RankListBean mData) {
                        Intent selectIntent=new Intent(MyApplication.getContext(), EDetailActivity.class);
                        int id=mData.getItemList().get(position).getData().getId();
                        selectIntent.putExtra("id",String.valueOf(id));
                        startActivity(selectIntent);
                        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
//                        replaceFragment(new AuthorDetailFragment());
//                        Log.e(TAG, "onItemClick: "+mData.getItemList().get(position).getData().getId());
//                        Toast.makeText(MyApplication.getContext(), "888", Toast.LENGTH_SHORT).show();
                    }
                });
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(headAdapter);
        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(selectheadAdapter);
        delegateAdapter.addAdapter(setlectAdapter);
        delegateAdapter.addAdapter(pgcAdapter);
        delegateAdapter.addAdapter(pAdapter);
        delegateAdapter.addAdapter(hotheadAdapter);
        delegateAdapter.addAdapter(zhotAdapter);
        delegateAdapter.addAdapter(endAdapter);
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

    private LayoutHelper getColumnLayoutHelper() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setItemCount(3);// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{30, 40, 30});// 设置该行每个Item占该行总宽度的比例
        return columnLayoutHelper;
    }

    private LayoutHelper getSingleLayoutHelper() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(0, 20, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        return singleLayoutHelper;
    }

    private LayoutHelper getLinearLayoutHelper() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setPadding(0, 25, 0, 15);
        return linearLayoutHelper;
    }

    private LayoutHelper getScrollLayoutHelper() {
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(0, 0);
        scrollFixLayoutHelper.setShowType(2);
        scrollFixLayoutHelper.setPadding(0, getStatusBarHeight(this), 0, 0);
        scrollFixLayoutHelper.setSketchMeasure(true);
//        scrollFixLayoutHelper.setFixViewAnimatorHelper(onGetFixViewAppearAnimator());
        return scrollFixLayoutHelper;
    }

    public ViewPropertyAnimator getFixViewAppearAnimator(View fixView) {
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
        pgcAdapter.setData(b);
        pgcAdapter.notifyDataSetChanged();
        selectheadAdapter.setData(b);
        selectheadAdapter.notifyDataSetChanged();
        hotheadAdapter.setData(b);
        hotheadAdapter.notifyDataSetChanged();
        endAdapter.setData(b);
        endAdapter.notifyDataSetChanged();
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
        if (hidden) {
//            banner.stopAutoPlay();
        }
    }

    @Override
    public void loadSuccess(ZhihuHotBean tData) {
        zhihuHotBeans.add(tData);
        zhotAdapter.setData(zhihuHotBeans);
        zhotAdapter.notifyDataSetChanged();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.home_fragment,fragment);
        ft.addToBackStack(null);
        ft.commit();


//        FragmentManager fm = getChildFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        HomePageFragment homePageFragment=new HomePageFragment();
//        ft.hide(homePageFragment);
//        if (fragment==null){
//            ft.add(R.id.home_fragment, fragment);
//        }else {
//            ft.show(fragment);
//        }
//        ft.addToBackStack(null);
//        ft.commit();
    }
}