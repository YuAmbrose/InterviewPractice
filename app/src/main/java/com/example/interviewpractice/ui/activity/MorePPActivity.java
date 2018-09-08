package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.MoreAdapter;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.mvp.homepage.presenter.PgcPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.PgcView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

public class MorePPActivity extends AppCompatActivity implements PgcView {

    @BindView(R.id.topbar) QMUITopBar mTopBar;
    @BindView(R.id.recycleview) RecyclerView recyclerView;
    private List<PgcBean.ItemListBean>  dataBeans;
    private MoreAdapter moreAdapter;
    private PgcPresenterImp pgcPresenterImp = new PgcPresenterImp(this, this);
    private static final String TAG = "MorePPActivity";
    private Boolean isErr=false;
    private int  mNextRequestPage =0;
    private  int mCurrentCounter,TOTAL_COUNTER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_pp);
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
        moreAdapter = new MoreAdapter(dataBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        recyclerView.setAdapter(moreAdapter);

        moreAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        moreAdapter.setLoadMoreView(new CustomLoadMoreView());
//        moreAdapter.setLoadMoreView();
        moreAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                pgcPresenterImp.loadPgc(20+10*mNextRequestPage, 10);
                moreAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
            }
        }, recyclerView);

//        moreAdapter.setEnableLoadMore(false);
//        moreAdapter.disableLoadMoreIfNotFullPage();
    }

    @Override
    public void loadPgc(final PgcBean pData) {
        dataBeans=pData.getItemList();
//        dataBeans.add(pData.getItemList());
//        moreAdapter.setNewData(dataBeans);
        moreAdapter.addData(dataBeans);
        moreAdapter.loadMoreComplete();
        mNextRequestPage++;
//        Log.e(TAG, "loadPgc: "+dataBeans.size() );
//        moreAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override public void onLoadMoreRequested() {
//                pgcPresenterImp.loadPgc(20+10*mNextRequestPage, 10);
//                mNextRequestPage++;
//                        if (mCurrentCounter >= TOTAL_COUNTER) {
//                            //数据全部加载完毕
//                            moreAdapter.loadMoreEnd();
//                        } else {
//                            if (isErr) {
//                                //成功获取更多数据
////                                moreAdapter.addData(pData.getItemList());
//                                moreAdapter.setNewData(pData.getItemList());
//                                mCurrentCounter = moreAdapter.getData().size();
//                                moreAdapter.loadMoreComplete();
//                            } else {
//                                //获取更多数据失败
//                                isErr = true;
//                                moreAdapter.loadMoreFail();
//                            }
//                        }
//            }
//        }, recyclerView);
//        moreAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//
//                setData(false,dataBeans);
//            }
//        });
    }


//    @Override
//    public void onLoadMoreRequested() {
//
//        moreAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                pgcPresenterImp.loadPgc(20+10*mNextRequestPage, 10);
//                mNextRequestPage++;
//            }
//        });
//    }
}
