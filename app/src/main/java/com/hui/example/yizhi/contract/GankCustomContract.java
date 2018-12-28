package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseTabsContract;
import com.hui.example.yizhi.bean.GankCustomItemBean;
import com.hui.example.yizhi.bean.GankCustomListBean;

import java.util.List;

import io.reactivex.Observable;

public interface GankCustomContract {

    abstract class GankCustomPresenter extends BaseTabsContract.BaseTabsPresenter<GankCustomModel, GankCustomView, GankCustomItemBean> {
        //类型变化
        public abstract void customTypeChange(String type);
    }

    interface GankCustomModel extends BaseTabsContract.BaseTabsModel {
        /**
         * 请求GankIo每日数据list
         *
         * @param type    type 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
         * @param prePage 请求个数： 数字，大于0
         * @param page    请求第几页：数字，大于0
         * @return Observable
         */
        Observable<GankCustomListBean> getCustomGankList(String type, int prePage, int page);
    }


    interface GankCustomView extends BaseTabsContract.BaseTabsView<GankCustomItemBean> {
        /**
         * 返回定制消息类型
         * 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
         */
        String getCustomType();

        /**
         * 根据定制类型清空list 并且刷新
         * @param list
         */
        void refeshCustomList(List<GankCustomItemBean> list);
    }

}
