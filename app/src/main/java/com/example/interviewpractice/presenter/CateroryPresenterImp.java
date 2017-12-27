package com.example.interviewpractice.presenter;

import android.content.Context;

import com.example.interviewpractice.base.BasePresenterImp;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.model.CategoryTabModelImp;
import com.example.interviewpractice.view.CategorytabView;

/**
 * Created by Administrator on 2017/12/27.
 */

public class CateroryPresenterImp extends BasePresenterImp<CategorytabView,CategoryTab> implements CategoryPresenter{
    private Context context;
    private CategoryTabModelImp categoryTabModelImp;
    /**
     * @param view 具体业务的视图接口对象
     * @descriptoin 构造方法
     */
    public CateroryPresenterImp(CategorytabView view) {
        super(view);
        this.categoryTabModelImp=new CategoryTabModelImp();
    }


    @Override
    public void categoryTabPes() {
        categoryTabModelImp.loadCategoryTab(this);
    }
}
