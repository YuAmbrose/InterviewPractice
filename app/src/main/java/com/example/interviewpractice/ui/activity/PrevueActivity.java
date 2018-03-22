package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.PrevueMovieAdapter;
import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.mvp.discover.presenter.PrevuePresenterImp;
import com.example.interviewpractice.mvp.discover.view.PrevueView;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.interviewpractice.MyApplication.getContext;

public class PrevueActivity extends AppCompatActivity implements PrevueView {
    @BindView(R.id.recycleview)
    EasyRecyclerView easyrecycler;
    private List<PrevueBean.DataBean> comingBeans;
    private PrevueMovieAdapter prevueMovieAdapter;
    private PrevuePresenterImp prevuePresenterImp = new PrevuePresenterImp(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevue);
        ButterKnife.bind(this);
        prevuePresenterImp.loadComingSuccess();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        prevueMovieAdapter =new PrevueMovieAdapter(getContext());
        easyrecycler.setAdapter(prevueMovieAdapter);

    }

    @Override
    public void loadMovieSuccess(PrevueBean tData) {
        comingBeans=tData.getData();
        prevueMovieAdapter.addAll(comingBeans);
    }
}
