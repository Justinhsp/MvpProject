package com.hui.example.yizhi.base;

import androidx.annotation.NonNull;

/**
 * FragMent BaseView 接口
 */
public interface BaseView {

    /**
     * 初始化Presenter
     * @return
     * 此方法返回的Presenter对象不可为空
     */
    @NonNull
    BasePresenter initPresenter();

    /**
     * 显示Toast消息
     * @param msg
     */
    void showToast(String msg);


    /**
     * 显示等待dialog
     *
     * @param waitMsg 等待消息字符串
     */
    void showWaitDialog(String waitMsg);

    /**
     * 隐藏等待dialog
     */
    void hideWaitDialog();

    /**
     * 隐藏键盘
     */
    void hideKeybord();

    /**
     * 回退
     */
    void back();

}
