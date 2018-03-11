package com.example.interviewpractice.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.EyReplyBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.EyDetail.RequestPresenter;
import com.example.interviewpractice.mvp.EyDetail.RequestView;

import com.example.interviewpractice.v_layout.ItemListener;
import com.example.interviewpractice.v_layout.VlayoutBaseAdapter;
import com.example.interviewpractice.v_layout.holder.EyDetail.ReplyHolder;
import com.example.interviewpractice.v_layout.holder.EyDetail.TagsHolder;
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
import jp.wasabeef.glide.transformations.ColorFilterTransformation;


public class EDetailActivity extends AbstractMvpActivity<RequestView, RequestPresenter> implements RequestView {
    @BindView(R.id.pgc_recyclerview)
    RecyclerView mRecycler;
    @BindView(R.id.imagebg)
    ImageView imagebg;
    @BindView(R.id.player)
    JzPlayer jzPlayer;

    private List<RankListBean> itemListBeans = new ArrayList<>();
    private RequestPresenter requestPresenter;
    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter jzAdapter, textAdapter,setlectAdapter,replyAdapter,tagsAdapter;
    private Context mContext;
    private List<EyDetailBean> detailBeans = new ArrayList<>();
    private List<EyReplyBean>  replyBeans=new ArrayList<>();
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
        virtualLayoutManager.setRecycleOffset(0);
        mRecycler.setLayoutManager(virtualLayoutManager);
       RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(2, 20);
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
//        tagsAdapter= new VlayoutBaseAdapter(mContext)
//                .setData(new ArrayList<EyDetailBean>())
//                .setLayout(R.layout.vlayout_detail_tags)
//                .setLayoutHelper(new LinearLayoutHelper())
//                .setHolder(TagsHolder.class);
       replyAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<EyReplyBean>())
                .setLayout(R.layout.vlayout_eydetail_reply)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ReplyHolder.class);
        textAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<EyDetailBean>())
                .setLayout(R.layout.vlayout_ey_detail_text)
                .setLayoutHelper(new ColumnLayoutHelper())
                .setHolder(TextHolder.class)
                .setListener(new ItemListener<EyDetailBean>() {
            @Override
            public void onItemClick(View view, int position, EyDetailBean mData) {
                Intent anthorIntent=new Intent(MyApplication.getContext(), AuthorDetailActivity.class);
                int id=mData.getAuthor().getId();
                anthorIntent.putExtra("id",String.valueOf(id));
                startActivity(anthorIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
            }
        });
        setlectAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<RankListBean>())
                .setLayoutHelper(new LinearLayoutHelper())
                .setLayout(R.layout.vlayout_eydetail_recyclerview)
                .setHolder(SelectHolder.class)
                .setListener(new ItemListener<RankListBean>() {
                    @Override
                    public void onItemClick(View view, int position, RankListBean mData) {
                        Intent intent=new Intent(EDetailActivity.this,EDetailActivity.class);
                        int id=mData.getItemList().get(position).getData().getId();
                        intent.putExtra("id",String.valueOf(id));
                        startActivity(intent);
                        finish();
                    }
                });
        delegateAdapter.addAdapter(textAdapter);
        delegateAdapter.addAdapter(replyAdapter);
//        delegateAdapter.addAdapter(tagsAdapter);
        delegateAdapter.addAdapter(setlectAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }
    private LayoutHelper getGridLayoutHelper() {
        GridLayoutHelper gridHelper = new GridLayoutHelper(3);
        gridHelper.setMarginTop(10);
        gridHelper.setWeights(new float[]{33.3f, 33.3f, 33.3f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(43);
        //设置水平方向条目的间隔
        gridHelper.setHGap(3);
        gridHelper.setMarginLeft(15);
        gridHelper.setMarginBottom(15);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        return gridHelper;
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

        jzPlayer.setVisibility(View.VISIBLE);
        jzPlayer.setUp(eyDetailBean.getPlayUrl(), jzPlayer.SCREEN_WINDOW_NORMAL, "");
        Glide.with(this).load(eyDetailBean.getCoverForDetail()).into(jzPlayer.thumbImageView);
//        GlideManager.loadImage(this,eyDetailBean.getCoverBlurred(),imagebg);
        Glide.with(this)
                .load(eyDetailBean.getCoverBlurred())
                .crossFade(10)
                .bitmapTransform(new BlurTransformation(getApplicationContext(), 23, 40)
                        ,new ColorFilterTransformation(MyApplication.getContext(),0x35000000))
                .placeholder(new ColorDrawable(MyApplication.getContext().getResources().getColor(R.color.
                        detail_bg2)))
                .into(imagebg);
        detailBeans.add(eyDetailBean);
        textAdapter.setData(detailBeans);
        textAdapter.notifyDataSetChanged();

//        tagsAdapter.setData(detailBeans);
//        tagsAdapter.notifyDataSetChanged();
        tipDialog.dismiss();
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
    public void resultReply(EyReplyBean replyBean) {
        replyBeans.add(replyBean);
        replyAdapter.setData(replyBeans);
        replyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
         tipDialog.dismiss();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
