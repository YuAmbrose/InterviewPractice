package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.interviewpractice.MainActivity;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpFragment;
import com.example.interviewpractice.mvp.search.SearchRequestPresenter;
import com.example.interviewpractice.mvp.search.SearchRequestView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static com.example.interviewpractice.MyApplication.getContext;

public class SearchActivity extends AbstractMvpActivity<SearchRequestView,SearchRequestPresenter> implements SearchRequestView {


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
    private List<RankListBean.ItemListBean> itemListBeans;
    private HomeRecyclervAdapter homeRecyclervAdapter;
    private String WORD;
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
        homeRecyclervAdapter=new HomeRecyclervAdapter(getContext());
        easyrecycler.setAdapter(homeRecyclervAdapter);
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
                WORD=query;
                getPresenter().clickRequest(0,10,query);
                ClearBean();
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
    private  void ClearBean(){
//       itemListBeans=new ArrayList<>();
//
//        if (itemListBeans.size()==0){
//
//        }else {
//           itemListBeans.clear();
//        }

    }
    @Override
    public void resultSuccess(RankListBean rankListBean) {



        itemListBeans = rankListBean.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);
    }

    @Override
    public void hotSuccess(List<String> list) {
        tagContainerLayout.setTags(list);
        tagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {

//                etSearch.setSelection(text.length());
//
//                startSearch(text);
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

    }

    @Override
    protected SearchRequestPresenter createPresenter() {
        return new SearchRequestPresenter();
    }
}
