package com.hui.example.yizhi.model;
import com.hui.example.yizhi.base.BaseModel;
import com.hui.example.yizhi.contract.HomeContract;

public class HomeModel extends BaseModel implements HomeContract.HomeModel {


    public static HomeModel newInstance() {
        return new HomeModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"知乎日报","热点新闻","微信精选"};
    }
}
