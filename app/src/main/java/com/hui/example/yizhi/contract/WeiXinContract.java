package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseTabsContract;
import com.hui.example.yizhi.bean.WeixinChoiceItemBean;
import com.hui.example.yizhi.bean.WeixinChoiceListBean;

import io.reactivex.Observable;

public interface WeiXinContract {

    abstract class WeiXinPresenter extends BaseTabsContract.BaseTabsPresenter<WeiXinModel,WeiXinView,WeixinChoiceItemBean>{

    }

    interface WeiXinModel extends BaseTabsContract.BaseTabsModel{
        /**
         * 获取微信精选
         *
         * @param page      指定微信精选页数->空的话默认1
         * @param pageStrip 每页显示条数->空的话默认20条
         * @param dttype    返回数据的格式,xml或json，空的话->默认json
         * @param key       聚合key
         * @return Observable
         */
        Observable<WeixinChoiceListBean> getWeiXinChoiceList(int page,int pageStrip,String dttype,String key);
    }


    interface WeiXinView extends BaseTabsContract.BaseTabsView{

    }

}
