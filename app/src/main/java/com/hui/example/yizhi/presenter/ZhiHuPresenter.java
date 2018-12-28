package com.hui.example.yizhi.presenter;
import com.hui.example.yizhi.bean.ZhihuDailyItemBean;
import com.hui.example.yizhi.bean.ZhihuDailyListBean;
import com.hui.example.yizhi.contract.ZhiHuContract;
import com.hui.example.yizhi.model.ZhiHuModel;

import io.reactivex.functions.Consumer;

public class ZhiHuPresenter extends ZhiHuContract.ZhiHuPresenter {

    public static ZhiHuPresenter newInstance() {
        return new ZhiHuPresenter();
    }

    //日期
    private String date;


    @Override
    public void loadLatestList() {
        if (mIModel==null || mIView==null)
            return;
        mRxManager.register(mIModel.getDailyList().subscribe(new Consumer<ZhihuDailyListBean>() {
            @Override
            public void accept(ZhihuDailyListBean zhihuDailyListBean) throws Exception {
                date = zhihuDailyListBean.getDate();
                if (mIView != null) {
                    mIView.updateContentList(zhihuDailyListBean.getStories());
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
       if (mIModel==null)
           return;
       mRxManager.register(mIModel.getDailyList(date).subscribe(new Consumer<ZhihuDailyListBean>() {
           @Override
           public void accept(ZhihuDailyListBean zhihuDailyListBean) throws Exception {
               if (date.equals(zhihuDailyListBean.getDate()))
                   return;
               date = zhihuDailyListBean.getDate();
               if (mIView != null) {
                   mIView.updateContentList(zhihuDailyListBean.getStories());
               }
           }
       }, new Consumer<Throwable>() {
           @Override
           public void accept(Throwable throwable) throws Exception {
               if (mIView!=null){
                   mIView.showLoadMoreError();
               }
           }
       }));
    }

    @Override
    public void OnItemClick(int position, ZhihuDailyItemBean item) {

    }

    @Override
    protected ZhiHuContract.ZhiHuModel getModel() {
        return ZhiHuModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
