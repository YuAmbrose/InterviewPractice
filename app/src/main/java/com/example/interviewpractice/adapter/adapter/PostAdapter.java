package com.example.interviewpractice.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.interviewpractice.adapter.viewholder.PostViewHolder;
import com.example.interviewpractice.enity.Post;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/3/23.
 */

public class PostAdapter extends RecyclerArrayAdapter<Post> {
    public PostAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(parent);
    }
}
