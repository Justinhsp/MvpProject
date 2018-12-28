package com.hui.example.yizhi.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.WeiXinAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.contract.WeiXinContract;
import com.hui.example.yizhi.presenter.WeiXinPresenter;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class WeiXinFragment extends BaseRecycleFragment<WeiXinContract.WeiXinPresenter> implements WeiXinContract.WeiXinView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_weixin)
    RecyclerView rvWeiXin;

    WeiXinAdapter mWeiXinAdapter;

    public static WeiXinFragment newInstance() {
        Bundle args = new Bundle();
        WeiXinFragment fragment = new WeiXinFragment();
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
        return R.layout.fragment_home_weixin;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mWeiXinAdapter = new WeiXinAdapter(R.layout.item_recycle_home);
        rvWeiXin.setAdapter(mWeiXinAdapter);
        rvWeiXin.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return WeiXinPresenter.newInstance();
    }


    @Override
    protected void onErrorViewClick(View view) {
         mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
       mWeiXinAdapter.setEmptyView(loadingView);
    }

    @Override
    public void updateContentList(List list) {
         if (mWeiXinAdapter.getData().size()==0){
             initRecycleView(list);
         }else {
             mWeiXinAdapter.addData(list);
         }
    }

    private void initRecycleView(List list) {
        mWeiXinAdapter=new WeiXinAdapter(R.layout.item_recycle_home,list);
        rvWeiXin.setAdapter(mWeiXinAdapter);
        mWeiXinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("去详情");
            }
        });
        mWeiXinAdapter.setOnLoadMoreListener(this,rvWeiXin);
    }


    @Override
    public void onLoadMoreRequested() {
         mWeiXinAdapter.loadMoreComplete();
         mPresenter.loadMoreList();
    }


    @Override
    public void itemNotifyChanged(int position) {
       mWeiXinAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetWorkError() {
          mWeiXinAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
         mWeiXinAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
          mWeiXinAdapter.loadMoreEnd(false);
    }

}
