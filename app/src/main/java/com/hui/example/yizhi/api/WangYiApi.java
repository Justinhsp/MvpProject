package com.hui.example.yizhi.api;

import com.hui.example.yizhi.bean.WangYiNewsListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WangYiApi {


    public final String BASE_URL="http://c.m.163.com";


    @GET("/nc/article/headline/T1348647909107/{id}-20.html")
    Observable<WangYiNewsListBean> getNewsList(@Path("id") int id);


}
