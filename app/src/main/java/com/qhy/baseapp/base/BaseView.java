package com.qhy.baseapp.base;

/**
 * Created by qhy on 2020/10/22 18:00
 * Description: View的基类 - 记录基本需要的操作流程
 */
public interface BaseView {

    /**
     * 显示进度框
     */
    void showProgressDialog();

    /**
     * 关闭进度框
     */
    void hideProgressDialog();

    /**
     * 出错信息的回调
     *
     * @param result 错误信息
     */
    void onError(String result);


}
