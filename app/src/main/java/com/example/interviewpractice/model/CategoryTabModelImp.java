package com.example.interviewpractice.model;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.base.IBaseRequestCallBack;
import com.example.interviewpractice.enity.CategoryTab;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/12/27.
 */

public class CategoryTabModelImp implements CategoryTabModel<CategoryTab> {
    private List<CategoryTab> homeEntrances;
    private String types;
    private BmobFile icons;
    @Override
    public void loadCategoryTab(final IBaseRequestCallBack iBaseRequestCallBack) {
        homeEntrances = new ArrayList<>();
        BmobQuery<CategoryTab> query = new BmobQuery<>();
        query.order("-createdAt");
        query.findObjects(MyApplication.getContext(), new FindListener<CategoryTab>() {
            @Override
            public void onSuccess(List<CategoryTab> list) {
              iBaseRequestCallBack.requestSuccess(list);
            }
            @Override
            public void onError(int i, String s) {

            }
        });
    }
}
