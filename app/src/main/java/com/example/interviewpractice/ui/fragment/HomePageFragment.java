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
import com.example.interviewpractice.mvp.presenter.PgcPresenterImp;
import com.example.interviewpractice.mvp.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.view.BannerView;
import com.example.interviewpractice.mvp.view.PgcView;
import com.example.interviewpractice.mvp.view.RankListView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.v_layout.VBaseAdapter;
import com.example.interviewpractice.v_layout.holder.BannerHolder;
import com.example.interviewpractice.v_layout.holder.PgcHolder;
import com.example.interviewpractice.v_layout.holder.SelectHolder;
import com.example.interviewpractice.v_layout.holder.TabHolder;
import com.example.interviewpractice.weight.FatRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment implements BannerView,RankListView, PgcView {
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
    private VBaseAdapter banneradapter,pAdapter,rankAdapter,setlectAdapter;
    private List<BannerBean.IssueListBean> listBeansa;
    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());
    public static final int HOME_ENTRANCE_PAGE_SIZE = 10;//首页菜单单页显示数量
    private EntranceAdapter entranceAdapter;
    private HomeRecyclervAdapter homeRecyclervAdapter;
    private List<RankListBean> itemListBeans=new ArrayList<RankListBean>();
    private List<PgcBean.ItemListBean> pgcBeans;
    private List<CategoryTab> cag = new ArrayList<>();
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
    private PgcPresenterImp pgcPresenterImp = new PgcPresenterImp(this, getContext());
    private PgcAdapter pgcAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);

        pgcPresenterImp.loadPgc();
        rankListPresenterImp.loadSelect();
        bannerPresenterImp.loadBanner();

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
        rankAdapter=new VBaseAdapter(mContext)
                .setData(new ArrayList<RankListBean>())
                .setLayout(R.layout.vlayout_home_ranklist)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(TabHolder.class);
        setlectAdapter=new VBaseAdapter(mContext)
                    .setData(new ArrayList<RankListBean>())
                    .setLayout(R.layout.vlayout_home_select)
                    .setLayoutHelper(new LinearLayoutHelper())
                    .setHolder(SelectHolder.class);
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(pAdapter);
        delegateAdapter.addAdapter(rankAdapter);
        delegateAdapter.addAdapter(setlectAdapter);
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
     * 热门recyclerview
     *
     * @param rData
     */
    @Override
    public void rankSuccess(RankListBean rData) {


        itemListBeans.add(rData);
        setlectAdapter.setData(itemListBeans);
        setlectAdapter.notifyDataSetChanged();

//        rData.getItemList().remove(0);
//        rData.getItemList().remove(1);
//        itemListBeans = rData.getItemList();
//        homeRecyclervAdapter.addAll(itemListBeans);
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

    /**
     * 分类栏的实现
     *
     * @param tList
     */
}