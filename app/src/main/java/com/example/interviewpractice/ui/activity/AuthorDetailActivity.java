package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.AuthorListFragmentAdapter;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.adapter.adapter.RankListFragmentAdapter;
import com.example.interviewpractice.enity.AuthorDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.authorDetail.AuthorRequestPresenter;
import com.example.interviewpractice.mvp.authorDetail.AuthorRequestView;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIAppBarLayout;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class AuthorDetailActivity extends AbstractMvpActivity<AuthorRequestView, AuthorRequestPresenter> implements AuthorRequestView,RankListView,RecyclerArrayAdapter.OnLoadMoreListener {
    @BindView(R.id.collapsing_topbar_layout) QMUICollapsingTopBarLayout mCollapsingTopBarLayout;
    @BindView(R.id.topbar) QMUITopBar mTopBar;
    @BindView(R.id.iv_cover_bg) ImageView ivCoverBg;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.tv_focus_num) TextView tvFocusNum;
    @BindView(R.id.tv_description) TextView tvDescription;
    @BindView(R.id.tv_video_num) TextView tvVideoNum;
    @BindView(R.id.tv_like_num) TextView tvLikeNum;
    @BindView(R.id.tv_share_num) TextView tvShareNum;
    @BindView(R.id.iv_head) CircleImageView ivHead;
    @BindView(R.id.appbar) QMUIAppBarLayout appBar;
    @BindView(R.id.select_recycler) EasyRecyclerView rankListRecyclerview;
    private int start=1;
    private Handler handler = new Handler();
    private static final String TAG = "AuthorDetailActivity";
    private AppBarState mState;
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, this);
    private HomeRecyclervAdapter homeRecyclervAdapter;
    private List<RankListBean.ItemListBean> itemListBeans;
    private String id;
    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rankListPresenterImp.loadListAuthor("date",id,start*10,10);
                start++;
            }
        },100);
    }

    private enum AppBarState {EXPANDED, COLLAPSED, MIDDLE}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        ButterKnife.bind(this);
        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        getPresenter().clickRequest(id);
        rankListPresenterImp.loadListAuthor("date",id,0,10);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        homeRecyclervAdapter=new HomeRecyclervAdapter(this);
        homeRecyclervAdapter.setMore(R.layout.load_more_layout,this);
        rankListRecyclerview.setLayoutManager(staggeredGridLayoutManager);
        rankListRecyclerview.setAdapter(homeRecyclervAdapter);

        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(MyApplication.getContext(),EDetailActivity.class);
                int id=homeRecyclervAdapter.getItem(position).getData().getId();
                intent.putExtra("id",String.valueOf(id));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
            }
        });

        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
    }
    @Override
    public void rankSuccess(RankListBean rData) {
        itemListBeans = rData.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);
    }

    @Override
    public void selectSuccess(RankListBean sData) {

    }
    @Override
    protected AuthorRequestPresenter createPresenter() {
        return new AuthorRequestPresenter();
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(AuthorDetailBean authorDetailBean) {
        tvName.setText(authorDetailBean.getPgcInfo().getName());
//        tvBoldTitle.setText(pgcInfoBean.getName());
        tvFocusNum.setText(String.valueOf(authorDetailBean.getPgcInfo().getFollowCount()) + "人关注");
        tvDescription.setText(authorDetailBean.getPgcInfo().getDescription());
        tvVideoNum.setText(String.valueOf(authorDetailBean.getPgcInfo().getVideoCount()));
        tvLikeNum.setText(String.valueOf(authorDetailBean.getPgcInfo().getCollectCount()));
        tvShareNum.setText(String.valueOf(authorDetailBean.getPgcInfo().getShareCount()));
        Glide.with(this).load(authorDetailBean.getPgcInfo().getIcon()).into(ivHead);
        Glide.with(this).load(authorDetailBean.getPgcInfo().getCover()).error(R.mipmap.cover_default).into(ivCoverBg);
//        mTopBar.setTitle(authorDetailBean.getPgcInfo().getName());
        String name=authorDetailBean.getPgcInfo().getName();
        initAppBar(name);
    }

    private void initAppBar(final String name) {
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (mState != AppBarState.EXPANDED) {
                        mState = AppBarState.EXPANDED;//修改状态标记为展开
                        mCollapsingTopBarLayout.setTitle("");

                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (mState != AppBarState.COLLAPSED) {
                        mState = AppBarState.COLLAPSED;//修改状态标记为折叠
                        mCollapsingTopBarLayout.setTitle(name);
                    }
                } else {
                    if (mState != AppBarState.MIDDLE) {
                        if (mState == AppBarState.COLLAPSED) {
                            mCollapsingTopBarLayout.setTitle("");
                        }
                        mState = AppBarState.MIDDLE;//修改状态标记为中间

                    }
                }
            }
        });
    }

    @Override
    public void resultFailure(String result) {

    }
}
