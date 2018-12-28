package com.hui.example.yizhi.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.ZhuHuAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.bean.ZhihuDailyItemBean;
import com.hui.example.yizhi.contract.ZhiHuContract;
import com.hui.example.yizhi.presenter.ZhiHuPresenter;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class ZhiHuFragment extends BaseRecycleFragment<ZhiHuContract.ZhiHuPresenter> implements ZhiHuContract.ZhiHuView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_zhihu)
    RecyclerView rvZhiHu;

    ZhuHuAdapter mZhuHuAdapter;


    public static ZhiHuFragment newInstance() {
        Bundle args = new Bundle();
        ZhiHuFragment fragment = new ZhiHuFragment();
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
        return R.layout.fragment_home_zhihu;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mZhuHuAdapter = new ZhuHuAdapter(R.layout.item_recycle_home);
        rvZhiHu.setAdapter(mZhuHuAdapter);
        rvZhiHu.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return ZhiHuPresenter.newInstance();
    }


    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
        mZhuHuAdapter.setEmptyView(loadingView);
    }

    @Override
    public void updateContentList(List<ZhihuDailyItemBean> list) {
        if (mZhuHuAdapter.getData().size() == 0) {
            initRecycleView(list);
        } else {
            mZhuHuAdapter.addData(list);
        }
    }


    private void initRecycleView(List<ZhihuDailyItemBean> list) {
        mZhuHuAdapter=new ZhuHuAdapter(R.layout.item_recycle_home,list);
        rvZhiHu.setAdapter(mZhuHuAdapter);
        mZhuHuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("详情");
            }
        });
        mZhuHuAdapter.setOnLoadMoreListener(this,rvZhiHu);
    }

    @Override
    public void onLoadMoreRequested() {
          mZhuHuAdapter.loadMoreComplete();
          mPresenter.loadMoreList();
    }


    @Override
    public void itemNotifyChanged(int position) {
        mZhuHuAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetWorkError() {
        mZhuHuAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mZhuHuAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
        mZhuHuAdapter.loadMoreEnd(false);
    }


}
