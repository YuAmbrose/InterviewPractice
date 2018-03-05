package com.example.interviewpractice.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.EyDetail.RequestPresenter;
import com.example.interviewpractice.mvp.EyDetail.RequestView;

import com.example.interviewpractice.v_layout.ItemListener;
import com.example.interviewpractice.v_layout.VlayoutBaseAdapter;
import com.example.interviewpractice.v_layout.holder.EyDetail.TextHolder;
import com.example.interviewpractice.v_layout.holder.home.SelectHolder;
import com.example.interviewpractice.weight.FatRecyclerview;
import com.example.interviewpractice.weight.JzPlayer;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.glide.transformations.BlurTransformation;


public class EDetailActivity extends AbstractMvpActivity<RequestView, RequestPresenter> implements RequestView {
    @BindView(R.id.pgc_recyclerview)
    FatRecyclerview mRecycler;
    @BindView(R.id.imagebg)
    ImageView imagebg;
    @BindView(R.id.player)
    JzPlayer jzPlayer;

    private List<RankListBean> itemListBeans = new ArrayList<>();
    private RequestPresenter requestPresenter;
    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter jzAdapter, textAdapter,setlectAdapter;
    private Context mContext;
    private List<EyDetailBean> detailBeans = new ArrayList<>();
    private static final String TAG = "EDetailActivity";
    private QMUITipDialog tipDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edetail);
        ButterKnife.bind(this);
        jzPlayer.setVisibility(View.GONE);
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        getPresenter().clickRequest(id);
        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        jzPlayer.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initAdapter();
    }

    private void initAdapter() {
//        jzAdapter = new VlayoutBaseAdapter(mContext)
//                .setData(new ArrayList<EyDetailBean>())
//                .setLayout(R.layout.vlayout_ey_detail_player)
//                .setLayoutHelper(new LinearLayoutHelper())
//                .setHolder(JzPlayerHolder.class);
//        delegateAdapter.addAdapter(jzAdapter);
        textAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<EyDetailBean>())
                .setLayout(R.layout.vlayout_ey_detail_text)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(TextHolder.class);
        setlectAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<RankListBean>())
                .setLayoutHelper(new LinearLayoutHelper())
                .setLayout(R.layout.vlayout_eydetail_recyclerview)
                .setHolder(SelectHolder.class)
                .setListener(new ItemListener<RankListBean>() {
                    @Override
                    public void onItemClick(View view, int position, RankListBean mData) {
                        getPresenter().clickRequest("35832");


                    }
                });
        delegateAdapter.addAdapter(textAdapter);
        delegateAdapter.addAdapter(setlectAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }

    @Override
    protected RequestPresenter createPresenter() {
        return new RequestPresenter();
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
    public void resultSuccess(EyDetailBean eyDetailBean) {
        tipDialog.dismiss();
        jzPlayer.setVisibility(View.VISIBLE);
        jzPlayer.setUp(eyDetailBean.getPlayUrl(), jzPlayer.SCREEN_WINDOW_NORMAL, "");
        Glide.with(this).load(eyDetailBean.getCoverForDetail()).into(jzPlayer.thumbImageView);
//        GlideManager.loadImage(this,eyDetailBean.getCoverBlurred(),imagebg);
        Glide.with(this)
                .load(eyDetailBean.getCoverBlurred())
                .crossFade(500)
                .bitmapTransform(new BlurTransformation(getApplicationContext(), 140, 50))
                .into(imagebg);
        detailBeans.add(eyDetailBean);
//        jzAdapter.setData(detailBeans);
//        jzAdapter.notifyDataSetChanged();
        textAdapter.setData(detailBeans);
        textAdapter.notifyDataSetChanged();
    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultRecomendar(RankListBean rankListBean) {

        for (int i = 0; i < rankListBean.getItemList().size(); i++) {
            if (rankListBean.getItemList().get(i).getType().equals("textCard")) {
                rankListBean.getItemList().remove(i);
            } else {
            }
        }
            itemListBeans.add(rankListBean);
            setlectAdapter.setData(itemListBeans);
            setlectAdapter.notifyDataSetChanged();
    }
    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
