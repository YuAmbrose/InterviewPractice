package com.example.interviewpractice.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIAppBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;


public class MineFragment extends BaseFragment {


    @BindView(R.id.iv_cover_bg)
    ImageView ivCoverBg;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.appbar)
    QMUIAppBarLayout appbar;
//    @BindView(R.id.groupListView)
//    QMUIGroupListView mGroupListView;
    Unbinder unbinder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        QMUIStatusBarHelper.translucent(getActivity()); // 沉浸式状态栏
        mTopBar.setPadding(0, getStatusBarHeight(this), 0, 0);

        mTopBar.addRightImageButton(R.mipmap.icon_topbar_overflow, R.id.topbar_right_change_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
        initListView();
        return view;
    }

    private void initListView() {
//        View.OnClickListener onClickListener = null;
//        QMUICommonListItemView itemWithChevron = mGroupListView.createItemView("Item 4");
//        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
////        itemWithChevron.setOrientation(QMUICommonListItemView.VERTICAL);
////        itemWithChevron.setDetailText("当前版本V 1.0.1");
//        itemWithChevron.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        QMUIGroupListView.newSection(MyApplication.getContext())
//                .addItemView(itemWithChevron, onClickListener)
//                .addTo(mGroupListView);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
