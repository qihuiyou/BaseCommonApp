package com.qhy.baseapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.qhy.baseapp.R;

import butterknife.ButterKnife;

/**
 * Created by qhy on 2020/10/22 17:38
 * Description: Activity基类 - 抽取公用的方法，减少耦合等操作
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(getLayoutId());
        initPresenter();
        initViews();
        ButterKnife.bind(this);
    }


    /**
     * 抽象方法：实例化Presenter
     */
    protected abstract void initPresenter();

    /**
     * 抽象方法：初始化控件，一般在BaseActivity中通过ButterKnife来绑定，所以该方法内部一般我们初始化界面相关的操作
     *
     * @return 控件
     */
    protected abstract void initViews();

    /**
     * 抽象方法：得到布局id
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 启动Fragment
     *
     * @param id       id
     * @param fragment 碎片
     */
    protected void startFragment(int id, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(id, fragment);
        fragmentTransaction.commit();
    }


}
