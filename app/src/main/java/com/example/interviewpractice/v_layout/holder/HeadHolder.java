package com.example.interviewpractice.v_layout.holder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/15.
 */

public class HeadHolder extends VlayoutBaseHolder<RankListBean> {
    private static final String TAG = "HeadHolder";
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.statebar)
    View statebarHeight;
    public HeadHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RankListBean mData) {
        super.setData(ps, mData);
        mTopBar.setTitle("主页");
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) statebarHeight.getLayoutParams();//获取当前控件的布局对象
        params.height=getStatusBarHeight(MyApplication.getContext());//设置当前控件布局的高度
        statebarHeight.setLayoutParams(params);//将设置好的布局参数应用到控件中
    }
    public int getStatusBarHeight(Context fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }
}
