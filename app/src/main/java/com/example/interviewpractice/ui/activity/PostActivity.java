package com.example.interviewpractice.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.MyUser;
import com.example.interviewpractice.enity.Post;
import com.example.interviewpractice.weight.LinedEditText;
import com.qmuiteam.qmui.alpha.QMUIAlphaButton;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class PostActivity extends AppCompatActivity {

    @BindView(R.id.edit_query)
    LinedEditText editContent;
    @BindView(R.id.push)
    QMUIRoundButton push;
    @BindView(R.id.linelayout)
    LinearLayout linelayout;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);
        mTopBar.setTitle("发帖子");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });

//        QMUIViewHelper.fadeIn(push, 500, null, true);
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushText();
            }
        });
    }

    private void pushText() {
        if (TextUtils.isEmpty(editContent.getText().toString())){
            Snackbar.make(linelayout, "内容不能为空哦", Snackbar.LENGTH_SHORT).show();
        }else {
            MyUser user = BmobUser.getCurrentUser(MyApplication.getContext(), MyUser.class);
            Post post = new Post();
            String model = Build.MODEL;   //手机信号
            String carrier = Build.MANUFACTURER;   //手机牌子
            post.setAuthor(user);
            post.setName((String) BmobUser.getObjectByKey(MyApplication.getContext(), "localName"));
            post.setPhoneType(carrier + "-" + model);
            post.setContent(editContent.getText().toString());
            post.save(MyApplication.getContext(), new SaveListener() {

                @Override
                public void onSuccess() {
                    Toast.makeText(MyApplication.getContext(), "成功了", Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(int i, String s) {
                    Toast.makeText(MyApplication.getContext(), "失败了", Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
}
