package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.CategoryAdapter;
import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.YoutubeBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.category.CategoryRequestPresenter;
import com.example.interviewpractice.mvp.category.CategoryRequestView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AbstractMvpActivity<CategoryRequestView, CategoryRequestPresenter> implements CategoryRequestView {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recycleview)
    EasyRecyclerView recycleview;
    private List<Cag> itemListBeans;
    private CategoryAdapter categoryAdapter;
    private QMUITipDialog tipDialog;
    private static final String TAG = "CategoryActivity";
    private  List<YoutubeBean.ItemsBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
//        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        ButterKnife.bind(this);
        getPresenter().clickRequest();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(staggeredGridLayoutManager);
        categoryAdapter = new CategoryAdapter(this);
        recycleview.setAdapter(categoryAdapter);
        categoryAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(CategoryActivity.this,CagDetailActivity.class);
                String id=categoryAdapter.getItem(position).getId();
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        mTopBar.setTitle("全部分类");
//        getPresenter().requesYoutube("PLXRPwD7vOoN24keLPN2e5LYPkq5RgLTCY");
    }

    @Override
    protected CategoryRequestPresenter createPresenter() {
        return new CategoryRequestPresenter();
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
    public void resultSuccess(List<Cag> list) {
        Log.e(TAG, "s是s: "+list );
        categoryAdapter.addAll(list);
        tipDialog.dismiss();
    }

//    @Override
//    public void resultSuccess(Cag categoryBean) {
//        itemListBeans=categoryBean.getItemList();
//        Observable.just(itemListBeans)
//               .filter(new Predicate<List<Cag.ItemListBean>>() {
//                   @Override
//                   public boolean test(List<Cag.ItemListBean> itemListBeans) throws Exception {
//                       for (int i = 0; i <itemListBeans.size() ; i++) {
//                                if (itemListBeans.get(i).getData().isShade()){
//
//                                }else {
//                                   itemListBeans.remove(i);
//                                }
//                       }
//                       return true;
//                   }
//               })
//                .subscribe(new Consumer<List<Cag.ItemListBean>>() {
//                    @Override
//                    public void accept(List<Cag.ItemListBean> itemListBeans) throws Exception {
//                        categoryAdapter.addAll(itemListBeans);
//                    }
//                });
//    }




    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void successYou(YoutubeBean youtubeBean) {
        StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");

        list=youtubeBean.getItems();
        for (int i = 0; i <list.size() ; i++) {
            sBuffer.append(list.get(i).getSnippet().getThumbnails().getStandard().getUrl()+"\n");
        }
        Log.e(TAG, "successYou: "+sBuffer );
    }

}
