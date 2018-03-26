package com.example.interviewpractice.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.PostAdapter;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpFragment;
import com.example.interviewpractice.mvp.forum.PostPresenter;
import com.example.interviewpractice.mvp.forum.PostView;
import com.example.interviewpractice.ui.activity.PostActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ForumFragment extends AbstractMvpFragment<PostView, PostPresenter> implements PostView,SwipeRefreshLayout.OnRefreshListener  {
    private static final String TAG = "ForumFragment";
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.statebar)
    View statebarHeight;
    @BindView(R.id.recycleview)
    EasyRecyclerView recycleview;
    @BindView(R.id.btn)
    FloatingActionButton btn;
    private android.os.Handler handler = new android.os.Handler();
    private List<Post> itemListBeans;
    private PostAdapter postAdapter;
    private static final int STATE_REFRESH = 0;
    private static final int STATE_MORE = 1;
    private int limit = 10;
    private int curPage = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum, container, false);
        ButterKnife.bind(this, view);
        initTopBar();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(staggeredGridLayoutManager);
        postAdapter = new PostAdapter(MyApplication.getContext());
        recycleview.setAdapter(postAdapter);
//        onRefresh();
        getPresenter().clickPost(0,STATE_REFRESH);
        postAdapter.setNoMore(R.layout.vlayout_home_end);
        recycleview.setRefreshListener(this);
        recycleview.setRefreshing(true);
        postAdapter.setMore(R.layout.load_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                getPresenter().clickPost(curPage,STATE_MORE);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyApplication.getContext(), PostActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        return view;
    }

    private void initTopBar() {
        mTopBar.setTitle("社区");
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) statebarHeight.getLayoutParams();
        params.height = getStatusBarHeight(this);
        statebarHeight.setLayoutParams(params);
    }


    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(List<Post> list) {
        postAdapter.addAll(list);
    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public PostPresenter createPresenter() {
        return new PostPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            public void run() {
                postAdapter.clear();
                getPresenter().clickPost(0, STATE_REFRESH);
            }
        },100);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(getActivity());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CART_BROADCAST");
        BroadcastReceiver mItemViewListClickReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent){
                String msg = intent.getStringExtra("data");
                if("refresh".equals(msg)){
                    onRefresh();
                }
            }
        };
        broadcastManager.registerReceiver(mItemViewListClickReceiver, intentFilter);
    }
}
