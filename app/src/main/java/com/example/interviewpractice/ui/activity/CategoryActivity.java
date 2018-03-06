package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.CategoryAdapter;
import com.example.interviewpractice.adapter.adapter.PgcMoreAdapter;
import com.example.interviewpractice.enity.EyCategoryBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.category.CategoryRequestPresenter;
import com.example.interviewpractice.mvp.category.CategoryRequestView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AbstractMvpActivity<CategoryRequestView, CategoryRequestPresenter> implements CategoryRequestView {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recycleview)
    EasyRecyclerView recycleview;
    private List<EyCategoryBean> eyCategoryBeans;
    private CategoryAdapter categoryAdapter;
    private static final String TAG = "CategoryActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
//        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        ButterKnife.bind(this);
        getPresenter().clickRequest();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(staggeredGridLayoutManager);
        categoryAdapter = new CategoryAdapter(this);
        recycleview.setAdapter(categoryAdapter);
        Log.e(TAG, "onCreate: 66666666666666666666666666" );
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        mTopBar.setTitle("全部分类");
    }

    @Override
    protected CategoryRequestPresenter createPresenter() {
        return new CategoryRequestPresenter();
    }

    @Override
    public void requestLoading() {
        Log.e(TAG, "requestLoading: 8888888888888888888888888888" );
    }

    @Override
    public void resultSuccess(EyCategoryBean categoryBean) {
        Log.e(TAG, "*********************88888888888888888888888888888" );
        eyCategoryBeans=new ArrayList<>();
        eyCategoryBeans.add(categoryBean);
        categoryAdapter.addAll(eyCategoryBeans);
        categoryAdapter.notifyDataSetChanged();
    }




    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: 8889999999999999999999999999"+result);
    }
}
