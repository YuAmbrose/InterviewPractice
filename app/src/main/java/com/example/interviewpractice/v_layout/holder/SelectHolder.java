package com.example.interviewpractice.v_layout.holder;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/15.
 */

public class SelectHolder extends VBaseHolder<RankListBean>{
    private List<RankListBean.ItemListBean> itemListBeans=new ArrayList<>();
    private HomeRecyclervAdapter homeRecyclervAdapter=new HomeRecyclervAdapter(MyApplication.getContext());
    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private static final String TAG = "SelectHolder";
    public SelectHolder(View itemView) {
        super(itemView);
    }
    @Override
    public void setData(int ps, RankListBean rData) {
        Log.e(TAG, "循环————"+rData.getItemList().size() );
        super.setData(ps, rData);




//        easyrecycler.addItemDecoration(new SpaceDecoration((int)RecyclerviewUtil.convertDpToPixel(8,MyApplication.getContext())));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        homeRecyclervAdapter = new HomeRecyclervAdapter(MyApplication.getContext());
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        easyrecycler.setAdapter(homeRecyclervAdapter);
        itemListBeans = rData.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);
    }
}
