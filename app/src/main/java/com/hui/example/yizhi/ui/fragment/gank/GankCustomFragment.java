package com.hui.example.yizhi.ui.fragment.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.GankCustomAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.bean.GankCustomItemBean;
import com.hui.example.yizhi.contract.GankCustomContract;
import com.hui.example.yizhi.presenter.GankCustomPresenter;
import com.hui.example.yizhi.utils.ResourcesUtils;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class GankCustomFragment extends BaseRecycleFragment<GankCustomContract.GankCustomPresenter> implements GankCustomContract.GankCustomView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_gank_custom)
    RecyclerView rvGankCustom;

    private View headView;
    private String mCustomType = "all";
    private GankCustomAdapter mGankIoCustomAdapter;


    public static GankCustomFragment newInstance() {
        Bundle args = new Bundle();
        GankCustomFragment fragment = new GankCustomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_custom;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mGankIoCustomAdapter = new GankCustomAdapter(null);
        rvGankCustom.setAdapter(mGankIoCustomAdapter);
        rvGankCustom.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList();
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return GankCustomPresenter.newInstance();
    }

    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
         mGankIoCustomAdapter.setEmptyView(loadingView);
    }

    @Override
    public String getCustomType() {
        return mCustomType;
    }

    @Override
    public void refeshCustomList(List<GankCustomItemBean> list) {

    }

    @Override
    public void updateContentList(List<GankCustomItemBean> list) {
             if (mGankIoCustomAdapter.getData().size()==0){
                 initRecycleView(list);
             }else {
                 mGankIoCustomAdapter.addData(list);
             }
    }


    private void initRecycleView(List<GankCustomItemBean> list) {
        mGankIoCustomAdapter=new GankCustomAdapter(list);
        initHeadView();
        mGankIoCustomAdapter.addHeaderView(headView);
        rvGankCustom.setAdapter(mGankIoCustomAdapter);
        mGankIoCustomAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("详情");
            }
        });
        mGankIoCustomAdapter.setOnLoadMoreListener(this,rvGankCustom);
    }


    @Override
    public void onLoadMoreRequested() {
         mGankIoCustomAdapter.loadMoreComplete();
         mPresenter.loadMoreList();
    }

    private void initHeadView() {
        if (headView==null){
            headView=ResourcesUtils.inflate(R.layout.sub_gank_custom_head);
        }
        final TextView tvHeadName = (TextView) headView.findViewById(R.id.tv_type_name);
      /*  headView.findViewById(R.id.ll_choose_catalogue).setOnClickListener(new
                CatalogueClickListenerImp(tvHeadName));*/
        if (mCustomType.equals("all")) {
            tvHeadName.setText("全部");
        } else {
            tvHeadName.setText(mCustomType);
        }

    }

    @Override
    public void itemNotifyChanged(int position) {
         mGankIoCustomAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetWorkError() {
           mGankIoCustomAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mGankIoCustomAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
          mGankIoCustomAdapter.loadMoreEnd(false);
    }


}
