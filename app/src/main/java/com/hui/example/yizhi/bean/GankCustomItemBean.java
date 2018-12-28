package com.hui.example.yizhi.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

public class GankCustomItemBean implements Serializable,MultiItemEntity {

    /**
     * 普通布局，带略缩图
     */
    public static final int GANK_IO_DAY_ITEM_CUSTOM_NORMAL = 1;
    /**
     * 图片布局，福利
     */
    public static final int GANK_IO_DAY_ITEM_CUSTOM_IMAGE = 2;
    /**
     * 无图布局
     */
    public static final int GANK_IO_DAY_ITEM_CUSTOM_NO_IMAGE = 3;
    public int itemType = 1;

        /**
         * _id : 5bfe119c9d2122309624cbab
         * createdAt : 2018-11-28T03:55:08.74Z
         * desc : 一个可插拔的Android应用程序，使用Lua脚本开发。
         * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1fy58e2nv6mj307i0dcjsy","https://ww1.sinaimg.cn/large/0073sXn7gy1fy58e3cw5ej307i0dcq3t","https://ww1.sinaimg.cn/large/0073sXn7gy1fy58e479l3j307i0dcgmg","https://ww1.sinaimg.cn/large/0073sXn7gy1fy58e55zp5j307i0dcq49","https://ww1.sinaimg.cn/large/0073sXn7gy1fy58e5zs9xj307i0dcq3y"]
         * publishedAt : 2018-12-13T00:00:00.0Z
         * source : chrome
         * type : App
         * url : https://github.com/hanks-zyh/hydrogenApp
         * used : true
         * who : lijinshanmx
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

    @Override
    public int getItemType() {
        return itemType;
    }
}
