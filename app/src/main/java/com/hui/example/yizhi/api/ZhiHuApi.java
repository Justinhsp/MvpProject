package com.hui.example.yizhi.api;

import com.hui.example.yizhi.bean.ZhihuDailyListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhiHuApi {

    public final String BASE_URL="http://news-at.zhihu.com";

    @GET("/api/4/news/latest")
    Observable<ZhihuDailyListBean> getLastDailyList();

    @GET("/api/4/news/before/{date}")
    Observable<ZhihuDailyListBean> getDailyWithDate(@Path("date") String date);
}
