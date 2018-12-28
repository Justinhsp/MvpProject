package com.hui.example.yizhi.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GankDayItemBean implements MultiItemEntity {


        public static final int GANK_IO_DAY_ITEM_DAY_NORMAL = 1;
        public static final int GANK_IO_DAY_ITEM_DAY_REFESH = 2;
        public int itemType = 1;

        // 存储单独设置的值，用来显示title
        @SerializedName("type_title")
        private String type_title;
        // 随机图URL
        @SerializedName("image_url")
        private String image_url;

        /**
         * _id : 5c1216aa9d21223f60727cbf
         * createdAt : 2018-12-13T08:22:02.158Z
         * desc : 360开源的移动端可视化性能监控平台，为移动端APP提供性能监控与管理，可以迅速发现和定位各类APP性能和使用问题，帮助APP不断的提升用户体验。
         * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1fy58eds38pj30rr0s0751"]
         * publishedAt : 2018-12-13T00:00:00.0Z
         * source : chrome
         * type : Android
         * url : https://github.com/Qihoo360/ArgusAPM
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

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getType_title() {
            return type_title;
        }

        public void setType_title(String type_title) {
            this.type_title = type_title;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
}
