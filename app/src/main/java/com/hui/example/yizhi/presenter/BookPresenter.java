package com.hui.example.yizhi.presenter;

import com.hui.example.yizhi.contract.BookContract;
import com.hui.example.yizhi.model.BookModel;

public class BookPresenter extends BookContract.BookPresenter {

    public static BookPresenter newInstance() {
        return new BookPresenter();
    }

    @Override
    public void getTabList() {
        if (mIModel==null || mIView==null)
            return;
        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected BookContract.BookModel getModel() {
        return BookModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
