package com.example.interviewpractice.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.Cag;
import com.example.interviewpractice.enity.YoutubeBean;
import com.example.interviewpractice.mvp.EyDetail.AbstractMvpActivity;
import com.example.interviewpractice.mvp.category.CategoryRequestPresenter;
import com.example.interviewpractice.mvp.category.CategoryRequestView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GetYoutbeActivity extends AbstractMvpActivity<CategoryRequestView, CategoryRequestPresenter> implements CategoryRequestView {

    @BindView(R.id.edit_query) EditText editQuery;
    @BindView(R.id.clicj) Button clicj;
    private  List<YoutubeBean.ItemsBean> list;
    private static final String TAG = "GetYoutbeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_youtbe);
        ButterKnife.bind(this);
        clicj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed=editQuery.getText().toString().trim();
                getPresenter().requesYoutube(ed);
            }
        });
    }

    @Override
    protected CategoryRequestPresenter createPresenter() {
        return new CategoryRequestPresenter();
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(List<Cag> result) {

    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: " );
    }

    @Override
    public void successYou(YoutubeBean youtubeBean) {
        StringBuffer sBuffer = new StringBuffer();

        list=youtubeBean.getItems();
        for (int i = 0; i <list.size() ; i++) {
            sBuffer.append(list.get(i).getSnippet().getThumbnails().getMedium().getUrl()+"\n");
        }
        Log.e(TAG, "successYou: "+sBuffer );
    }
}
