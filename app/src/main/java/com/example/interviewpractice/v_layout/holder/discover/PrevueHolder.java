package com.example.interviewpractice.v_layout.holder.discover;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.PrevueMovieAdapter;
import com.example.interviewpractice.enity.PrevueBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;

import static com.example.interviewpractice.MyApplication.getContext;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public class PrevueHolder extends VlayoutBaseHolder<PrevueBean> {
    private List<PrevueBean.DataBean> comingBeans;
    private PrevueMovieAdapter prevueMovieAdapter;
    @BindView(R.id.recycleview)
    EasyRecyclerView easyrecycler;

    public PrevueHolder(View itemView) {
        super(itemView);
    }
    @Override
    public void setData(int ps,PrevueBean rData) {
        super.setData(ps, mData);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        prevueMovieAdapter =new PrevueMovieAdapter(getContext());
        easyrecycler.setAdapter(prevueMovieAdapter);
        comingBeans=rData.getData();
        prevueMovieAdapter.addAll(comingBeans);
        prevueMovieAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
