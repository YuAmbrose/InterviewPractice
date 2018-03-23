package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.example.interviewpractice.MainActivity;
import com.example.interviewpractice.R;

import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import cn.bmob.v3.BmobUser;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_welcome);
        Observable.timer(0, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) throws Exception {
                            BmobUser bmobUser = BmobUser.getCurrentUser(WelcomeActivity.this);
                            if(bmobUser != null){
                                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                            }else{
                                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                            }

                            finish();
                        }
                    });
    }


}