package com.example.interviewpractice.mvp.forum;

import android.content.Context;
import retrofit2.Call;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.http.IBaseListCallBack;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by 鱼握拳 on 2018/3/24.
 */

public class PostModel  {
    private Call<Post> postCall;
    private List<Post> posts =new ArrayList<>();
    private Post post;
    private Context context = null;
    public PostModel(Context mcontext) {
        super();
        context = mcontext;
    }
    public void  RequestPost(final IBaseListCallBack<Post> iBaseRequestCallBack){
        BmobQuery<Post> query = new BmobQuery<>();
        query.order("-createdAt");
        query.setLimit(20);
        query.findObjects(MyApplication.getContext(), new FindListener<Post>() {
            @Override
            public void onSuccess(List<Post> list) {
                iBaseRequestCallBack.requestSuccess(list);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }
    public void interruptHttp(){
        if(postCall!= null && !postCall.isCanceled()){
            postCall.cancel();
        }
    }
}
