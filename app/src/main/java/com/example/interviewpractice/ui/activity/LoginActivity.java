package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MainActivity;
import com.example.interviewpractice.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.imagebg)
    ImageView imagebg;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.btn_signup)
    AppCompatButton btnSignup;
    private static final String TAG = "LoginActivity";
    @BindView(R.id.fragout)
    FrameLayout fragout;
    private QMUITipDialog tipDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        QMUIViewHelper.fadeIn(imagebg, 5000, null, true);
        Glide.with(this).load("http://bmob-cdn-15478.b0.upaiyun.com/2018/03/23/79540e984030ad868051aa9e34cf5b82.jpg").into(imagebg);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tip();
                init();
            }
        });

    }

    private void init() {
        BmobUser bUser = new BmobUser();
        String name = inputName.getText().toString();
        String password = inputPassword.getText().toString();
        bUser.setUsername(name);
        bUser.setPassword(password);
        bUser.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                tipDialog.dismiss();
                showSnackbar();
            }
        });
    }

    private void Tip() {
        tipDialog = new QMUITipDialog.Builder(this)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("注册中")
                .create();
        tipDialog.show();
    }

    private void showSnackbar() {
        Snackbar.make(fragout, "该用户名已存在", Snackbar.LENGTH_SHORT)
                .setAction("知道了", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).setDuration(Snackbar.LENGTH_SHORT).show();


    }
}
