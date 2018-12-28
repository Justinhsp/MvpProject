package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseTabsContract;
import com.hui.example.yizhi.bean.WangYiNewsListBean;
import com.hui.example.yizhi.bean.WangyiNewsItemBean;

import io.reactivex.Observable;

public interface WangYiContract {

    abstract class WangYiPresenter extends BaseTabsContract.BaseTabsPresenter<WangYiModel,WangYiView,WangyiNewsItemBean>{

    }

    interface WangYiModel extends BaseTabsContract.BaseTabsModel{
         //获取网易新闻list
        Observable<WangYiNewsListBean> getNewsList(int id);
    }

    interface WangYiView extends BaseTabsContract.BaseTabsView<WangyiNewsItemBean>{

    }

}
