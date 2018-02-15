package com.example.interviewpractice.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.mvp.discover.presenter.ComingPresenterImp;
import com.example.interviewpractice.mvp.discover.presenter.PrevuePresenterImp;
import com.example.interviewpractice.mvp.discover.presenter.HotMoviePresenterImp;
import com.example.interviewpractice.mvp.discover.view.ComingView;
import com.example.interviewpractice.mvp.discover.view.PrevueView;
import com.example.interviewpractice.mvp.discover.view.HotMovieView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.v_layout.ItemListener;
import com.example.interviewpractice.v_layout.VlayoutBaseAdapter;
import com.example.interviewpractice.v_layout.holder.discover.ComingHolder;
import com.example.interviewpractice.v_layout.holder.discover.PrevueHolder;
import com.example.interviewpractice.v_layout.holder.discover.HotMovieHolder;
import com.example.interviewpractice.weight.FatRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeMovieFragment extends BaseFragment  implements HotMovieView,PrevueView ,ComingView{

    private Context mContext;
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter hotMovieAdapter,comingMovieAdapter,prevueAdapter;
    private HotMoviePresenterImp hotMoviePresenterImp=new HotMoviePresenterImp(this,getContext());
    private PrevuePresenterImp prevuePresenterImp =new PrevuePresenterImp(this,getContext());
    private ComingPresenterImp comingPresenterImp=new ComingPresenterImp(this,getContext());
    private List<HotMovieBean> hotMovieBeans=new ArrayList<>();
    private List<PrevueBean> prevueBeans =new ArrayList<>();
    private List<ComingMovieBean> comingMovieBeans=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_movie, container, false);
        ButterKnife.bind(this, view);

        hotMoviePresenterImp.loadHotMovie();
        prevuePresenterImp.loadComingSuccess();
        comingPresenterImp.loadComingListMovie();

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
        hotMovieAdapter=new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<HotMovieBean>())
                .setLayout(R.layout.vlayout_forum_hot)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(HotMovieHolder.class)
                .setListener(new ItemListener<HotMovieBean>() {
                    @Override
                    public void onItemClick(View view, int position, HotMovieBean mData) {
                        Toast.makeText(MyApplication.getContext(), "88", Toast.LENGTH_SHORT).show();
                    }
                });
        prevueAdapter=new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<PrevueBean>())
                .setLayout(R.layout.vlayout_forum_comingmovie)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(PrevueHolder.class)
                .setListener(new ItemListener<PrevueBean>() {
                    @Override
                    public void onItemClick(View view, int position, PrevueBean mData) {
                        Toast.makeText(MyApplication.getContext(), "88", Toast.LENGTH_SHORT).show();
                    }
                });
        comingMovieAdapter=new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ComingMovieBean>())
                .setLayout(R.layout.vlayout_forum_cmcy)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ComingHolder.class)
                .setListener(new ItemListener<ComingMovieBean>() {
                    @Override
                    public void onItemClick(View view, int position, ComingMovieBean mData) {
                        Toast.makeText(MyApplication.getContext(), "889999", Toast.LENGTH_SHORT).show();
                    }
                });
        delegateAdapter.addAdapter(hotMovieAdapter);

        delegateAdapter.addAdapter(comingMovieAdapter);
        delegateAdapter.addAdapter(prevueAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }
    private LayoutHelper getGridLayoutHelper() {
        GridLayoutHelper gridHelper = new GridLayoutHelper(5);
        gridHelper.setMarginTop(20);
        gridHelper.setWeights(new float[]{20.0f, 20.0f, 20.0f, 20.0f, 20.0f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(5);
        //设置水平方向条目的间隔
        gridHelper.setHGap(5);
        gridHelper.setMarginLeft(15);
        gridHelper.setMarginBottom(15);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        return gridHelper;
    }
    private LayoutHelper getHaohuoHelper() {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        //是否自动扩展
        gridLayoutHelper.setAutoExpand(false);
        //自定义设置某些位置的Item的占格数
        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Log.e("position", position + "");
                if (position == 6) {
                    return 3;
                } else {
                    return 4;
                }
            }
        });
        gridLayoutHelper.setVGap(1);
        gridLayoutHelper.setHGap(1);
        return gridLayoutHelper;
    }

    @Override
    public void loadSuccess(HotMovieBean tData) {
        hotMovieBeans.add(tData);
        hotMovieAdapter.setData(hotMovieBeans);
        hotMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMovieSuccess(PrevueBean tData) {
        prevueBeans.add(tData);
        prevueAdapter.setData(prevueBeans);
        prevueAdapter.notifyDataSetChanged();

    }

    @Override
    public void loadComingMovie(ComingMovieBean tData) {
        comingMovieBeans.add(tData);
        comingMovieAdapter.setData(comingMovieBeans);
        comingMovieAdapter.notifyDataSetChanged();
    }
}
