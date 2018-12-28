package com.hui.example.yizhi.presenter;

import android.os.Bundle;

import com.hui.example.yizhi.bean.WangYiNewsListBean;
import com.hui.example.yizhi.bean.WangyiNewsItemBean;
import com.hui.example.yizhi.contract.WangYiContract;
import com.hui.example.yizhi.model.WangYiModel;
import com.hui.example.yizhi.utils.StringUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

public class WangYiPresenter extends WangYiContract.WangYiPresenter {


    private int mCurrentIndex;
    private boolean isLoading;

    public static WangYiPresenter newInstance() {
        return new WangYiPresenter();
    }


    @Override
    public void loadLatestList() {
         mCurrentIndex=0;
         mRxManager.register(mIModel.getNewsList(mCurrentIndex).subscribe(new Consumer<WangYiNewsListBean>() {
             @Override
             public void accept(WangYiNewsListBean wangYiNewsListBean) throws Exception {
                 if (mIView == null || mIModel == null)
                     return;
                 List<WangyiNewsItemBean> list = wangYiNewsListBean.getNewsList();
                 for (int i = 0; i < list.size(); i++) {
                     //过滤掉无效新闻
                     if (StringUtils.isEmpty(list.get(i).getUrl()))
                         list.remove(i);
                 }
                 mCurrentIndex += 20;
                 mIView.updateContentList(list);
             }
         }, new Consumer<Throwable>() {
             @Override
             public void accept(Throwable throwable) throws Exception {
                 if (mIView!=null){
                     if (mIView.isVisiable())
                         mIView.showToast("NetWork Error!");
                        mIView.showNetWorkError();
                 }
             }
         }));
    }

    @Override
    public void loadMoreList() {
          if (!isLoading){
              isLoading=true;
              mRxManager.register(mIModel.getNewsList(mCurrentIndex).subscribe(new Consumer<WangYiNewsListBean>() {
                  @Override
                  public void accept(WangYiNewsListBean wangYiNewsListBean) throws Exception {
                      isLoading = false;
                      if (mIView == null)
                          return;
                      if (wangYiNewsListBean.getNewsList().size() > 0) {
                          mCurrentIndex += 20;
                          mIView.updateContentList(wangYiNewsListBean.getNewsList());
                      } else {
                          mIView.showNoMoreData();
                      }
                  }
              }, new Consumer<Throwable>() {
                  @Override
                  public void accept(Throwable throwable) throws Exception {
                      isLoading=false;
                      if (mIView==null)
                          return;
                      mIView.showLoadMoreError();
                  }
              }));
          }
    }

    @Override
    public void OnItemClick(int position, WangyiNewsItemBean item) {

    }

    @Override
    protected WangYiContract.WangYiModel getModel() {
        return WangYiModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
