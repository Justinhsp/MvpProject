package com.hui.example.yizhi.presenter;
import android.widget.ImageView;

import com.hui.example.yizhi.bean.BookItemBean;
import com.hui.example.yizhi.bean.BookListBean;
import com.hui.example.yizhi.contract.BookCustomContract;
import com.hui.example.yizhi.model.BookCustomModel;

import io.reactivex.functions.Consumer;

public class BookCustomPresenter  extends BookCustomContract.BookCustomPresenter {

    private int mStart;
    private int mCount = 30;
    private boolean isLoading;


    public static BookCustomPresenter newInstance() {
        return new BookCustomPresenter();
    }

    @Override
    public void loadLatestBookList() {
        if (mIModel==null || mIView==null)
            return;
        mStart=0;
        mRxManager.register(mIModel.getBookListWithTag(mIView.getBookTags(),mStart,mCount).subscribe(new Consumer<BookListBean>() {
            @Override
            public void accept(BookListBean bookListBean) throws Exception {
                if (mIView == null)
                    return;
                mStart += mCount;
                mIView.updateContentList(bookListBean.getBooks());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView == null)
                    return;

                if (mIView.isVisiable())
                    mIView.showToast("Network Error!");
                mIView.showNetworkError();
            }
        }));
    }

    @Override
    public void loadMoreBookList() {
             if (!isLoading){
                 isLoading=true;
                 mRxManager.register(mIModel.getBookListWithTag(mIView.getBookTags(),mStart,mCount).subscribe(new Consumer<BookListBean>() {
                     @Override
                     public void accept(BookListBean bookListBean) throws Exception {
                         isLoading = false;
                         if (mIView == null)
                             return;
                         if (bookListBean != null && bookListBean.getBooks() != null && bookListBean.getBooks().size() > 0) {
                             mStart += mCount;
                             mIView.updateContentList(bookListBean.getBooks());
                         } else {
                             mIView.showNetworkError();
                         }
                     }
                 }, new Consumer<Throwable>() {
                     @Override
                     public void accept(Throwable throwable) throws Exception {
                         isLoading=false;
                         if (mIView!=null){
                             mIView.showLoadMoreError();
                         }
                     }
                 }));
             }
    }

    @Override
    public void onItemClick(int position, BookItemBean item, ImageView imageView) {

    }

    @Override
    protected BookCustomContract.BookCustomModel getModel() {
        return BookCustomModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
