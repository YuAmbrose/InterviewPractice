package com.example.interviewpractice.ui.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.MyUser;
import com.example.interviewpractice.enity.UpdateAppInfo;
import com.example.interviewpractice.mvp.mine.presenter.UpdatePresenterImp;
import com.example.interviewpractice.mvp.mine.view.UpdateView;
import com.example.interviewpractice.ui.activity.ChangeMessageActivity;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.update.UpdateManager;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;


public class MineFragment extends BaseFragment implements UpdateView {
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;
    @BindView(R.id.iv_cover_bg)
    ImageView ivCoverBg;
    @BindView(R.id.iv_head)
    QMUIRadiusImageView ivHead;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.exit)
    QMUIRoundButton exit;
    private UpdatePresenterImp updateModelImp = new UpdatePresenterImp(this, getContext());
    private PackageInfo packInfo = null;
    private QMUICommonListItemView itemWithChevron;
    private static final String TAG = "MineFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);
        QMUIStatusBarHelper.translucent(getActivity()); // 沉浸式状态栏
        String username = (String) MyUser.getObjectByKey(MyApplication.getContext(),"localName");
        name.setText(username);
        PackageManager packageManager = MyApplication.getContext().getPackageManager();
        try {
            packInfo = packageManager.getPackageInfo(MyApplication.getContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        updateModelImp.loadUpdateApp();
        initListView();
        initExit();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        String username = (String) MyUser.getObjectByKey(MyApplication.getContext(),"localName");
        name.setText(username);
    }

    private void initExit() {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser.logOut(MyApplication.getContext());   //清除缓存用户对象
                BmobUser currentUser = BmobUser.getCurrentUser(MyApplication.getContext()); // 现在的currentUser是null了
            }
        });
    }

    private void initListView() {
        View.OnClickListener onClickListener = null;
        itemWithChevron = mGroupListView.createItemView("检查新版本");
        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron.setImageDrawable(getResources().getDrawable(R.drawable.undate));
        itemWithChevron.setDetailText("V" + packInfo.versionName);


        QMUICommonListItemView itemWithChevron1 = mGroupListView.createItemView("修改个人信息");
        itemWithChevron1.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron1.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron1.setImageDrawable(getResources().getDrawable(R.drawable.idea));
        itemWithChevron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyApplication.getContext(), ChangeMessageActivity.class);
                startActivity(intent);
            }
        });
        QMUICommonListItemView itemWithChevron2 = mGroupListView.createItemView("意见反馈");
        itemWithChevron2.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron2.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron2.setImageDrawable(getResources().getDrawable(R.drawable.msg));
        itemWithChevron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUICommonListItemView itemWithChevron3 = mGroupListView.createItemView("关于");
        itemWithChevron3.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron3.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron3.setImageDrawable(getResources().getDrawable(R.drawable.about));
        itemWithChevron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUICommonListItemView itemWithChevron4 = mGroupListView.createItemView("更多小功能");
        itemWithChevron4.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron4.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron4.setImageDrawable(getResources().getDrawable(R.drawable.gong));
        itemWithChevron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUIGroupListView.newSection(getContext())
                .addItemView(itemWithChevron1, onClickListener)
                .addItemView(itemWithChevron4, onClickListener)
                .addItemView(itemWithChevron2, onClickListener)
                .addItemView(itemWithChevron3, onClickListener)
                .addItemView(itemWithChevron, onClickListener)
                .addTo(mGroupListView);
    }

    @Override
    public void UpdateApp(final UpdateAppInfo updateAppInfo) {
        final int localVersion = packInfo.versionCode;
        final int newVersion = Integer.valueOf(updateAppInfo.getVersion());
        if (newVersion > localVersion) {
            itemWithChevron.showNewTip(true);
        }
        itemWithChevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newVersion > localVersion) {
                    startUpdateApp(updateAppInfo);
                } else {
                    Toast.makeText(MyApplication.getContext(), "目前已是最新版本" + "V-" + packInfo.versionName, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startUpdateApp(final UpdateAppInfo updateAppInfo) {
        new QMUIDialog.MessageDialogBuilder(getActivity())
                .setTitle("更新提示：")
                .setMessage("检测到新版本，是否更新？")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        UpdateManager manager = new UpdateManager(MyApplication.getContext());
                        manager.startDownload(updateAppInfo.getInstall_url());
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
