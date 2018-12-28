package com.hui.example.yizhi.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hui.example.yizhi.R;

public abstract class BaseRecycleFragment<P extends BasePresenter> extends BaseMVPCompatFragment<P> {
    //加载失败View
    protected View errorView;
    //加载中View 
    protected View loadingView;
    //空View
    protected View emptyView;


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        showLoading();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        errorView = inflater.inflate(R.layout.view_network_error, container, false);
        loadingView = inflater.inflate(R.layout.view_loading, container, false);
        emptyView = inflater.inflate(R.layout.viw_empty, container, false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoading();
                onErrorViewClick(view);
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    /**
     * 网络异常时view 被点击时触发  由子类实现
     * @param view
     */
    protected abstract void onErrorViewClick(View view);

    /**
     * 显示加载中View
     */
    protected abstract void showLoading();

}
