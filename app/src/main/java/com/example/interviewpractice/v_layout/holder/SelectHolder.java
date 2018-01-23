package com.example.interviewpractice.v_layout.holder;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;

import static com.example.interviewpractice.MyApplication.getContext;

/**
 * Created by Administrator on 2018/1/15.
 */

public class SelectHolder extends VlayoutBaseHolder<RankListBean>{
    private List<RankListBean.ItemListBean> itemListBeans;
    private HomeRecyclervAdapter homeRecyclervAdapter;

    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private static final String TAG = "SelectHolder";
    public SelectHolder(View itemView) {
        super(itemView);
    }
    @Override
    public void setData(int ps, RankListBean rData) {
        super.setData(ps, rData);
        Log.e(TAG, "循环————"+rData.getItemList().size() );
//        easyrecycler.addItemDecoration(new SpaceDecoration((int)RecyclerviewUtil.convertDpToPixel(8,MyApplication.getContext())));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter=new HomeRecyclervAdapter(getContext());
        easyrecycler.setAdapter(homeRecyclervAdapter);
        itemListBeans = rData.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);
        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }



}
