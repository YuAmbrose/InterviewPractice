package com.example.interviewpractice.v_layout.holder.EyDetail;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.interviewpractice.R;
import com.example.interviewpractice.adapter.adapter.HomeRecyclervAdapter;
import com.example.interviewpractice.adapter.adapter.ReplyAdapter;
import com.example.interviewpractice.enity.EyReplyBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.interviewpractice.MyApplication.getContext;

/**
 * Created by 鱼握拳 on 2018/3/10.
 */

public class ReplyHolder extends VlayoutBaseHolder<EyReplyBean> {
    @BindView(R.id.recycleview)
    EasyRecyclerView easyrecycler;
    @BindView(R.id.title)
    TextView textView;
    private ReplyAdapter replyAdapter;
    private List<EyReplyBean.ReplyListBean> replyListBeans;
    public ReplyHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, EyReplyBean cData) {
        super.setData(ps, cData);
        if (cData.getReplyList().size()==0){
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
       replyAdapter=new ReplyAdapter(getContext());
        easyrecycler.setAdapter(replyAdapter);
        replyListBeans = cData.getReplyList();
        replyAdapter.addAll(replyListBeans);
//        replyAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                mListener.onItemClick(mView, position, mData);
//            }
//        });
    }
}
