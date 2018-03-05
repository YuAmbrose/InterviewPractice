package com.example.interviewpractice.ui.fragment.childFragment;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.adapter.adapter.RankListAdapter;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.mvp.homepage.presenter.RankListPresenterImp;
import com.example.interviewpractice.mvp.homepage.view.RankListView;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.interviewpractice.MyApplication.getContext;


public class AuthorDetailFragment extends BaseFragment implements RankListView{
    private static final String TAG = "AuthorDetailFragment";
    private static String[] path = {"date", "mostPopular"};
    public static final String PATH = "args_page";
    private List<RankListBean.ItemListBean> itemListBeans;
    private HomeRecyclervAdapter homeRecyclervAdapter;
    private String part;
    @BindView(R.id.select_recycler)
    EasyRecyclerView easyrecycler;
    private RankListPresenterImp rankListPresenterImp = new RankListPresenterImp(this, getContext());
    public static AuthorDetailFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putString(PATH, path[position]);
        AuthorDetailFragment fragment = new AuthorDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        part = getArguments().getString(PATH);
        homeRecyclervAdapter=new HomeRecyclervAdapter(getActivity());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_author_detail, container, false);
        ButterKnife.bind(this, view);
        rankListPresenterImp.loadListAuthor(part,"2170",0,10);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        easyrecycler.setAdapter(homeRecyclervAdapter);
        return view;
    }


    @Override
    public void rankSuccess(RankListBean rData) {
        Log.e(TAG, "**************** "+rData.getItemList().size() );
        itemListBeans = rData.getItemList();
        homeRecyclervAdapter.addAll(itemListBeans);
    }

    @Override
    public void selectSuccess(RankListBean sData) {

    }
}
