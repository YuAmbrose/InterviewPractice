package com.example.interviewpractice.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.FragmentViewPagerAdapter;
import com.example.interviewpractice.enity.CagAuthorBean;
import com.example.interviewpractice.enity.CategoryDetailInfo;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.CagDetail.CagDetailPresenter;
import com.example.interviewpractice.mvp.CagDetail.CagDetailView;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.ui.fragment.childFragment.CagAllFragment;
import com.example.interviewpractice.ui.fragment.childFragment.CagPopularFragment;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIAppBarLayout;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CagDetailActivity extends AbstractMvpActivity<CagDetailView, CagDetailPresenter> implements CagDetailView {
    private static final String TAG = "CagDetailActivity";
    @BindView(R.id.iv_cover_bg) ImageView ivCoverBg;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.tv_description) TextView tvDescription;
    @BindView(R.id.topbar) QMUITopBar mTopBar;
    @BindView(R.id.collapsing_topbar_layout) QMUICollapsingTopBarLayout mCollapsingTopBarLayout;
    @BindView(R.id.appbar) QMUIAppBarLayout appBar;
//    @BindView(R.id.pager) QMUIViewPager mViewPager;
//    @BindView(R.id.tabs) QMUITabSegment  mTabSegment;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private String id;
    private AppBarState mState;
    private List<String> titles;
    private List<Fragment> fragments;
    private QMUITipDialog tipDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cag_detail);
        ButterKnife.bind(this);
        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        //        initPagers();
        Intent intent=getIntent();
        id=intent.getStringExtra("id");

        String co="2";
        getPresenter().clickRequest(id);
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });

        fragments = new ArrayList<>();
        fragments.add(new CagPopularFragment(id));
        fragments.add(new CagAllFragment(id));
        titles = new ArrayList<>();
        titles.add("最受欢迎内容");
        titles.add("全部作品");
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
        viewPager.setCurrentItem(0);//直接设置0的话竟然不起作用,好吧.就这样迂回一下吧


    }

    @Override
    protected CagDetailPresenter createPresenter() {
        return new CagDetailPresenter();
    }

    @Override
    public void requestLoading() {
        tipDialog = new QMUITipDialog.Builder(this)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();
    }

    @Override
    public void resultSuccess(CategoryDetailInfo categoryDetailInfo) {
        Glide.with(this).load(categoryDetailInfo.getCategoryInfo().getHeaderImage()).into(ivCoverBg);
        tvName.setText(categoryDetailInfo.getCategoryInfo().getName());
        tvDescription.setText(categoryDetailInfo.getCategoryInfo().getDescription());
        initAppBar(categoryDetailInfo.getCategoryInfo().getName());
        tipDialog.dismiss();
    }

    @Override
    public void AuthorSuccess(CagAuthorBean authorBean) {

    }

    @Override
    public void AllSuccess(RankListBean rankListBean) {

    }

    @Override
    public void resultFailure(String result) {
        tipDialog.dismiss();
        Toast.makeText(MyApplication.getContext(), "出错了", Toast.LENGTH_SHORT).show();
    }
    private enum AppBarState {EXPANDED, COLLAPSED, MIDDLE}
    private void initAppBar(final String name) {

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (mState != CagDetailActivity.AppBarState.EXPANDED) {
                        mState = CagDetailActivity.AppBarState.EXPANDED;//修改状态标记为展开
                        mCollapsingTopBarLayout.setTitle("");

                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (mState != CagDetailActivity.AppBarState.COLLAPSED) {
                        mState = CagDetailActivity.AppBarState.COLLAPSED;//修改状态标记为折叠
                        mCollapsingTopBarLayout.setTitle(name);
                    }
                } else {
                    if (mState != CagDetailActivity.AppBarState.MIDDLE) {
                        if (mState == CagDetailActivity.AppBarState.COLLAPSED) {
                            mCollapsingTopBarLayout.setTitle("");
                        }
                        mState = CagDetailActivity.AppBarState.MIDDLE;//修改状态标记为中间

                    }
                }
            }
        });
    }
//    private void initPagers() {
//        QMUIPagerAdapter pagerAdapter = new QMUIPagerAdapter() {
//            private FragmentTransaction mCurrentTransaction;
//            private Fragment mCurrentPrimaryItem = null;
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view == ((Fragment) object).getView();
//            }
//
//            @Override
//            public int getCount() {
//                return 2;
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//                switch (position) {
//                    case 0:
//                        return "Button";
//                    case 1:
//                        return "CollapsingTopBar";
//                    default:
//                        return "CollapsingTopBar";
//                }
//            }
//
//            @Override
//            protected Object hydrate(ViewGroup container, int position) {
//                switch (position) {
//                    case 0:
//                        return new CagAllFragment();
//                    case 1:
//                        return new AuthorFragment();
//                    default:
//                        return new AuthorFragment();
//
//            }
//            }
//
//            @SuppressLint("CommitTransaction")
//            @Override
//            protected void populate(ViewGroup container, Object item, int position) {
//                String name = makeFragmentName(container.getId(), position);
//                if (mCurrentTransaction == null) {
//                    mCurrentTransaction = getSupportFragmentManager().beginTransaction();
//                }
//                Fragment fragment = getSupportFragmentManager().findFragmentByTag(name);
//                if (fragment != null) {mCurrentTransaction.attach(fragment);
//                } else {
//                    fragment = (Fragment) item;
//                    mCurrentTransaction.add(container.getId(), fragment, name);
//                }
//                if (fragment != mCurrentPrimaryItem) {
//                    fragment.setMenuVisibility(false);
//                    fragment.setUserVisibleHint(false);
//                }
//            }
//
//            @SuppressLint("CommitTransaction")
//            @Override
//            protected void destroy(ViewGroup container, int position, Object object) {
//                if (mCurrentTransaction == null) {
//                    mCurrentTransaction = getSupportFragmentManager()
//                            .beginTransaction();
//                }
//                mCurrentTransaction.detach((Fragment) object);
//            }
//
//            @Override
//            public void startUpdate(ViewGroup container) {
//                if (container.getId() == View.NO_ID) {
//                    throw new IllegalStateException("ViewPager with adapter " + this
//                            + " requires a view id");
//                }
//            }
//
//            @Override
//            public void finishUpdate(ViewGroup container) {
//                if (mCurrentTransaction != null) {
//                    mCurrentTransaction.commitNowAllowingStateLoss();
//                    mCurrentTransaction = null;
//                }
//            }
//
//            @Override
//            public void setPrimaryItem(ViewGroup container, int position, Object object) {
//                Fragment fragment = (Fragment) object;
//                if (fragment != mCurrentPrimaryItem) {
//                    if (mCurrentPrimaryItem != null) {
//                        mCurrentPrimaryItem.setMenuVisibility(false);
//                        mCurrentPrimaryItem.setUserVisibleHint(false);
//                    }
//                    if (fragment != null) {
//                        fragment.setMenuVisibility(true);
//                        fragment.setUserVisibleHint(true);
//                    }
//                    mCurrentPrimaryItem = fragment;
//                }
//            }
//
//            private String makeFragmentName(int viewId, long id) {
//                return "QDFitSystemWindowViewPagerFragment:" + viewId + ":" + id;
//            }
//        };
//        mViewPager.setAdapter(pagerAdapter);
//        mTabSegment.setupWithViewPager(mViewPager);
//    }
}
