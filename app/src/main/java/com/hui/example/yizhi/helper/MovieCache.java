package com.hui.example.yizhi.helper;

import com.hui.example.yizhi.bean.SubjectsBean;
import com.hui.example.yizhi.utils.SpUtils;

import java.util.List;

public class MovieCache {

    /**
     * 获取豆瓣电影 Cache
     * @return
     */
    public static List<SubjectsBean> getHotMovieCache(){
        return SpUtils.getDataList("hot_movie_cache",SubjectsBean.class);
    }


    public static void saveHotMovieChche(List<SubjectsBean> list){
        SpUtils.setDataList("hot_movie_cache",list);
    }

}
