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
import com.example.interviewpractice.utils.util.ImgSizeUtil;
import com.example.interviewpractice.utils.util.StringUtil;
import com.example.interviewpractice.weight.JzPlayer;
import com.hymane.expandtextview.ExpandTextView;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AbstractMvpActivity<MovieRequestView, MovieRequestPresenter> implements MovieRequestView {
    private static final String TAG = "MovieDetailActivity";
    @BindView(R.id.player)
    JzPlayer jzPlayer;
    @BindView(R.id.dra)
    ExpandTextView dra;
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
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.e(TAG, "*************************** " + id);
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
    public void resultSuccess(final MovieDetailBean movieDetailBean) {
        dra.setContent(movieDetailBean.getData().getMovie().getDra());
        dra.setTitleTextSize(0);
        dra.setTitle("");
        dra.setAnimationDuration(60);

        jzPlayer.setUp(movieDetailBean.getData().getMovie().getVd(), jzPlayer.SCREEN_WINDOW_NORMAL, "");
        Glide.with(this).load(movieDetailBean.getData().getMovie().getVideoImg()).into(jzPlayer.thumbImageView);
        name.setText(movieDetailBean.getData().getMovie().getNm());
        egname.setText(movieDetailBean.getData().getMovie().getEnm());
        sc.setText(String.format("%s", movieDetailBean.getData().getMovie().getSc()));
        snum.setText(String.format("(%s人评)", StringUtil.changeNumToCN(movieDetailBean.getData().getMovie().getSnum())));
        src.setText(movieDetailBean.getData().getMovie().getSrc());
        dur.setText(" /" + movieDetailBean.getData().getMovie().getDur() + "分钟");
        pubDesc.setText(movieDetailBean.getData().getMovie().getPubDesc());

        //listview添加按钮
        View.OnClickListener onClickListener = null;
        QMUICommonListItemView itemWithChevron1 = mGroupListView.createItemView("查看电影长评");
        itemWithChevron1.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleBottomSheetList(movieDetailBean.getData().getMovie().getPhotos());
            }
        });
        QMUICommonListItemView itemWithChevron2 = mGroupListView.createItemView("查看更多电影预告片");
        itemWithChevron2.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUICommonListItemView itemWithChevron3 = mGroupListView.createItemView("查看电影专业评论");
        itemWithChevron3.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUIGroupListView.newSection(this)
                .addItemView(itemWithChevron1, onClickListener)
                .addItemView(itemWithChevron2, onClickListener)
                .addItemView(itemWithChevron3, onClickListener)
                .addTo(mGroupListView);

        String iUrl = ImgSizeUtil.resetPicUrl(movieDetailBean.getData().getMovie().getAlbumImg(), ".webp@321w_447h_1e_1c_1l");
        Log.e(TAG, "~~~~~~~~~~`" + movieDetailBean.getData().getMovie().getAlbumImg());
        String bgUrl=ImgSizeUtil.resetPicUrl(movieDetailBean.getData().getMovie().getImg(),".webp@321w_447h_1e_1c_1l");
        Glide.with(this).load(bgUrl).into(bgPic);
//        if (movieDetailBean.getData().getMovie().getAlbumImg()!=null){
//            Glide.with(this).load(iUrl).into(bgPic);
//        }else {
//            Glide.with(this).load(bgUrl).into(bgPic);
//        }
    }


    private void showSimpleBottomSheetList(List<String> text) {
        QMUIBottomSheet.BottomListSheetBuilder builder = new QMUIBottomSheet.BottomListSheetBuilder(MovieDetailActivity.this);
        for (int i = 0; i < text.size(); i++) {
            builder.addItem(text.get(i));
        }
        builder.addItem("你好哦这里是沈光耀：这个时代，缺的不是完美的人，缺的是从自己心里给出的真心、正义、无畏和同情。");
        builder.setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
            @Override
            public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                dialog.dismiss();

            }
        })
                .build()
                .show();
    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "水水水水水水水水水水水水水e: "+result );
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
