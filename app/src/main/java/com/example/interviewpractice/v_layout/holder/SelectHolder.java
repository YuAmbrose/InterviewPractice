package com.example.interviewpractice.v_layout.holder;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.view.RankListView;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.interviewpractice.MyApplication.getContext;

/**
 * Created by Administrator on 2018/1/15.
 */

public class SelectHolder extends VlayoutBaseHolder<RankListBean> implements RankListView,RecyclerArrayAdapter.OnLoadMoreListener{
    private List<RankListBean.ItemListBean> itemListBeans=new ArrayList<>();
    private HomeRecyclervAdapter homeRecyclervAdapter=new HomeRecyclervAdapter(getContext());
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
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
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        easyrecycler.setAdapter(homeRecyclervAdapter);

        homeRecyclervAdapter.setMore(R.layout.load_more,this);
        itemListBeans = rData.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);
        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }

    @Override
    public void onLoadMore() {
            rankListPresenterImp.loadSelect(20,10);
    }

    @Override
    public void rankSuccess(RankListBean rData) {
//        List<RankListBean> rankListBeans=new ArrayList<>();
//        rankListBeans.add(rData);
//        homeRecyclervAdapter.clear();
        itemListBeans = rData.getItemList();
        itemListBeans.addAll(rData.getItemList());
        homeRecyclervAdapter.addAll(itemListBeans);
    }

    @Override
    public void selectSuccess(RankListBean sData) {

    }
}
