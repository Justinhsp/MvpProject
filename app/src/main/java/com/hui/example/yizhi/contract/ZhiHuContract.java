package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseTabsContract;
import com.hui.example.yizhi.bean.ZhihuDailyItemBean;
import com.hui.example.yizhi.bean.ZhihuDailyListBean;

import io.reactivex.Observable;

public interface ZhiHuContract   {


    abstract class ZhiHuPresenter extends BaseTabsContract.BaseTabsPresenter<ZhiHuModel,ZhiHuView,ZhihuDailyItemBean>{

    }

    interface  ZhiHuModel extends BaseTabsContract.BaseTabsModel{
        //根据日期获取日报
         Observable<ZhihuDailyListBean> getDailyList(String data);
         //获取日报
         Observable<ZhihuDailyListBean> getDailyList();
    }


    interface ZhiHuView extends BaseTabsContract.BaseTabsView<ZhihuDailyItemBean>{

    }



}
