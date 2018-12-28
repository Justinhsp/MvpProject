package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseTabsContract;
import com.hui.example.yizhi.bean.GankDayItemBean;

import java.util.List;

import io.reactivex.Observable;

public interface GankDayContract {


    abstract class GankDayPresenter extends BaseTabsContract.BaseTabsPresenter<GankDayModel, GankDayView, GankDayItemBean> {
        //点击更多
        public abstract void onMoreClick(int position, GankDayItemBean item);

        //点击换一换
        public abstract void onRefreshClick(int position, GankDayItemBean item);
    }


    interface GankDayModel extends BaseTabsContract.BaseTabsModel {
        //请求Gankio 每日数据
        Observable<List<GankDayItemBean>> getGankDayList(String year, String month, String day);

        //获取指定page Android数据
        GankDayItemBean getGankDayAndroid(int page);

        //获取指定Page IOS数据
        GankDayItemBean getGankDayIos(int page);
    }


    interface GankDayView extends BaseTabsContract.BaseTabsView<GankDayItemBean> {
        //点击事件后  刷新Item
        void itemNotiftyChanged(int position, GankDayItemBean item);
    }

}
