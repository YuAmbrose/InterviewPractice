package com.example.interviewpractice.mvp.presenter;

import android.content.Context;

import com.example.interviewpractice.mvp.base.CagBasePresenterImp;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.mvp.model.CagModelImp;
import com.example.interviewpractice.mvp.view.CategorytabView;


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
