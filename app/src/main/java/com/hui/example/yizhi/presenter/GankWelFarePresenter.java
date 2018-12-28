package com.hui.example.yizhi.presenter;
import com.hui.example.yizhi.bean.GankWelFareItemBean;
import com.hui.example.yizhi.bean.GankWelFareListBean;
import com.hui.example.yizhi.contract.GankWelFareContract;
import com.hui.example.yizhi.model.GankWelFareModel;

import io.reactivex.functions.Consumer;

public class GankWelFarePresenter extends GankWelFareContract.GankWelFarePresenter {

    private int mCurrentPage;
    private boolean isLoading;

    public static GankWelFarePresenter newInstance() {
        return new GankWelFarePresenter();
    }

    @Override
    public void loadLatestList() {
             if (mIModel==null || mIView==null)
                 return;
             mCurrentPage=1;
             mRxManager.register(mIModel.getWelfareList(20,mCurrentPage).subscribe(new Consumer<GankWelFareListBean>() {
                 @Override
                 public void accept(GankWelFareListBean gankWelFareListBean) throws Exception {
                     if (mIView == null)
                         return;
                     if (gankWelFareListBean.isError()) {
                         mIView.showNetWorkError();
                     } else {
                         mCurrentPage++;
                         mIView.updateContentList(gankWelFareListBean.getResults());
                     }
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
                 mRxManager.register(mIModel.getWelfareList(20,mCurrentPage).subscribe(new Consumer<GankWelFareListBean>() {
                     @Override
                     public void accept(GankWelFareListBean gankWelFareListBean) throws Exception {
                         isLoading = false;
                         if (mIView == null)
                             return;
                         if (gankWelFareListBean.isError()) {
                             mIView.showNetWorkError();
                         } else {
                             if (gankWelFareListBean.getResults().size() > 0) {
                                 mCurrentPage++;
                                 mIView.updateContentList(gankWelFareListBean.getResults());
                             } else {
                                 mIView.showNoMoreData();
                             }
                         }
                     }
                 }, new Consumer<Throwable>() {
                     @Override
                     public void accept(Throwable throwable) throws Exception {
                         isLoading=false;
                         if (mIView!=null){
                             mIView.showLoadMoreError();
                         }
                     }
                 }));
             }
    }

    @Override
    public void OnItemClick(int position, GankWelFareItemBean item) {

    }

    @Override
    protected GankWelFareContract.GankWelFareModel getModel() {
        return GankWelFareModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
