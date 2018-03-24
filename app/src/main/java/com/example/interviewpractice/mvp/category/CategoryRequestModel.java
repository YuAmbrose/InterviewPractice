package com.example.interviewpractice.mvp.category;

import android.content.Context;
import android.util.Log;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.CategoryTab;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseListCallBack;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class CategoryRequestModel {
        private Call<Cag> categoryBeanCall;
        private Context context;
    public CategoryRequestModel(Context mContext){
        super();
        context=mContext;
}
    public void  RequestCategory(final IBaseListCallBack<Cag> iBaseRequestCallBack){
        BmobQuery<Cag> query = new BmobQuery<>();
        query.order("-createdAt");
        query.setCachePolicy(BmobQuery.CachePolicy.CACHE_ELSE_NETWORK);
        query.setLimit(20);
        query.findObjects(MyApplication.getContext(), new FindListener<Cag>() {
            @Override
            public void onSuccess(List<Cag> list) {
                iBaseRequestCallBack.requestSuccess(list);
            }
            @Override
            public void onError(int i, String s) {

            }
        });
    }

    public void interruptHttp(){
        if(categoryBeanCall!= null && !categoryBeanCall.isCanceled()){
            categoryBeanCall.cancel();
        }
    }
}
