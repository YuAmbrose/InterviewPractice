package com.example.interviewpractice.mvp.model;

import android.content.Context;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/12/28.
 */

public class CagModelImp implements CagModel<CategoryTab> {
    private List<CategoryTab> homeEntrances=new ArrayList<>();
    private CategoryTab categoryTab;
    private Context context = null;

    public CagModelImp(Context mcontext) {
        super();
        context = mcontext;
    }
    @Override
    public void loadCategoryTab(final IBaseRequestCallBack<CategoryTab> iBaseRequestCallBack) {
        BmobQuery<CategoryTab> query = new BmobQuery<>();
        query.order("-createdAt");
        query.findObjects(MyApplication.getContext(), new FindListener<CategoryTab>() {
            @Override
            public void onSuccess(List<CategoryTab> list) {
                for (int i = 0; i <list.size(); i++) {
                  categoryTab =new CategoryTab(list.get(i).getType(),list.get(i).getTypeIcon(),list.get(i).getId());
                    iBaseRequestCallBack.requestSuccess(categoryTab);
                }
            }
            @Override
            public void onError(int i, String s) {

            }
        });
    }
}
