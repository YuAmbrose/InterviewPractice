package com.example.interviewpractice.ui.fragment.childFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.interviewpractice.MainActivity;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.CagViewAdapter;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.example.interviewpractice.ui.activity.CategoryActivity;
import com.example.interviewpractice.ui.activity.EDetailActivity;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.rxbus.MessageEvent;
import com.example.interviewpractice.utils.rxbus.RxBus;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;


@SuppressLint("ValidFragment")
public class CagPopularFragment extends BaseFragment implements RankListView,RecyclerArrayAdapter.OnLoadMoreListener{
    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());

    private static final String TAG = "CagPopularFragment";
    private List<RankListBean.ItemListBean> itemListBeans;
    private CagViewAdapter homeRecyclervAdapter;
    private String cos;
    private  int start=1;
    private  int num=10;
    private Handler handler = new Handler();
    @SuppressLint("ValidFragment")
    public CagPopularFragment(String id) {
        super();
        cos=id;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cag_detail, container, false);
        ButterKnife.bind(this, view);
        rankListPresenterImp.loadPopular("mostPopular", cos, 0, num);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter = new CagViewAdapter(getContext());
        easyrecycler.setAdapter(homeRecyclervAdapter);
        homeRecyclervAdapter.setMore(R.layout.load_more_layout,this);
        homeRecyclervAdapter.setNoMore(R.layout.no_more_layout);
        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id=homeRecyclervAdapter.getItem(position).getData().getId();
                Intent selectIntent=new Intent(MyApplication.getContext(), EDetailActivity.class);
                selectIntent.putExtra("id",String.valueOf(id));
                startActivity(selectIntent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
            }
        });
            return view;
    }
            @Override
            public void rankSuccess(RankListBean rData) {

                itemListBeans = rData.getItemList();
                homeRecyclervAdapter.addAll(itemListBeans);
            }

            @Override
            public void selectSuccess(RankListBean sData) {

            }

            @Override
            public void onDestroy() {
                super.onDestroy();

            }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rankListPresenterImp.loadPopular("mostPopular",cos , num*start, num);
                start++;
            }
        },100);
    }
}

