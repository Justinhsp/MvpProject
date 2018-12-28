package com.hui.example.yizhi.model;
import com.hui.example.yizhi.api.DouBanApi;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.bean.HotMovieBean;
import com.hui.example.yizhi.contract.MovieContract;
import com.hui.example.yizhi.helper.RetrofitCreateHelper;
import com.hui.example.yizhi.helper.RxHelper;

import io.reactivex.Observable;

public class MovieModel extends BaseModel implements MovieContract.MovieModel {

    public static MovieModel newInstance() {
        return new MovieModel();
    }

    @Override
    public Observable<HotMovieBean> getHotMovieList() {
        return RetrofitCreateHelper.createApi(DouBanApi.class,DouBanApi.BASE_URL)
                .getHotMovie().compose(RxHelper.rxSchedulerHelper());
    }
}
