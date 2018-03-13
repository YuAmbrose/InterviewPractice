package com.example.interviewpractice.ui.fragment.childFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.example.interviewpractice.ui.activity.EDetailActivity;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.rxbus.MessageEvent;
import com.example.interviewpractice.utils.rxbus.RxBus;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;

import static com.example.interviewpractice.MyApplication.getContext;

@SuppressLint("ValidFragment")
public class CagAllFragment extends BaseFragment implements RankListView,RecyclerArrayAdapter.OnLoadMoreListener{

    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private String cos;
    private static final String TAG = "CagAllFragment";
    private List<RankListBean.ItemListBean> itemListBeans;
    private HomeRecyclervAdapter homeRecyclervAdapter;
    private  int start=1;
    private  int num=10;
    private Handler handler = new Handler();
    @SuppressLint("ValidFragment")
    public CagAllFragment(String id) {
        super();
        cos=id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cag_all, container, false);
        ButterKnife.bind(this, view);
        rankListPresenterImp.loadCagAll( cos, 0, num);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter=new HomeRecyclervAdapter(getContext());
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
    public void onDestroyView() {
        super.onDestroyView();

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
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rankListPresenterImp.loadCagAll(cos,num*start,num);
                start++;
            }
        },100);
    }

}
