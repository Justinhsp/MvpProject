package com.hui.example.yizhi.ui.fragment.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.GankWelFareAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.bean.GankWelFareItemBean;
import com.hui.example.yizhi.contract.GankWelFareContract;
import com.hui.example.yizhi.presenter.GankWelFarePresenter;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class GankWelFareFragment extends BaseRecycleFragment<GankWelFareContract.GankWelFarePresenter> implements GankWelFareContract.GankWelFareView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_gankio_welfare)
    RecyclerView rvGankioWelfare;

    GankWelFareAdapter mGankWelFareAdapter;

    public static GankWelFareFragment newInstance() {
        Bundle args = new Bundle();
        GankWelFareFragment fragment = new GankWelFareFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_welfare;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        mGankWelFareAdapter = new GankWelFareAdapter(R.layout.item_gank_welfare);
        rvGankioWelfare.setAdapter(mGankWelFareAdapter);
        rvGankioWelfare.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return GankWelFarePresenter.newInstance();
    }


    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
        mGankWelFareAdapter.setEmptyView(loadingView);
    }


    @Override
    public void updateContentList(List<GankWelFareItemBean> list) {
        if (mGankWelFareAdapter.getData().size() == 0) {
            initRecycleView(list);
        } else {
            mGankWelFareAdapter.addData(list);
        }
    }

    private void initRecycleView(List<GankWelFareItemBean> list) {
        mGankWelFareAdapter = new GankWelFareAdapter(R.layout.item_gank_welfare, list);
        rvGankioWelfare.setAdapter(mGankWelFareAdapter);
        //第一个参数 表示行数或列数  第二个参数表示滑动方向 瀑布流
        rvGankioWelfare.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mGankWelFareAdapter.setOnLoadMoreListener(this,rvGankioWelfare);
        mGankWelFareAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("预览图片!");
            }
        });
    }

    @Override
    public void itemNotifyChanged(int position) {
        mGankWelFareAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetWorkError() {
        mGankWelFareAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mGankWelFareAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
        mGankWelFareAdapter.loadMoreEnd(false);
    }

    @Override
    public void onLoadMoreRequested() {
        //这里loadMoreComplete要放在前面，避免在Presenter.loadMoreNewsList处理中直接showNoMoreData，出现无限显示加载item
        mGankWelFareAdapter.loadMoreComplete();
        mPresenter.loadMoreList();
    }
}
