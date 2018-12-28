package com.hui.example.yizhi.presenter;

import com.hui.example.yizhi.bean.GankCustomItemBean;
import com.hui.example.yizhi.bean.GankCustomListBean;
import com.hui.example.yizhi.contract.GankCustomContract;
import com.hui.example.yizhi.model.GankCustomModel;

import io.reactivex.functions.Consumer;

public class GankCustomPresenter extends GankCustomContract.GankCustomPresenter {

    private int mCurrentPage;
    private boolean isLoading;

    public static GankCustomPresenter newInstance() {
        return new GankCustomPresenter();
    }


    @Override
    public void customTypeChange(String type) {

    }

    @Override
    public void loadLatestList() {
          if (mIModel==null || mIView==null)
              return;
          mCurrentPage=1;
          mRxManager.register(mIModel.getCustomGankList(mIView.getCustomType(),20,mCurrentPage).subscribe(new Consumer<GankCustomListBean>() {
              @Override
              public void accept(GankCustomListBean gankCustomListBean) throws Exception {
                  if (mIView == null)
                      return;
                  if (gankCustomListBean.isError()) {
                      mIView.showNetWorkError();
                  } else {
                      mCurrentPage++;
                      mIView.updateContentList(gankCustomListBean.getResults());
                  }
              }
          }, new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) throws Exception {
                  if (mIView != null) {
                      if (mIView.isVisiable())
                          mIView.showToast("Network Error!");
                      mIView.showNetWorkError();
                  }
              }
          }));
    }

    @Override
    public void loadMoreList() {
        if (!isLoading) {
            isLoading = true;
            //一次加载20条数据
            mRxManager.register(mIModel.getCustomGankList(mIView.getCustomType(), 20,
                    mCurrentPage).subscribe(new Consumer<GankCustomListBean>() {
                @Override
                public void accept(GankCustomListBean gankIoCustomListBean) throws Exception {
                    isLoading = false;
                    if (mIView == null)
                        return;

                    if (gankIoCustomListBean.isError()) {
                        mIView.showNetWorkError();
                    } else {
                        if (gankIoCustomListBean.getResults().size() > 0) {
                            mCurrentPage++;
                            mIView.updateContentList(gankIoCustomListBean.getResults());
                        } else {
                            mIView.showNoMoreData();
                        }
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    isLoading = false;
                    if (mIView != null) {
                        mIView.showLoadMoreError();
                    }
                }
            }));
        }
    }

    @Override
    public void OnItemClick(int position, GankCustomItemBean item) {

    }

    @Override
    protected GankCustomContract.GankCustomModel getModel() {
        return GankCustomModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
