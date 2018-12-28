package com.hui.example.yizhi.presenter;

import android.widget.ImageView;

import com.hui.example.yizhi.bean.HotMovieBean;
import com.hui.example.yizhi.bean.SubjectsBean;
import com.hui.example.yizhi.contract.MovieContract;
import com.hui.example.yizhi.helper.MovieCache;
import com.hui.example.yizhi.model.MovieModel;

import io.reactivex.functions.Consumer;

public class MoviePresenter extends MovieContract.MoviePresenter {

    public static MoviePresenter newInstance() {
       return new MoviePresenter();
    }


    @Override
    public void loadHotMovieList() {
          if (mIModel==null || mIView==null)
              return;
          mRxManager.register(mIModel.getHotMovieList().subscribe(new Consumer<HotMovieBean>() {
              @Override
              public void accept(HotMovieBean hotMovieBean) throws Exception {
                  if (mIView == null)
                      return;
                  mIView.updateContentList(hotMovieBean.getSubjects());
                  MovieCache.saveHotMovieChche(hotMovieBean.getSubjects());
              }
          }, new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) throws Exception {
                   if (mIView!=null){
                       if (mIView.isVisiable())
                           mIView.showToast("NetWork Error.");
                       if (MovieCache.getHotMovieCache().size()==0){
                           mIView.showNetWorkError();   //没有缓存 显示错误页面
                       }else {
                           mIView.updateContentList(MovieCache.getHotMovieCache());  //加载缓存
                       }
                   }
              }
          }));
    }

    @Override
    public void OnItemClick(int position, SubjectsBean item, ImageView imageView) {

    }

    @Override
    public void onHeaderClick() {

    }

    @Override
    protected MovieContract.MovieModel getModel() {
        return MovieModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
