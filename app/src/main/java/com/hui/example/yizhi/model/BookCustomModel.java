package com.hui.example.yizhi.model;

import android.os.Bundle;

import com.hui.example.yizhi.api.DouBanApi;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.bean.BookListBean;
import com.hui.example.yizhi.contract.BookCustomContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;

import io.reactivex.Observable;

public class BookCustomModel extends BaseModel implements BookCustomContract.BookCustomModel {

    public static BookCustomModel newInstance() {
        return new BookCustomModel();
    }

    @Override
    public Observable<BookListBean> getBookListWithTag(String tag, int start, int count) {
        return RetrofitCreateHelper.createApi(DouBanApi.class,DouBanApi.BASE_URL)
                .getBookListWithTag(tag,start,count)
                .compose(RxHelper.rxSchedulerHelper());
    }
}
