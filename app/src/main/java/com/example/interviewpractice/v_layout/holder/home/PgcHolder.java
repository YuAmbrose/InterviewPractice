package com.example.interviewpractice.v_layout.holder.home;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.PgcAdapter;
import com.example.interviewpractice.enity.PgcBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/11.
 */

public class PgcHolder extends VlayoutBaseHolder<PgcBean> {
        @BindView(R.id.pgc_recyclerview)
        EasyRecyclerView pgcRecyclerview;
        private PgcAdapter pgcAdapter;
        private List<PgcBean.ItemListBean> pgcBeans;
        private static final String TAG = "PgcHolder";
        public PgcHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, PgcBean tData) {
        super.setData(ps, tData);
        pgcAdapter=new PgcAdapter(MyApplication.getContext());
        LinearLayoutManager layoutManager=new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        pgcRecyclerview.setLayoutManager(layoutManager);
        pgcBeans = tData.getItemList();
        pgcAdapter.addAll(pgcBeans);
        pgcRecyclerview.setAdapter(pgcAdapter);
        pgcAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
    @Override
    public void init() {
        super.init();

    }
}
