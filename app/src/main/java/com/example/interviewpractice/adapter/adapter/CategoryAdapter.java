package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.CategoryViewHolder;
import com.example.interviewpractice.enity.Cag;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class CategoryAdapter extends RecyclerArrayAdapter<Cag> {
public CategoryAdapter(Context context) {
        super(context);
        }

@Override
public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder(parent);
        }
        }
