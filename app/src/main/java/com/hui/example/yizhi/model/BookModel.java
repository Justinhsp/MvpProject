package com.hui.example.yizhi.model;


import com.hui.example.yizhi.contract.BookContract;

public class BookModel implements BookContract.BookModel {

    public static BookModel newInstance() {
       return new BookModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"文学", "文化", "生活"};
    }
}
