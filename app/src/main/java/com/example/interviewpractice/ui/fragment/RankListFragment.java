package com.example.interviewpractice.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.RankListAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.example.interviewpractice.ui.activity.AuthorDetailActivity;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RankListFragment extends BaseFragment implements RankListView {

    @BindView(R.id.recycle)
    EasyRecyclerView rankListRecyclerview;
    private static final String TAG = "RankListFragment";
    private static String[] path = {"weekly", "monthly", "historical"};
    private String part;
    public static final String PATH = "args_page";
    private RankListAdapter rankListAdapter;
    private RankListPresenterImp rankListPresenterImp=new RankListPresenterImp(this,getContext());
    private List<RankListBean.ItemListBean> listBeans;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    public static RankListFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putString(PATH, path[position]);
        RankListFragment fragment = new RankListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        part = getArguments().getString(PATH);
        rankListAdapter = new RankListAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank_list, container, false);
        ButterKnife.bind(this, view);
        rankListPresenterImp.loadRanklist(part,0,10);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rankListRecyclerview.setLayoutManager(staggeredGridLayoutManager);
        rankListRecyclerview.setAdapter(rankListAdapter);
        rankListAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent anthorIntent=new Intent(MyApplication.getContext(), AuthorDetailActivity.class);
                int id=rankListAdapter.getItem(position).getData().getAuthor().getId();
                anthorIntent.putExtra("id",String.valueOf(id));
                startActivity(anthorIntent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
            }
        });
        return view;
    }


    @Override
    public void rankSuccess(RankListBean rData) {
        listBeans = rData.getItemList();
        rankListAdapter.addAll(listBeans);
        rankListAdapter.notifyDataSetChanged();
    }

    @Override
    public void selectSuccess(RankListBean sData) {

    }
}
