package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.HomeRecyclerViewHolder;
import com.example.interviewpractice.adapter.viewholder.SearchViewHolder;
import com.example.interviewpractice.enity.RankListBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/5/1.
 */

public class SearchAdapter  extends RecyclerArrayAdapter<RankListBean.ItemListBean> {
public SearchAdapter(Context context) {
        super(context);
        }

@Override
public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchViewHolder(parent);
        }
        }
