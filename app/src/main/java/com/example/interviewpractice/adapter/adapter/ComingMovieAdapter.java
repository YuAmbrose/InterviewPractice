package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.ComingMovieViewHolder;
import com.example.interviewpractice.adapter.viewholder.PrevueMovieViewHolder;
import com.example.interviewpractice.enity.ComingMovieBean;
import com.example.interviewpractice.enity.PrevueBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/2/13.
 */

public class ComingMovieAdapter extends RecyclerArrayAdapter<ComingMovieBean.DataBean.ComingBean> {
public ComingMovieAdapter(Context context) {
        super(context);
        }

@Override
public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ComingMovieViewHolder(parent);
        }
        }