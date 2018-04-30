package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.StartAdapter;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpFragment;
import com.example.interviewpractice.mvp.EyDetail.LayzMvpFragment;
import com.example.interviewpractice.mvp.forum.PostPresenter;
import com.example.interviewpractice.mvp.forum.PostView;
import com.example.interviewpractice.mvp.start.BmobPresenter;
import com.example.interviewpractice.mvp.start.BmobView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.listener.FindListener;
import cn.jzvd.JZVideoPlayerStandard;

public class StartBmobFragment extends LayzMvpFragment<BmobView, BmobPresenter> implements BmobView,SwipeRefreshLayout.OnRefreshListener  {


    @BindView(R.id.startrecyclerview)
    EasyRecyclerView startrecyclerview;
    private StartAdapter startAdapter;
    private List<RecomendarMovie> recomendarMovies=new ArrayList<>();
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private android.os.Handler handler = new android.os.Handler();
    private static final int STATE_REFRESH = 0;
    private static final int STATE_MORE = 1;
    private int limit = 10;
    private int curPage = 0;
    String lastTime = null;
    private QMUITipDialog tipDialog;
    private static final String TAG = "StartBmobFragment";
    @Override
    public void loadDataStart() {

        getPresenter().clickPost(0, STATE_REFRESH);
        startAdapter.setMore(R.layout.load_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                getPresenter().clickPost(curPage, STATE_MORE);
            }
        });
    }
    @Override
    protected void findViewById(View view) {
        ButterKnife.bind(this, view);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        startAdapter = new StartAdapter(MyApplication.getContext());
        startrecyclerview.setLayoutManager(staggeredGridLayoutManager);
        startrecyclerview.setAdapter(startAdapter);
        startrecyclerview.setRefreshListener(this);
    }

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        return view;
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            public void run() {
                startAdapter.clear();
                getPresenter().clickPost(0, STATE_REFRESH);
            }
        },100);
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(List<RecomendarMovie> result) {
            startAdapter.addAll(result);
    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public BmobPresenter createPresenter() {
        return new BmobPresenter();
    }
}



