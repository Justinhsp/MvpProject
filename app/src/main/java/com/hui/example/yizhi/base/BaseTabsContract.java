package com.hui.example.yizhi.base;

import java.util.List;

import io.reactivex.Observable;

public interface BaseTabsContract {

    abstract class BaseTabsPresenter<M extends BaseTabsModel,V extends BaseTabsView,T> extends BasePresenter<M,V>{
        //加载最新List
        public abstract void loadLatestList();
        //加载更多List
        public abstract void loadMoreList();
        //Item点击事件
        public abstract void OnItemClick(int position,T item);
    }

    interface BaseTabsModel extends IBaseModel{
        /**
         * 记录Item已阅到数据库
         * @param key  item.it 作为key 值
         */
        Observable<Boolean> recordItemIsRead(String key);
    }

    interface BaseTabsView<L> extends BaseFragment{
        //更新界面List
        void updateContentList(List<L> list);
        //点击事件 刷新item
        void itemNotifyChanged(int position);
        //显示网络错误
        void showNetWorkError();
        //显示加载更多错误
        void showLoadMoreError();
        //显示没有更多数据
        void showNoMoreData();
    }
}
