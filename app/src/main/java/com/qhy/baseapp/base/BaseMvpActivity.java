package com.qhy.baseapp.base;

/**
 * Created by qhy on 2020/10/22 18:03
 * Description: MVP基类 - 封装了Presenter的相关操作
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter> extends BaseActivity {


    private P presenter;

    /**
     * 初始化presenter
     */
    @Override
    protected void initPresenter() {
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    /**
     * 创建presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();

    /**
     * 得到presenter
     *
     * @return presenter
     */
    protected P getPresenter() {
        return presenter;
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }


}
