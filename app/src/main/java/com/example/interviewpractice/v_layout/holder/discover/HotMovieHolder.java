package com.example.interviewpractice.v_layout.holder.discover;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.adapter.adapter.HotMovieAdapter;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;

import static com.example.interviewpractice.MyApplication.getContext;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMovieHolder extends VlayoutBaseHolder<HotMovieBean> {
    private List<HotMovieBean.DataBean.MoviesBean> moviesBeans;
    private HotMovieAdapter hotMovieAdapter;
    @BindView(R.id.recycleview)
    EasyRecyclerView easyrecycler;
    public HotMovieHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, HotMovieBean rData) {
        super.setData(ps, mData);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        hotMovieAdapter=new HotMovieAdapter(getContext());
        easyrecycler.setAdapter(hotMovieAdapter);
       moviesBeans = rData.getData().getMovies();
        hotMovieAdapter.addAll(moviesBeans);
        hotMovieAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }

}
