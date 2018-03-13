package com.example.interviewpractice.ui.fragment.childFragment;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.qmuiteam.qmui.widget.QMUIPagerAdapter;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BlankDetailFragment extends BaseFragment {


     @BindView(R.id.pager) QMUIViewPager mViewPager;
    @BindView(R.id.tabs) QMUITabSegment  mTabSegment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_detail, container, false);
         ButterKnife.bind(this, view);
//         initPagers();

        return view;
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
//                    mCurrentTransaction = getChildFragmentManager().beginTransaction();
//                }
//                Fragment fragment = getChildFragmentManager().findFragmentByTag(name);
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
//                    mCurrentTransaction = getChildFragmentManager()
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
