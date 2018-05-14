package com.example.interviewpractice.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.adapter.adapter.SearchAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.search.SearchRequestPresenter;
import com.example.interviewpractice.mvp.search.SearchRequestView;
import com.example.interviewpractice.utils.util.UtilsHelp;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

import static com.example.interviewpractice.MyApplication.getContext;

public class SearchActivity extends AbstractMvpActivity<SearchRequestView,SearchRequestPresenter> implements SearchRequestView,RecyclerArrayAdapter.OnLoadMoreListener {


    @BindView(R.id.searchEdit)
    SearchView mSearchView;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.layout_tag)
    TagContainerLayout tagContainerLayout;
    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private static final String TAG = "SearchActivity";
    private SearchView.SearchAutoComplete mSearchAutoComplete;
    private List<RankListBean.ItemListBean> itemListBeans=new ArrayList<>();
    private SearchAdapter homeRecyclervAdapter;
    private String WORD;
    private Handler handler = new Handler();
    private int num=10;
    private int start=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        getPresenter().clickRequestList();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter=new SearchAdapter(getContext());
        easyrecycler.setAdapter(homeRecyclervAdapter);
        homeRecyclervAdapter.setMore(R.layout.load_more_layout,this);
        homeRecyclervAdapter.setNoMore(R.layout.no_more_layout);
        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id=homeRecyclervAdapter.getItem(position).getData().getId();
                Intent selectIntent=new Intent(MyApplication.getContext(), EDetailActivity.class);
                selectIntent.putExtra("id",String.valueOf(id));
                startActivity(selectIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
            }
        });
    }

    private void initView() {
        mSearchView.setQueryHint("输入标题或关键词寻找更多的视频");
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);
        mSearchView.onActionViewExpanded();
        mSearchView.setIconified(true);
        mSearchView.setSubmitButtonEnabled(true);

        mSearchAutoComplete = (SearchView.SearchAutoComplete) mSearchView.findViewById(R.id.search_src_text);
        mSearchAutoComplete.setHintTextColor(getResources().getColor(android.R.color.darker_gray));
        mSearchAutoComplete.setTextColor(getResources().getColor(android.R.color.background_dark));
        mSearchAutoComplete.setTextSize(12);
        LinearLayout search_edit_frame = (LinearLayout) mSearchView.findViewById(R.id.search_edit_frame);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) search_edit_frame.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        search_edit_frame.setLayoutParams(params);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            //输入完成后，提交时触发的方法，一般情况是点击输入法中的搜索按钮才会触发，表示现在正式提交了
            public boolean onQueryTextSubmit(String query)
            {
                easyrecycler.setRefreshing(true);
                homeRecyclervAdapter.removeAll();
                WORD=query;
                getPresenter().clickRequest(0,num,query);
                UtilsHelp.setSoftInputActive(SearchActivity.this, mSearchView, false);
                tagContainerLayout.setVisibility(View.GONE);
                return true;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void requestLoading() {
    }

    @Override
    public void resultSuccess(RankListBean rankListBean) {

//        Observable.just(rankListBean.getItemList())
//                .filter(new Predicate<List<RankListBean.ItemListBean>>() {
//                    @Override
//                    public boolean test(List<RankListBean.ItemListBean> itemListBeans) throws Exception {
//                        for (int i = 0; i <itemListBeans.size() ; i++) {
//                            i++;
//                        }
//                        return itemListBeans.;
//
//                })

//        for (int i = 0; i < rankListBean.getItemList().size(); i++) {
//            if (rankListBean.getItemList().get(i).getType()==("video")) {
//                itemListBeans.add(rankListBean.getItemList().get(i));
//            } else {
//
//            }
//        }

//        for (int i = 0; i < rankListBean.getItemList().size(); i++) {
//            if (rankListBean.getItemList().get(i).getType().equals("video")) {
//
//            } else {
//                rankListBean.getItemList().remove(i);
//            }
//        }
        itemListBeans = rankListBean.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);


    }

    @Override
    public void hotSuccess(final List<String> list) {

        tagContainerLayout.setTags(list);

        tagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                    tagContainerLayout.setBackgroundColor(Color.parseColor("#6495ED"));
            }
            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });
    }

    @Override
    public void resultFailure(String result) {
        Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected SearchRequestPresenter createPresenter() {
        return new SearchRequestPresenter();
    }
    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                getPresenter().clickRequest(start*num,num,WORD);
                start++;
            }
        },100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        UtilsHelp.setSoftInputActive(SearchActivity.this, mSearchView, false);
    }
}
