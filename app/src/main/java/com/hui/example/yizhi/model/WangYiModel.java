package com.hui.example.yizhi.model;

import com.hui.example.yizhi.api.WangYiApi;
import com.hui.example.yizhi.bean.WangYiNewsListBean;
import com.hui.example.yizhi.contract.WangYiContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;

import io.reactivex.Observable;

public class WangYiModel implements WangYiContract.WangYiModel {

    public static WangYiModel newInstance() {
        return new WangYiModel();
    }

    @Override
    public Observable<WangYiNewsListBean> getNewsList(int id) {
        return RetrofitCreateHelper.createApi(WangYiApi.class,WangYiApi.BASE_URL)
                .getNewsList(id)
                .compose(RxHelper.rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        return null;
    }
}
