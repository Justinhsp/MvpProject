package com.hui.example.yizhi.model;

import android.os.Bundle;

import com.hui.example.yizhi.api.GankApi;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.bean.GankDayBean;
import com.hui.example.yizhi.bean.GankDayItemBean;
import com.hui.example.yizhi.contract.GankDayContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GankDayModel extends BaseModel implements GankDayContract.GankDayModel {

    private GankDayBean mGankDayBean;

    public static GankDayModel newInstance() {
        return new GankDayModel();
    }


    @Override
    public Observable<List<GankDayItemBean>> getGankDayList(String year, String month, String day) {
        return RetrofitCreateHelper.createApi(GankApi.class,GankApi.BASE_URL)
                .getGankDay(year,month,day).map(new Function<GankDayBean, List<GankDayItemBean>>() {
                    @Override
                    public List<GankDayItemBean> apply(GankDayBean gankDayBean) throws Exception {
                        mGankDayBean=gankDayBean;
                        List<GankDayItemBean> list=new ArrayList<>();
                        //增加item类型
                        GankDayItemBean itemAndroidBean = gankDayBean.getResults().getAndroid().get(0);
                        GankDayItemBean itemIOSBean = gankDayBean.getResults().getiOS().get(0);
                        GankDayItemBean itemFrontBean = gankDayBean.getResults().getFront().get(0);
                        GankDayItemBean itemWelfareBean = gankDayBean.getResults().getWelfare().get(0);
                        GankDayItemBean itemRestMovieBean = gankDayBean.getResults().getRestMovie().get(0);
                        itemAndroidBean.itemType = GankDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
                        itemIOSBean.itemType = GankDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
                        itemFrontBean.itemType = GankDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL;
                        itemWelfareBean.itemType = GankDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL;
                        itemRestMovieBean.itemType = GankDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL;
                        list.add(itemAndroidBean);
                        list.add(itemIOSBean);
                        list.add(itemFrontBean);
                        list.add(itemWelfareBean);
                        list.add(itemRestMovieBean);
                        return list;
                    }
                }).compose(RxHelper.rxSchedulerHelper());
    }

    @Override
    public GankDayItemBean getGankDayAndroid(int page) {
        if (mGankDayBean==null)
        return null;
        GankDayItemBean bean = mGankDayBean.getResults().getAndroid().get(page);
        bean.itemType = GankDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
        return bean;
    }

    @Override
    public GankDayItemBean getGankDayIos(int page) {
        if (mGankDayBean == null)
            return null;
        GankDayItemBean bean = mGankDayBean.getResults().getiOS().get(page);
        bean.itemType = GankDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
        return bean;
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        return null;
    }
}
