package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseTabsContract;
import com.hui.example.yizhi.bean.GankWelFareItemBean;
import com.hui.example.yizhi.bean.GankWelFareListBean;

import io.reactivex.Observable;

public interface GankWelFareContract {

    abstract class GankWelFarePresenter extends BaseTabsContract.BaseTabsPresenter<GankWelFareModel,GankWelFareView,GankWelFareItemBean>{

    }

    interface GankWelFareModel extends BaseTabsContract.BaseTabsModel{
        //获取福利List
        Observable<GankWelFareListBean> getWelfareList(int pre_page, int page);
    }


    interface GankWelFareView extends BaseTabsContract.BaseTabsView<GankWelFareItemBean>{

    }

}
