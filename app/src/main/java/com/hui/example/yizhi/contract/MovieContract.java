package com.hui.example.yizhi.contract;

import android.widget.ImageView;

import com.hui.example.yizhi.base.BaseFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.IBaseModel;
import com.hui.example.yizhi.bean.HotMovieBean;
import com.hui.example.yizhi.bean.SubjectsBean;

import java.util.List;

import io.reactivex.Observable;

public interface MovieContract {

    abstract class MoviePresenter extends BasePresenter<MovieModel, MovieView> {
        //加载最新电影
        public abstract void loadHotMovieList();

        //Item点击
        public abstract void OnItemClick(int position, SubjectsBean item, ImageView imageView);

        //Header被点击
        public abstract void onHeaderClick();
    }


    interface MovieModel extends IBaseModel {
        //获取最热电影
        Observable<HotMovieBean> getHotMovieList();
    }


    interface MovieView extends BaseFragment {
        //更新界面list
        void updateContentList(List<SubjectsBean> list);

        //显示网络错误
        void showNetWorkError();
    }

}
