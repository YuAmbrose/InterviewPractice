package com.example.interviewpractice.v_layout.holder.home;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.ZhiHuAdapter;
import com.example.interviewpractice.enity.ZhihuHotBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ZHotHolder  extends VlayoutBaseHolder<ZhihuHotBean> {
    private List<ZhihuHotBean.RecentBean> recentBeans;
    @BindView(R.id.easyrecycleview)
    EasyRecyclerView easyrecycler;
    private ZhiHuAdapter zhiHuAdapter;
    public ZHotHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ZhihuHotBean mData) {
        super.setData(ps, mData);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        zhiHuAdapter= new ZhiHuAdapter(MyApplication.getContext());
        easyrecycler.setAdapter(zhiHuAdapter);
        recentBeans=mData.getRecent();
        zhiHuAdapter.addAll(recentBeans);
    }
}