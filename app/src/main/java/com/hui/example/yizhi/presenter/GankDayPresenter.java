package com.hui.example.yizhi.presenter;
import com.hui.example.yizhi.bean.GankDayItemBean;
import com.hui.example.yizhi.contract.GankDayContract;
import com.hui.example.yizhi.model.GankDayModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

public class GankDayPresenter extends GankDayContract.GankDayPresenter {

    private String mYear = "2016";
    private String mMonth = "11";
    private String mDay = "24";
    private int mAndroidPages = 0;
    private int mIOSPages = 0;
    private List<GankDayItemBean> mList = new ArrayList<>();

    public static GankDayPresenter newInstance() {
       return new GankDayPresenter();
    }



    @Override
    public void loadLatestList() {
            if (mIModel==null || mIView==null)
                return;
        //GankIo每日数据大部分时间返回空值，这里直接写死一个日期数据
        mRxManager.register(mIModel.getGankDayList(mYear,mMonth,mDay).subscribe(new Consumer<List<GankDayItemBean>>() {
            @Override
            public void accept(List<GankDayItemBean> gankDayItemBeans) throws Exception {
                if (mIView == null)
                    return;
                mList = gankDayItemBeans;
                mIView.updateContentList(mList);
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
    public void onMoreClick(int position, GankDayItemBean item) {

    }

    @Override
    public void onRefreshClick(int position, GankDayItemBean item) {
             if (mIModel==null || mIView==null)
                 return;
             if (item.getType().equals("Android")){
                 mAndroidPages++;
                 mIView.itemNotiftyChanged(position,mIModel.getGankDayAndroid(mAndroidPages%6));
             }else {
                 mIOSPages++;
                 mIView.itemNotiftyChanged(position, mIModel.getGankDayIos(mIOSPages%3));
             }
    }


    @Override
    public void loadMoreList() {
           //每日数据没有更多
    }

    @Override
    public void OnItemClick(int position, GankDayItemBean item) {

    }

    @Override
    protected GankDayContract.GankDayModel getModel() {
        return GankDayModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
