package com.example.interviewpractice.mvp.EyDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewpractice.ui.baseView.BaseFragment;

/**
 * Created by 鱼握拳 on 2018/3/13.
 */

public abstract class AbstractMvpFragment <V extends IMvpBaseView, P extends AbstractMvpPersenter<V>> extends BaseFragment implements IMvpBaseView {

    private P presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (presenter == null) {
            presenter = createPresenter();
        }

        if (presenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        //绑定view
        presenter.attachMvpView((V) this);
    }

    @Nullable

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解除绑定
        if (presenter != null) {
            presenter.detachMvpView();
        }
    }

    /**
     * 创建Presenter
     * @return 子类自己需要的Presenter
     */
    protected abstract P createPresenter();

    /**
     * 获取Presenter
     * @return 返回子类创建的Presenter
     */
    public P getPresenter() {
        return presenter;
    }
}
