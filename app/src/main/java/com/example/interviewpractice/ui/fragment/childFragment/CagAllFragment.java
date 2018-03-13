package com.example.interviewpractice.ui.fragment.childFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.rxbus.MessageEvent;
import com.example.interviewpractice.utils.rxbus.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;


public class CagAllFragment extends BaseFragment {


    @BindView(R.id.textview)
    TextView textview;
    private static final String TAG = "CagAllFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cag_all, container, false);
        ButterKnife.bind(this, view);
        RxBus.getInstance().register(MessageEvent.class).subscribe(new Consumer<MessageEvent>() {
            @Override
            public void accept(MessageEvent messageEvent) throws Exception {
                Toast.makeText(MyApplication.getContext(), messageEvent.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "accept:顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶 "+messageEvent.getMessage());
                textview.setText(messageEvent.getMessage());
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
