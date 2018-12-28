package com.hui.example.yizhi.presenter;
import com.hui.example.yizhi.contract.GankContract;
import com.hui.example.yizhi.model.GankModel;

public class GankPresenter extends GankContract.GankPresenter {

    public static GankPresenter newInstance() {
        return new GankPresenter();
    }

    @Override
    public void getTabList() {
          if (mIView==null || mIModel==null)
              return;
          mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected GankContract.GankModel getModel() {
        return GankModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
