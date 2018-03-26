package com.example.interviewpractice.mvp.forum;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;

import cn.bmob.v3.datatype.BmobDate;
import retrofit2.Call;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.http.IBaseListCallBack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private static final int STATE_REFRESH = 0;
    private static final int STATE_MORE = 1;
    private int limit = 10;
    private int curPage = 0;
    String lastTime = null;
    public PostModel(Context mcontext) {
        super();
        context = mcontext;
    }
    public void  RequestPost(int page,final int actionType,final IBaseListCallBack<Post> iBaseRequestCallBack){
        BmobQuery<Post> query = new BmobQuery<>();
        query.include("author");
        query.order("-createdAt");
        if (actionType == STATE_MORE) {
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = sdf.parse(lastTime);
                Log.i("0414", date.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            query.addWhereLessThanOrEqualTo("createdAt", new BmobDate(date));
            query.setSkip(limit*curPage-10);
        } else {
            page = 0;
            query.setSkip(page);
        }
        query.setLimit(limit);
        query.findObjects(MyApplication.getContext(), new FindListener<Post>() {
            @Override
            public void onSuccess(List<Post> list) {
                if (list.size()>0) {
                    if (actionType == STATE_REFRESH) {
                        curPage = 0;
                        posts.clear();
                        lastTime = list.get(list.size() - 1).getCreatedAt();
                    }
                    for (Post td : list) {
                        posts.add(td);
                    }
                    curPage++;
                } else if (actionType == STATE_MORE) {

                } else if (actionType == STATE_REFRESH) {

                }
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
