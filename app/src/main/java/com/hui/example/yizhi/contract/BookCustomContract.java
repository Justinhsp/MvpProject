package com.hui.example.yizhi.contract;

import android.widget.ImageView;

import com.hui.example.yizhi.base.BaseFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.IBaseModel;
import com.hui.example.yizhi.bean.BookItemBean;
import com.hui.example.yizhi.bean.BookListBean;

import java.util.List;

import io.reactivex.Observable;

public interface BookCustomContract {

    abstract class BookCustomPresenter extends BasePresenter<BookCustomModel,BookCustomView>{
           //加载最新Book List
            public abstract void loadLatestBookList();
            //加载更多 Book List
            public abstract void loadMoreBookList();
            //item点击事件
            public  abstract void onItemClick(int position, BookItemBean item, ImageView imageView);
    }

    interface BookCustomModel extends IBaseModel {
        /**
         * 根据tag获取图书
         *
         * @param tag   搜索关键字
         * @param start 从多少开始，如从"0"开始
         * @param count 一次请求的数目 最多100
         * @return Observable
         */
        Observable<BookListBean> getBookListWithTag(String tag, int start, int count);
    }


    interface BookCustomView extends BaseFragment{
        /**
         * 更新界面list
         *
         * @param list list
         */
        void updateContentList(List<BookItemBean> list);

        /**
         * 显示网络错误
         */
        void showNetworkError();

        /**
         * 显示加载更多错误
         */
        void showLoadMoreError();

        /**
         * 显示没有更多数据
         */
        void showNoMoreData();

        /**
         * 返回定制book tags
         *
         * @return 定制book tags
         */
        String getBookTags();
    }


}
