package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.StartAdapter;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.example.interviewpractice.ui.baseView.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.jzvd.JZVideoPlayerStandard;

public class StartFragment extends BaseFragment {


    @BindView(R.id.startrecyclerview)
    RecyclerView startrecyclerview;
    private StartAdapter startAdapter;
    private List<RecomendarMovie> recomendarMovies;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        ButterKnife.bind(this, view);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        startAdapter=new StartAdapter(MyApplication.getContext());
        startrecyclerview.setLayoutManager(staggeredGridLayoutManager);
        startrecyclerview.setAdapter(startAdapter);
        getData(0,10);
        return view;
    }

    private void getData(int start, int num ) {

        BmobQuery<RecomendarMovie> query = new BmobQuery<>();
        query.order("-createdAt");
        query.findObjects(MyApplication.getContext(), new FindListener<RecomendarMovie>() {
            @Override
            public void onSuccess(List<RecomendarMovie> list) {
                    recomendarMovies=list;
                    startAdapter.addAll(recomendarMovies);
            }
            @Override
            public void onError(int i, String s) {

            }
        });
    }

    }



