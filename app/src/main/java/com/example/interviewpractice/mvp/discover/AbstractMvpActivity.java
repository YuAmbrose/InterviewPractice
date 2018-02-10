package com.example.interviewpractice.mvp.discover;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 鱼握拳 on 2018/1/27.
 */

public abstract class AbstractMvpActivity<V extends IMvpBaseView, P extends AbstractMvpPersenter<V>> extends AppCompatActivity implements IMvpBaseView {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建Presenter
        if (presenter == null) {
            presenter = createPresenter();
        }

        if (presenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        //绑定view
        presenter.attachMvpView((V) this);
    }

    @Override
    protected void onDestroy() {
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