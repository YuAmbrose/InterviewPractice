package com.example.interviewpractice.v_layout.holder.EyDetail;

import android.view.View;

import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.v_layout.VlayoutBaseHolder;
import com.example.interviewpractice.weight.JzPlayer;
import com.jude.easyrecyclerview.EasyRecyclerView;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 鱼握拳 on 2018/2/17.
 */

public class JzPlayerHolder extends VlayoutBaseHolder<EyDetailBean> {
    @BindView(R.id.player)
    JZVideoPlayerStandard jzPlayer;
    public JzPlayerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, EyDetailBean eData) {
        super.setData(ps, eData);
        jzPlayer.setUp(eData.getPlayUrl(),jzPlayer.SCREEN_WINDOW_NORMAL,"");
    }
}
