package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.interviewpractice.MyApplication.getContext;

public class MoreEyActivity extends AppCompatActivity implements RankListView,RecyclerArrayAdapter.OnLoadMoreListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, this);
    private int num = 10;
    private List<RankListBean.ItemListBean> itemListBeans;
    private HomeRecyclervAdapter homeRecyclervAdapter;
    private int start=1;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_ey);
        ButterKnife.bind(this);
        mTopBar.setTitle("热门内容");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        rankListPresenterImp.loadSelect(30, num);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter=new HomeRecyclervAdapter(getContext());
        easyrecycler.setAdapter(homeRecyclervAdapter);
        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id=homeRecyclervAdapter.getItem(position).getData().getId();
                Intent selectIntent=new Intent(MyApplication.getContext(), EDetailActivity.class);
                selectIntent.putExtra("id",String.valueOf(id));
                startActivity(selectIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
            }
        });
        homeRecyclervAdapter.setMore(R.layout.load_more_layout,this);
        homeRecyclervAdapter.setNoMore(R.layout.no_more_layout);
        easyrecycler.setRefreshListener(this);
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

                rankListPresenterImp.loadSelect(30+num*start, num);
                start++;
            }
        },100);
    }


    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rankListPresenterImp.loadSelect(30, num);
            }
        },100);
    }
}
