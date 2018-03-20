package com.example.interviewpractice.v_layout.holder.EyDetail;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.ErecyclerAdapter;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;

import static com.example.interviewpractice.MyApplication.getContext;

/**
 * Created by 鱼握拳 on 2018/3/18.
 */

public class RecomdHolder extends VlayoutBaseHolder<RankListBean> {
    private List<RankListBean.ItemListBean> itemListBeans;
    private ErecyclerAdapter homeRecyclervAdapter;

    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private static final String TAG = "SelectHolder";
    public RecomdHolder(View itemView) {
        super(itemView);
    }
    @Override
    public void setData(int ps, RankListBean rData) {
        super.setData(ps, rData);
        Log.e(TAG, "循环————"+rData.getItemList().size() );
//        easyrecycler.addItemDecoration(new SpaceDecoration((int)RecyclerviewUtil.convertDpToPixel(8,MyApplication.getContext())));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter=new ErecyclerAdapter(getContext());
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

