package com.example.interviewpractice.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.mvp.discover.presenter.HotMoviePresenterImp;
import com.example.interviewpractice.mvp.discover.view.HotMovieView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.v_layout.ItemListener;
import com.example.interviewpractice.v_layout.VlayoutBaseAdapter;
import com.example.interviewpractice.v_layout.holder.discover.HotMovieHolder;
import com.example.interviewpractice.v_layout.holder.home.PgcHeadHolder;
import com.example.interviewpractice.weight.FatRecyclerview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeMovieFragment extends BaseFragment  implements HotMovieView{

    private Context mContext;
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter hotMovieAdapter;
    private HotMoviePresenterImp hotMoviePresenterImp=new HotMoviePresenterImp(this,getContext());
    private List<HotMovieBean> hotMovieBeans=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_movie, container, false);
        ButterKnife.bind(this, view);
        hotMoviePresenterImp.loadHotMovie();
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
        delegateAdapter.addAdapter(hotMovieAdapter);
        mRecycler.setAdapter(delegateAdapter);

    }

    @Override
    public void loadSuccess(HotMovieBean tData) {
        hotMovieBeans.add(tData);
        hotMovieAdapter.setData(hotMovieBeans);
        hotMovieAdapter.notifyDataSetChanged();
    }
}
