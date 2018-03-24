package com.example.interviewpractice.v_layout.holder.discover;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.ComingMovieAdapter;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;

import static com.example.interviewpractice.MyApplication.getContext;

/**
 * Created by 鱼握拳 on 2018/2/13.
 */

public class ComingHolder extends VlayoutBaseHolder<ComingMovieBean> {
    @BindView(R.id.recycler)
    EasyRecyclerView easyrecycler;
    private ComingMovieAdapter comingMovieAdapter;
    private List<ComingMovieBean.DataBean.ComingBean> comingBeans;
    private static final String TAG = "ComingHolder";
    public ComingHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ComingMovieBean cData) {
        super.setData(ps, cData);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        comingMovieAdapter =new ComingMovieAdapter(getContext());
        easyrecycler.setAdapter(comingMovieAdapter);
        comingBeans=cData.getData().getComing();
        comingMovieAdapter.addAll(comingBeans);
        comingMovieAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }

}
