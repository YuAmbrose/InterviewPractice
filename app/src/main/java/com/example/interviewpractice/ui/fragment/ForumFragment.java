package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.CategoryAdapter;
import com.example.interviewpractice.adapter.adapter.PostAdapter;
import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpFragment;
import com.example.interviewpractice.mvp.article.ArticlePresenter;
import com.example.interviewpractice.mvp.article.ArticleView;
import com.example.interviewpractice.mvp.forum.PostPresenter;
import com.example.interviewpractice.mvp.forum.PostView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ForumFragment extends AbstractMvpFragment<PostView, PostPresenter> implements PostView{
    private static final String TAG = "ForumFragment";
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.statebar)
    View statebarHeight;
    @BindView(R.id.recycleview)
    EasyRecyclerView recycleview;
    private List<Post> itemListBeans;
    private PostAdapter postAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum, container, false);
        ButterKnife.bind(this, view);
        initTopBar();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(staggeredGridLayoutManager);
        postAdapter = new PostAdapter(MyApplication.getContext());
        recycleview.setAdapter(postAdapter);
//        text.setText(TimeUtils.format("2018-03-23 19:21:43"));
//        String   model= android.os.Build.MODEL;   //手机信号
//        String carrier= android.os.Build.MANUFACTURER;   //手机牌子
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
//        MyUser user = BmobUser.getCurrentUser(MyApplication.getContext(),MyUser.class);
//        Post post = new Post();
//        post.setContent(editContent.getText().toString());
//        post.setAuthor(user);
//        post.save(MyApplication.getContext(),new SaveListener() {
//
//            @Override
//            public void onSuccess() {
//                Toast.makeText(MyApplication.getContext(), "成功了", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Toast.makeText(MyApplication.getContext(), "失败了", Toast.LENGTH_SHORT).show();
//            }
//
//        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
