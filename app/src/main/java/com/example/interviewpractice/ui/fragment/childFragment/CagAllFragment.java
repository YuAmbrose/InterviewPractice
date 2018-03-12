package com.example.interviewpractice.ui.fragment.childFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.interviewpractice.R;
import com.example.interviewpractice.ui.baseView.BaseFragment;
import com.example.interviewpractice.utils.rxbus.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;


public class CagAllFragment extends BaseFragment {


    @BindView(R.id.textview)
    TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cag_all, container, false);
        ButterKnife.bind(this, view);
        RxBus.getInstance().register(String.class).subscribe(new Consumer<String>() {
            @Override
            public void accept(String integ) throws Exception {
                textview.setText(integ);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
