package com.example.interviewpractice.ui.fragment.childFragment;

import android.annotation.SuppressLint;
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

@SuppressLint("ValidFragment")
public class CagAllFragment extends BaseFragment {


    @BindView(R.id.textview)
    TextView textview;
    private String cos;
    private static final String TAG = "CagAllFragment";
    @SuppressLint("ValidFragment")
    public CagAllFragment(String id) {
        super();
        cos=id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cag_all, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
