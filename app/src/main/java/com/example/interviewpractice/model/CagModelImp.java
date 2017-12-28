package com.example.interviewpractice.model;

import android.content.Context;
import android.util.Log;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.base.BaseModel;
import com.example.interviewpractice.base.IBaseRequestCallBack;
import com.example.interviewpractice.enity.CategoryTab;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/12/28.
 */

public class CagModelImp extends BaseModel implements BannerModel<CategoryTab> {
    private List<CategoryTab> homeEntrances;

    public CagModelImp(Context context) {
    }

    @Override
    public void loadBanner(IBaseRequestCallBack<CategoryTab> iBaseRequestCallBack) {

    }

    @Override
    public void onUnsubscribe() {

    }

    @Override
    public void loadCategoryTab(final IBaseRequestCallBack iBaseRequestCallBack) {
        homeEntrances = new ArrayList<>();
        BmobQuery<CategoryTab> query = new BmobQuery<>();
        query.order("-createdAt");
        query.findObjects(MyApplication.getContext(), new FindListener<CategoryTab>() {
            @Override
            public void onSuccess(List<CategoryTab> list) {
                Log.e("分类栏", String.valueOf(list.size()));
                iBaseRequestCallBack.listSuccess(list);
//               iBaseRequestCallBack.requestSuccess(list);
            }
            @Override
            public void onError(int i, String s) {

            }
        });
    }
}
