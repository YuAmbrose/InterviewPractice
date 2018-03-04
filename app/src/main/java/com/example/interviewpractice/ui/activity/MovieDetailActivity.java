package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.MovieDetailBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.movieDetail.MovieRequestPresenter;
import com.example.interviewpractice.mvp.movieDetail.MovieRequestView;
import com.example.interviewpractice.utils.ImgSizeUtil;
import com.example.interviewpractice.utils.StringUtil;
import com.example.interviewpractice.weight.JzPlayer;
import com.hymane.expandtextview.ExpandTextView;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;

public class MovieDetailActivity extends AbstractMvpActivity<MovieRequestView, MovieRequestPresenter> implements MovieRequestView {

    @BindView(R.id.player)
    JzPlayer jzPlayer;
    @BindView(R.id.dra)
    ExpandTextView dra;
    private static final String TAG = "MovieDetailActivity";
    @BindView(R.id.bgPic)
    ImageView bgPic;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.egname)
    TextView egname;
    @BindView(R.id.sc)
    TextView sc;
    @BindView(R.id.snum)
    TextView snum;
    @BindView(R.id.src)
    TextView src;
    @BindView(R.id.dur)
    TextView dur;
    @BindView(R.id.pubDesc)
    TextView pubDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        Log.e(TAG, "*************************** "+id );
        getPresenter().clickRequest(id);
        jzPlayer.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected MovieRequestPresenter createPresenter() {
        return new MovieRequestPresenter();
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(MovieDetailBean movieDetailBean) {
        dra.setContent(movieDetailBean.getData().getMovie().getDra());
        dra.setTitleTextSize(0);
        dra.setTitle("");
        jzPlayer.setUp(movieDetailBean.getData().getMovie().getVd(), jzPlayer.SCREEN_WINDOW_NORMAL, "");
        Glide.with(this).load(movieDetailBean.getData().getMovie().getVideoImg()).into(jzPlayer.thumbImageView);
        String iUrl= ImgSizeUtil.resetPicUrl(movieDetailBean.getData().getMovie().getAlbumImg(),".webp@321w_447h_1e_1c_1l");
        Log.e(TAG, "~~~~~~~~~~`"+iUrl );
        Glide.with(this).load(iUrl).into(bgPic);
        name.setText(movieDetailBean.getData().getMovie().getNm());
        egname.setText(movieDetailBean.getData().getMovie().getEnm());
        sc.setText(String.format("%s",movieDetailBean.getData().getMovie().getSc()));
       snum.setText(String.format("(%s人评)", StringUtil.changeNumToCN(movieDetailBean.getData().getMovie().getSnum())));
       src.setText(movieDetailBean.getData().getMovie().getSrc());
       dur.setText(" /"+movieDetailBean.getData().getMovie().getDur()+"分钟");
       pubDesc.setText(movieDetailBean.getData().getMovie().getPubDesc());
    }

    @Override
    public void resultFailure(String result) {

    }
    @Override
    public void onBackPressed() {
        if (JzPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
       JzPlayer.releaseAllVideos();
    }
}
