package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.PgcMoreAdapter;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.mvp.homepage.presenter.PgcPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.PgcView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.swipe.SwipeRefreshLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreAuthorActivity extends AppCompatActivity implements PgcView,RecyclerArrayAdapter.OnLoadMoreListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recycleview)
    EasyRecyclerView recycleview;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    private int num=10;
    private int start=1;
    private Handler handler = new Handler();
    private PgcMoreAdapter pgcMoreAdapter;
    private List<PgcBean.ItemListBean> itemListBeans;
    private PgcPresenterImp pgcPresenterImp = new PgcPresenterImp(this, this);
    private static final String TAG = "MoreAuthorActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_author);
        ButterKnife.bind(this);
        pgcPresenterImp.loadPgc(20, 10);
        mTopBar.setTitle("全部作者");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(staggeredGridLayoutManager);
        pgcMoreAdapter = new PgcMoreAdapter(this);
        recycleview.setAdapter(pgcMoreAdapter);
        pgcMoreAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent anthorIntent=new Intent(MyApplication.getContext(), AuthorDetailActivity.class);
                int id=pgcMoreAdapter.getItem(position).getData().getId();
                anthorIntent.putExtra("id",String.valueOf(id));
                startActivity(anthorIntent);
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
            }
        });
        pgcMoreAdapter.setMore(R.layout.load_more_layout,this);
        pgcMoreAdapter.setNoMore(R.layout.no_more_layout);
        recycleview.setRefreshListener(this);
    }
    @Override
    public void loadPgc(PgcBean pData) {
        itemListBeans = pData.getItemList();
        pgcMoreAdapter.addAll(itemListBeans);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pgcPresenterImp.loadPgc(20+num*start, num);
                start++;
            }
        },100);
    }


    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pgcPresenterImp.loadPgc(20, 10);
            }
        },100);
    }
}
