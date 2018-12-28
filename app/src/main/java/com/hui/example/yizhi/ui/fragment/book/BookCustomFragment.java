package com.hui.example.yizhi.ui.fragment.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.BookCustomAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.bean.BookItemBean;
import com.hui.example.yizhi.contract.BookCustomContract;
import com.hui.example.yizhi.presenter.BookCustomPresenter;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

import static com.hui.example.yizhi.constant.BundleKeyConstant.ARG_KEY_DOUBAN_BOOK_TAGS;

public class BookCustomFragment extends BaseRecycleFragment<BookCustomContract.BookCustomPresenter> implements BookCustomContract.BookCustomView, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_book)
    RecyclerView rvBook;

    private String mBookTags = "文学";
    private BookCustomAdapter mBookCustomAdapter;

    public static BookCustomFragment newInstance(String bookTags) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY_DOUBAN_BOOK_TAGS, bookTags);
        BookCustomFragment fragment = new BookCustomFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void initData() {
        super.initData();
        Bundle args=getArguments();
        if (args!=null){
               mBookTags=args.getString(ARG_KEY_DOUBAN_BOOK_TAGS);
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestBookList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_book_custom;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
          mBookCustomAdapter=new BookCustomAdapter(R.layout.item_book_custom);
          rvBook.setAdapter(mBookCustomAdapter);
          rvBook.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return BookCustomPresenter.newInstance();
    }

    @Override
    protected void onErrorViewClick(View view) {
          mPresenter.loadLatestBookList();
    }

    @Override
    protected void showLoading() {
        mBookCustomAdapter.setEmptyView(loadingView);
    }

    @Override
    public void updateContentList(List<BookItemBean> list) {
             if (mBookCustomAdapter.getData().size()==0){
                 initRecycleView(list);
             }else {
                 mBookCustomAdapter.addData(list);
             }
    }


    private void initRecycleView(List<BookItemBean> list) {
           mBookCustomAdapter=new BookCustomAdapter(R.layout.item_book_custom,list);
           rvBook.setAdapter(mBookCustomAdapter);
           mBookCustomAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
               @Override
               public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                   ToastUtils.showToast("去详情");
               }
           });

           mBookCustomAdapter.setOnLoadMoreListener(this,rvBook);
    }


    @Override
    public void onLoadMoreRequested() {
       mBookCustomAdapter.loadMoreComplete();
       mPresenter.loadLatestBookList();
    }

    @Override
    public void showNetworkError() {
        mBookCustomAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
         mBookCustomAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
        mBookCustomAdapter.loadMoreEnd(false);
    }

    @Override
    public String getBookTags() {
        return mBookTags;
    }


}
