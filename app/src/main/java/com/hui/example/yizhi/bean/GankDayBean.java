package com.hui.example.yizhi.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 */

public class GankDayBean implements Serializable {

    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private ResultsBean results;
    @SerializedName("category")
    private List<String> category;

    public static class ResultsBean {
        /**
         * _id : 56cc6d23421aa95caa707a69
         * createdAt : 2015-08-06T07:15:52.65Z
         * desc : 类似Link Bubble的悬浮式操作设计
         * images : ["http://img.gank.io/2f0b6c5f-6de7-4ba3-94ad-98bf721ee447"]
         * source : web
         * publishedAt : 2015-08-07T03:57:48.45Z
         * type : Android
         * url : https://github.com/recruit-lifestyle/FloatingView
         * used : true
         * who : mthli
         */

        @SerializedName("Android")
        private List<GankDayItemBean> Android;

        @SerializedName("iOS")
        private List<GankDayItemBean> iOS;

        @SerializedName("前端")
        private List<GankDayItemBean> front;

        @SerializedName("App")
        private List<GankDayItemBean> app;

        @SerializedName("休息视频")
        private List<GankDayItemBean> restMovie;

        @SerializedName("拓展资源")
        private List<GankDayItemBean> resource;

        @SerializedName("瞎推荐")
        private List<GankDayItemBean> recommend;

        @SerializedName("福利")
        private List<GankDayItemBean> welfare;


        public List<GankDayItemBean> getAndroid() {
            return Android;
        }

        public List<GankDayItemBean> getiOS() {
            return iOS;
        }

        public List<GankDayItemBean> getRestMovie() {
            return restMovie;
        }

        public List<GankDayItemBean> getResource() {
            return resource;
        }

        public List<GankDayItemBean> getRecommend() {
            return recommend;
        }

        public List<GankDayItemBean> getWelfare() {
            return welfare;
        }

        public List<GankDayItemBean> getFront() {
            return front;
        }

        public List<GankDayItemBean> getApp() {
            return app;
        }
    }

    public boolean isError() {
        return error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public List<String> getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "GankDayBean{" +
                "error=" + error +
                ", results=" + results +
                ", category=" + category +
                '}';
    }
}
