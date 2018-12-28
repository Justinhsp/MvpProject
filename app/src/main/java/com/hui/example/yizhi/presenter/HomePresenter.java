package com.hui.example.yizhi.presenter;


import com.hui.example.yizhi.contract.HomeContract;
import com.hui.example.yizhi.model.HomeModel;

public class HomePresenter extends HomeContract.HomePresenter {

    public static HomePresenter newInstance() {
        return new HomePresenter();
    }

    @Override
    public void getTabList() {
       if (mIView==null || mIModel==null)
           return;
       mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected HomeContract.HomeModel getModel() {
        return HomeModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
