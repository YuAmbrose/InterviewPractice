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
    private List<CategoryTab> homeEntrances=new ArrayList<>();
    private CategoryTab categoryTab;

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
        BmobQuery<CategoryTab> query = new BmobQuery<>();
        query.order("-createdAt");
        query.findObjects(MyApplication.getContext(), new FindListener<CategoryTab>() {
            @Override
            public void onSuccess(List<CategoryTab> list) {
                Log.e("分类栏", String.valueOf(list.size()));
                for (int i = 0; i <list.size(); i++) {
                  categoryTab=new CategoryTab(list.get(i).getType(),list.get(i).getTypeIcon());
                    iBaseRequestCallBack.requestSuccess(categoryTab);
                }

//                  iBaseRequestCallBack.listSuccess((List) categoryTab);
            }
            @Override
            public void onError(int i, String s) {

            }
        });
    }
}
