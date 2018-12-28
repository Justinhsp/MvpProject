package com.hui.example.yizhi.model;
import android.text.TextUtils;

import com.hui.example.yizhi.api.GankApi;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.bean.GankCustomItemBean;
import com.hui.example.yizhi.bean.GankCustomListBean;
import com.hui.example.yizhi.contract.GankCustomContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GankCustomModel extends BaseModel implements GankCustomContract.GankCustomModel {

    public static GankCustomModel newInstance() {
        return new GankCustomModel();
    }

    @Override
    public Observable<GankCustomListBean> getCustomGankList(String type, int prePage, int page) {
        return RetrofitCreateHelper.createApi(GankApi.class,GankApi.BASE_URL)
                .getGankCustomList(type,prePage,page)
                .map(new Function<GankCustomListBean, GankCustomListBean>() {
                    @Override
                    public GankCustomListBean apply(GankCustomListBean gankCustomListBean) throws Exception {
                        for (GankCustomItemBean bean : gankCustomListBean.getResults()) {
                            if (bean.getType().equals("福利")) {
                                bean.itemType= GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_IMAGE;
                            } else if (bean.getImages() != null) {
                                if (bean.getImages().size() > 0 && !TextUtils.isEmpty(bean
                                        .getImages().get(0)))
                                    bean.itemType = GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NORMAL;
                            } else {
                                bean.itemType = GankCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NO_IMAGE;
                            }
                        }
                        return gankCustomListBean;
                    }
                })
                .compose(RxHelper.rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        return null;
    }
}
