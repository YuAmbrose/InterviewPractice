package com.example.interviewpractice.mvp.homepage.presenter;

import android.content.Context;

import com.example.interviewpractice.mvp.homepage.base.CagBasePresenterImp;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.mvp.homepage.model.CagModelImp;
import com.example.interviewpractice.mvp.homepage.view.CategorytabView;


/**
 * Created by Administrator on 2017/12/28.
 */

public class CagPesenterImp extends CagBasePresenterImp<CategorytabView,CategoryTab> implements CagPesenter {
    private CagModelImp cagModelImp=null;
    private Context context=null;
    /**
     * @param view 具体业务的视图接口对象
     * @descriptoin 构造方法
     */
    public CagPesenterImp(CategorytabView view, Context context) {
        super(view);
        this.context=context;
        this.cagModelImp= new CagModelImp(context);
    }
    @Override
    public void categoryTabPes() {
        cagModelImp.loadCategoryTab(this);
    }
}
