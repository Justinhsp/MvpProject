package com.hui.example.yizhi.model;


import com.hui.example.yizhi.contract.GankContract;

public class GankModel  implements GankContract.GankModel {

    public static GankModel newInstance() {
        return new GankModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"每日推荐", "干货定制", "福利"};
    }
}
