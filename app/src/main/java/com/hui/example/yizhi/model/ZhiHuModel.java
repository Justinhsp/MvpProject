package com.hui.example.yizhi.model;

import android.os.Bundle;

import com.hui.example.yizhi.api.ZhiHuApi;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.bean.ZhihuDailyListBean;
import com.hui.example.yizhi.contract.ZhiHuContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;

import io.reactivex.Observable;

public class ZhiHuModel extends BaseModel implements ZhiHuContract.ZhiHuModel {

    public static ZhiHuModel newInstance() {
        return new ZhiHuModel();
    }


    @Override
    public Observable<ZhihuDailyListBean> getDailyList(String data) {
        return RetrofitCreateHelper.createApi(ZhiHuApi.class,ZhiHuApi.BASE_URL)
                .getDailyWithDate(data).compose(RxHelper.rxSchedulerHelper());
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList() {
        return RetrofitCreateHelper.createApi(ZhiHuApi.class,ZhiHuApi.BASE_URL)
                .getLastDailyList().compose(RxHelper.rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        return null;
    }
}
