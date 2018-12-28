package com.hui.example.yizhi.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.WangYiAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.bean.WangyiNewsItemBean;
import com.hui.example.yizhi.contract.WangYiContract;
import com.hui.example.yizhi.presenter.WangYiPresenter;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class WangYiFragment extends BaseRecycleFragment<WangYiContract.WangYiPresenter> implements WangYiContract.WangYiView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_wangyi)
    RecyclerView rvWangyi;

    WangYiAdapter mWangYiAdapter;

    public static WangYiFragment newInstance() {
        Bundle args = new Bundle();
        WangYiFragment fragment = new WangYiFragment();
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
        return R.layout.fragment_home_wangyi;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mWangYiAdapter = new WangYiAdapter(R.layout.item_recycle_home);
        rvWangyi.setAdapter(mWangYiAdapter);
        rvWangyi.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return WangYiPresenter.newInstance();
    }

    @Override
    protected void onErrorViewClick(View view) {
         mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
         mWangYiAdapter.setEmptyView(loadingView);
    }

    @Override
    public void updateContentList(List<WangyiNewsItemBean> list) {
        if (mWangYiAdapter.getData().size()==0){
            initRecycleView(list);
        }else {
            mWangYiAdapter.addData(list);
        }
    }


    private void initRecycleView(List<WangyiNewsItemBean> list) {
        mWangYiAdapter=new WangYiAdapter(R.layout.item_recycle_home,list);
        rvWangyi.setAdapter(mWangYiAdapter);
        mWangYiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("去详情");
            }
        });
        mWangYiAdapter.setOnLoadMoreListener(this,rvWangyi);
    }

    @Override
    public void onLoadMoreRequested() {
        //这里loadMoreComplete要放在前面，避免在Presenter.loadMoreNewsList处理中直接showNoMoreData，出现无限显示加载item
        mWangYiAdapter.loadMoreComplete();
        mPresenter.loadMoreList();
    }

    @Override
    public void itemNotifyChanged(int position) {
        mWangYiAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetWorkError() {
       mWangYiAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
         mWangYiAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
          mWangYiAdapter.loadMoreEnd(false);
    }


}
