package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.IBaseModel;

public interface GankContract {

    abstract class  GankPresenter  extends BasePresenter<GankModel,GankView>{
         public abstract void getTabList();
    }

    interface GankModel extends IBaseModel{
        String[] getTabs();
    }

    interface GankView extends BaseFragment{
        void showTabList(String[] tabs);
    }
}
