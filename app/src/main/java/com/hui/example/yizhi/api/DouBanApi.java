package com.hui.example.yizhi.api;

import com.hui.example.yizhi.bean.BookListBean;
import com.hui.example.yizhi.bean.HotMovieBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 豆瓣电影
 */
public interface DouBanApi {

    public final static String BASE_URL="Https://api.douban.com/";

    /**
     * 豆瓣热映电影  每日更新
     * @return
     */
    @GET("v2/movie/in_theaters")
    Observable<HotMovieBean> getHotMovie();

    /**
     * 根据Tag 获取图书
     * @param tag   关键字
     * @param start 从0开始
     * @param count 一次请求数目 最多100
     * @return
     */
    @GET("v2/book/search")
    Observable<BookListBean> getBookListWithTag(@Query("tag") String tag,@Query("start") int start,@Query("count") int count);


}
