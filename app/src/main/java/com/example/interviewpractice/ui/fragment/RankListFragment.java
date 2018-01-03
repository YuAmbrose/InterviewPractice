package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListAdapter;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.mvp.presenter.BannerPresenterImp;
import com.example.interviewpractice.mvp.view.BannerView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RankListFragment extends BaseFragment implements BannerView {

    @BindView(R.id.recycle)
    EasyRecyclerView rankListRecyclerview;
    private static final String TAG = "RankListFragment";
    private static String[] path = {"weekly", "monthly", "historical"};
    private String part;
    public static final String PATH = "args_page";
    private RankListAdapter rankListAdapter;
    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());
    private List<BannerBean.ItemListBean> listBeans;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    public static RankListFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putString(PATH, path[position]);
        RankListFragment fragment = new RankListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        part = getArguments().getString(PATH);
        rankListAdapter = new RankListAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank_list, container, false);
        ButterKnife.bind(this, view);
        bannerPresenterImp.loadRanklist(part,0,10);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rankListRecyclerview.setLayoutManager(staggeredGridLayoutManager);
        rankListRecyclerview.setAdapter(rankListAdapter);
        return view;
    }

    @Override
    public void loadDataSuccess(BannerBean tData) {
        Log.e(TAG, "打印出" );
        listBeans = tData.getItemList();
        rankListAdapter.addAll(listBeans);
        rankListAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadDataError(Throwable throwable) {

    }


}
