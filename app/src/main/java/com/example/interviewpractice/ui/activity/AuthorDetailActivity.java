package com.example.interviewpractice.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.interviewpractice.R;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;

public class AuthorDetailActivity extends AppCompatActivity {
    @BindView(R.id.collapsing_topbar_layout)
    QMUICollapsingTopBarLayout mCollapsingTopBarLayout;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
    }
}
