package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.PostAdapter;
import com.example.interviewpractice.enity.MyUser;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpFragment;
import com.example.interviewpractice.mvp.forum.PostPresenter;
import com.example.interviewpractice.mvp.forum.PostView;
import com.example.interviewpractice.utils.util.TimeUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;


public class ForumFragment extends AbstractMvpFragment<PostView, PostPresenter> implements PostView {
    private static final String TAG = "ForumFragment";
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.statebar)
    View statebarHeight;
    @BindView(R.id.recycleview)
    EasyRecyclerView recycleview;

    private List<Post> itemListBeans;
    private PostAdapter postAdapter;
    @BindView(R.id.edit_query)
    EditText editContent;
    @BindView(R.id.push)
    Button push;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum, container, false);
        ButterKnife.bind(this, view);
        initTopBar();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(staggeredGridLayoutManager);
        postAdapter = new PostAdapter(MyApplication.getContext());
        recycleview.setAdapter(postAdapter);
         push.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pushText();
        }
    });
        getPresenter().clickPost();
        return view;
    }

    private void initTopBar() {
        mTopBar.setTitle("社区");
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) statebarHeight.getLayoutParams();
        params.height = getStatusBarHeight(this);
        statebarHeight.setLayoutParams(params);
    }

    private void pushText() {
        MyUser user = BmobUser.getCurrentUser(MyApplication.getContext(),MyUser.class);
        Post post = new Post();
        String   model= android.os.Build.MODEL;   //手机信号
        String carrier= android.os.Build.MANUFACTURER;   //手机牌子
        post.setAuthor(user);
        post.setName((String) BmobUser.getObjectByKey(MyApplication.getContext(),"username"));
        post.setPhoneType(carrier+"-"+model);
        post.setContent(editContent.getText().toString());
        post.save(MyApplication.getContext(),new SaveListener() {

            @Override
            public void onSuccess() {
                Toast.makeText(MyApplication.getContext(), "成功了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(MyApplication.getContext(), "失败了", Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(List<Post> list) {
        postAdapter.addAll(list);
    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public PostPresenter createPresenter() {
        return new PostPresenter();
    }
}
