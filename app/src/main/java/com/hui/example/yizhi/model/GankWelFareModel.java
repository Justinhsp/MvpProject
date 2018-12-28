package com.hui.example.yizhi.model;

import com.hui.example.yizhi.api.GankApi;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.contract.GankWelFareContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;
import com.hui.example.yizhi.bean.GankWelFareListBean;

import io.reactivex.Observable;

public class GankWelFareModel extends BaseModel implements GankWelFareContract.GankWelFareModel {

    public static GankWelFareModel newInstance() {
        return new GankWelFareModel();
    }

    @Override
    public Observable<GankWelFareListBean> getWelfareList(int pre_page, int page) {
        return RetrofitCreateHelper.createApi(GankApi.class,GankApi.BASE_URL)
                .getGankWelFareLsit(pre_page,page).compose(RxHelper.rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        //图片不记录  已读
        return null;
    }
}
