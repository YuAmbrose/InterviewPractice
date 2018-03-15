package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.example.interviewpractice.R;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {


    @BindView(R.id.searchEdit)
    SearchView mSearchView;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;

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
    }

    private void initView() {
        mSearchView.setQueryHint("输入标题或关键词寻找更多的视频");
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);
        mSearchView.onActionViewExpanded();
        mSearchView.setIconified(true);
    }
}
