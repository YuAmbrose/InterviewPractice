package com.example.interviewpractice.ui.fragment.childFragment;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.interviewpractice.MainActivity;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.example.interviewpractice.ui.activity.CategoryActivity;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.rxbus.MessageEvent;
import com.example.interviewpractice.utils.rxbus.RxBus;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;


public class CagPopularFragment extends BaseFragment implements RankListView {
    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
    private String id;
    private static final String TAG = "CagPopularFragment";
    private List<RankListBean.ItemListBean> itemListBeans;
    private HomeRecyclervAdapter homeRecyclervAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cag_detail, container, false);
        ButterKnife.bind(this, view);

        RxBus.getInstance().register(String.class).subscribe(new Consumer<String>() {
            @Override
            public void accept(String integ) throws Exception {
//                Log.e(TAG, "accept: "+integ );
//              id=integ;
            }
        });
        rankListPresenterImp.loadPopular("mostPopular", "2", 0, 10);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter = new HomeRecyclervAdapter(getContext());
        easyrecycler.setAdapter(homeRecyclervAdapter);
            return view;
    }



            @Override
            public void rankSuccess(RankListBean rData) {

                itemListBeans = rData.getItemList();
                homeRecyclervAdapter.addAll(itemListBeans);
            }

            @Override
            public void selectSuccess(RankListBean sData) {

            }

            @Override
            public void onDestroy() {
                super.onDestroy();

            }
        }

