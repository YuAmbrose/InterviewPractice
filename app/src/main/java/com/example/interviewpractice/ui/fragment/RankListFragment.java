package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListAdapter;
import com.example.interviewpractice.enity.BannerBean;
import com.example.interviewpractice.mvp.presenter.BannerPresenterImp;
import com.example.interviewpractice.mvp.view.BannerView;
import com.example.interviewpractice.ui.baseView.BaseFragment;

import java.util.List;


public class RankListFragment extends BaseFragment implements BannerView {
    private static String[] path={"weekly","monthly","historical"};
    private String part;
    public static final String PATH = "args_page";
    private RankListAdapter rankListAdapter;
    private BannerPresenterImp bannerPresenterImp = new BannerPresenterImp(this, getContext());
    private List<BannerBean.ItemListBean> listBeans;
    public static HomePageFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putString(PATH, path[position]);
        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        part = getArguments().getString(PATH);
        rankListAdapter=new RankListAdapter(getActivity());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_rank_list, container, false);
        bannerPresenterImp.loadRanklist(part);
        return view;
    }

    @Override
    public void loadDataSuccess(BannerBean tData) {
            listBeans=tData.getItemList();
            rankListAdapter.addAll(listBeans);
    }

    @Override
    public void loadDataError(Throwable throwable) {

    }
}
