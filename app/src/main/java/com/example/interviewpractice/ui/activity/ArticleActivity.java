package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.ArticleBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.article.ArticlePresenter;
import com.example.interviewpractice.mvp.article.ArticleView;
import com.example.interviewpractice.utils.util.HtmlUtil;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleActivity extends AbstractMvpActivity<ArticleView, ArticlePresenter> implements ArticleView {

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.tview)
    TextView textView;
    private static final String TAG = "ArticleActivity";
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.laout)
    LinearLayout laout;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    private QMUITipDialog tipDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        webView.getSettings().setJavaScriptEnabled(true);// 支持js

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (i == 100) {
                    tipDialog.dismiss();
//                    laout.setVisibility(View.VISIBLE);
                }
            }
        });
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               swipe.setRefreshing(false);
                getPresenter().clickRequest("random");
            }
        });
        getPresenter().clickRequest("today");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
    }

    @Override
    protected ArticlePresenter createPresenter() {
        return new ArticlePresenter();
    }

    @Override
    public void requestLoading() {
//        laout.setVisibility(View.GONE);
        tipDialog = new QMUITipDialog.Builder(this)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("Loading..")
                .create();
        tipDialog.show();

    }

    @Override
    public void resultSuccess(ArticleBean articleBean) {
        author.setText("作者：" + articleBean.getData().getAuthor());
        mTopBar.setTitle(articleBean.getData().getTitle());
        String content="<p><img src=\\\"/ueditor/php/upload/image/20180627/1530082324.jpg\\\" title=\\\"1530082324.jpg\\\"/></p><p><img src=\\\"/ueditor/php/upload/image/20180627/1530082324.jpg\\\" title=\\\"1530082324.jpg\\\"/></p><p>\\t\\t\\t\\t\\t\\t</p>";
        webView.loadData(articleBean.getData().getContent(), HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
        textView.setText("全文完    共" + articleBean.getData().getWc() + "字");
    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: " + result);
    }

    @Override
    public void onDestroy() {
        if (webView != null)
            webView.destroy();
        super.onDestroy();
    }
}
