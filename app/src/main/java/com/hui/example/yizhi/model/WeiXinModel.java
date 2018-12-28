package com.hui.example.yizhi.model;
import com.hui.example.yizhi.api.WeiXinApi;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.bean.WeixinChoiceListBean;
import com.hui.example.yizhi.contract.WeiXinContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;

import io.reactivex.Observable;

public class WeiXinModel extends BaseModel implements WeiXinContract.WeiXinModel {

    public static WeiXinModel newInstance() {
        return new WeiXinModel();
    }

    @Override
    public Observable<WeixinChoiceListBean> getWeiXinChoiceList(int page, int pageStrip, String dttype, String key) {
        return RetrofitCreateHelper.createApi(WeiXinApi.class,WeiXinApi.BASE_URL)
                .getWeixinChoiceList(page,pageStrip,dttype,key)
                .compose(RxHelper.rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        return null;
    }
}
