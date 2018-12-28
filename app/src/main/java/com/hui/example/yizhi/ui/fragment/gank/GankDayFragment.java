package com.hui.example.yizhi.ui.fragment.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.GankDayAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.bean.GankDayItemBean;
import com.hui.example.yizhi.contract.GankDayContract;
import com.hui.example.yizhi.presenter.GankDayPresenter;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class GankDayFragment extends BaseRecycleFragment<GankDayContract.GankDayPresenter> implements GankDayContract.GankDayView {

    @BindView(R.id.rv_gank_day)
    RecyclerView rvGankday;

    GankDayAdapter mGankDayAdapter;

    public static GankDayFragment newInstance() {
        Bundle args = new Bundle();
        GankDayFragment fragment = new GankDayFragment();
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
        return R.layout.fragment_gank_day;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mGankDayAdapter = new GankDayAdapter(null);
        rvGankday.setAdapter(mGankDayAdapter);
        rvGankday.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return GankDayPresenter.newInstance();
    }


    @Override
    protected void onErrorViewClick(View view) {
         mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
          mGankDayAdapter.setEmptyView(loadingView);
    }


    @Override
    public void itemNotiftyChanged(int position, GankDayItemBean item) {
           mGankDayAdapter.refeshItem(position,item);
    }

    @Override
    public void updateContentList(List<GankDayItemBean> list) {
        if (mGankDayAdapter.getData().size()==0){
            initRecycleView(list);
        }else {
            mGankDayAdapter.addData(list);
        }
    }


    private void initRecycleView(List<GankDayItemBean> list) {
        mGankDayAdapter=new GankDayAdapter(list);
         rvGankday.setAdapter(mGankDayAdapter);
         mGankDayAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
             @Override
             public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                 ToastUtils.showToast("详情预留");
             }
         });

         mGankDayAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
             @Override
             public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                 switch (view.getId()) {
                     case R.id.ll_more:
                      /*   mPresenter.onMoreClick(position, (GankDayItemBean) adapter.getItem
                                 (position));*/
                         break;
                     case R.id.ll_refesh:
                         mPresenter.onRefreshClick(position, (GankDayItemBean) adapter.getItem
                                 (position));
                         break;
                 }
             }
         });
    }

    @Override
    public void itemNotifyChanged(int position) {
          mGankDayAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetWorkError() {
          mGankDayAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
          mGankDayAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
          mGankDayAdapter.loadMoreEnd(false);
    }
}
