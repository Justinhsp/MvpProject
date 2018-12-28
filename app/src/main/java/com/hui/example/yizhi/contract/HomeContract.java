package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.IBaseModel;

/**
 * 首页接口
 */
public interface HomeContract {

    abstract class HomePresenter extends BasePresenter<HomeModel,HomeView>{
         public abstract void getTabList();
    }

    interface HomeModel extends IBaseModel {
        String[] getTabs();
    }

    interface HomeView extends BaseFragment {
        void showTabList(String[] tabs);
    }

}
