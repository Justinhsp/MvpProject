package com.hui.example.yizhi.contract;

import com.hui.example.yizhi.base.BaseFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.IBaseModel;

public interface BookContract {

    abstract class BookPresenter extends BasePresenter<BookModel,BookView>{
          public abstract void getTabList();
    }


    interface BookModel extends IBaseModel{
        String[] getTabs();
    }

    interface BookView extends BaseFragment{
        void showTabList(String[] tabs);
    }

}
