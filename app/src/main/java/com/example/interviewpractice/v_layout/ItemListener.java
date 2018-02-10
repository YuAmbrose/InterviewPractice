package com.example.interviewpractice.v_layout;

import android.view.View;

/**
 * 功能描述: recyclerView万能适配器的点击事件
 */
public interface ItemListener<T> {
    void onItemClick(View view, int position, T mData);
}
