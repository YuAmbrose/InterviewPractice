package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.MyUser;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class ChangeMessageActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    QMUIGroupListView mGroupListView;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    private static final String TAG = "ChangeMessageActivity";
    private  QMUICommonListItemView itemWithChevron4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_message);
        ButterKnife.bind(this);
        mTopBar.setTitle("修改信息");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        initListView();
    }
    private void initListView() {
        View.OnClickListener onClickListener = null;


        QMUICommonListItemView itemWithChevron1 = mGroupListView.createItemView("登录账号");
        itemWithChevron1.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        itemWithChevron1.setDetailText((String) MyUser.getObjectByKey(MyApplication.getContext(),"username"));


        itemWithChevron4 = mGroupListView.createItemView("用户名");
        itemWithChevron4.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron4.setImageDrawable(getResources().getDrawable(R.drawable.username));
        itemWithChevron4.setDetailText((String) MyUser.getObjectByKey(MyApplication.getContext(),"localName"));
        itemWithChevron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditTextDialog();
            }
        });

        QMUIGroupListView.newSection(this)
                .addItemView(itemWithChevron1, onClickListener)
                .addItemView(itemWithChevron4, onClickListener)
                .addTo(mGroupListView);
    }
    private void showEditTextDialog() {
        final QMUIDialog.EditTextDialogBuilder builder = new QMUIDialog.EditTextDialogBuilder(this);
        builder.setTitle("修改用户名")
                .setPlaceholder("在此输入您的用户名")
                .setInputType(InputType.TYPE_CLASS_TEXT)
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        Editable text = builder.getEditText().getText();
                        if (text != null && text.length() > 0) {
                            MyUser newUser = new MyUser();
                            newUser.setSessionToken(newUser.getSessionToken());
                            newUser.setLocalName(String.valueOf(text));
                            BmobUser bmobUser = BmobUser.getCurrentUser(MyApplication.getContext());
                            newUser.update(MyApplication.getContext(),bmobUser.getObjectId(),new UpdateListener() {
                                @Override
                                public void onSuccess() {
                                    Toast.makeText(ChangeMessageActivity.this, "修改信息成功", Toast.LENGTH_SHORT).show();
                                    itemWithChevron4.setDetailText((String) MyUser.getObjectByKey(MyApplication.getContext(),"localName"));
                                }

                                @Override
                                public void onFailure(int i, String s) {
                                    Log.e(TAG, "onFailure: "+s );
                                    Toast.makeText(ChangeMessageActivity.this,s , Toast.LENGTH_SHORT).show();
                                }
                            });

                            dialog.dismiss();
                        } else {
                            Toast.makeText(ChangeMessageActivity.this, "你输入的为空", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .show();
    }
}
