package com.example.interviewpractice.v_layout;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Moushao on 2017/8/23.
 */

public class VBaseHolder<T> extends RecyclerView.ViewHolder {
    public ItemListener mListener;
    private Activity mActivity;
    public Activity mC;
//    public Context mContext;
    public View mView;
    public T mData;
    public int position;

    public VBaseHolder(View itemView) {
        super(itemView);
        mView = itemView;
        ButterKnife.bind(this, itemView);
        init();
    }
    public void setActivity(Activity activity) {
            mActivity= activity;
            mC=activity;
    }
    public void init() {

    }
//    public void setContext(Context context) {
//        mContext = context;
//    }

    public void setListener(ItemListener listener) {
        mListener = listener;
    }

    public void setData(int ps, T mData) {
        this.mData = mData;
        position = ps;
    }

}
