package com.hui.example.yizhi.ui.fragment.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.HotMovieAdapter;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.base.BaseRecycleFragment;
import com.hui.example.yizhi.bean.SubjectsBean;
import com.hui.example.yizhi.contract.MovieContract;
import com.hui.example.yizhi.presenter.MoviePresenter;
import com.hui.example.yizhi.utils.ResourcesUtils;
import com.hui.example.yizhi.utils.ToastUtils;

import java.util.List;
import androidx.annotation.NonNull;
import butterknife.BindView;

public class MovieFragment extends BaseRecycleFragment<MovieContract.MoviePresenter> implements MovieContract.MovieView {
    @BindView(R.id.rv_hot_movie)
    RecyclerView rvHotMovie;


    private HotMovieAdapter mHotMovieAdapter;
    private View headView;


    public static MovieFragment newInstance() {
        Bundle bundle = new Bundle();
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie;
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadHotMovieList();
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mHotMovieAdapter = new HotMovieAdapter(R.layout.item_hot_movie);
        rvHotMovie.setAdapter(mHotMovieAdapter);
        rvHotMovie.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return MoviePresenter.newInstance();
    }


    @Override
    protected void onErrorViewClick(View view) {
          mPresenter.loadHotMovieList();
    }

    @Override
    protected void showLoading() {
      mHotMovieAdapter.setEmptyView(loadingView);
    }

    @Override
    public void updateContentList(List<SubjectsBean> list) {
           if (mHotMovieAdapter.getData().size()==0){
               initRecycleView(list);
           }else {
               mHotMovieAdapter.addData(list);
           }
    }


    private void initRecycleView(List<SubjectsBean> list) {
        mHotMovieAdapter=new HotMovieAdapter(R.layout.item_hot_movie,list);
        //添加顶部视图
        if (headView==null){
            headView=ResourcesUtils.inflate(R.layout.movie_top_header);
        }
        mHotMovieAdapter.addHeaderView(headView);
        rvHotMovie.setAdapter(mHotMovieAdapter);
        headView.findViewById(R.id.ll_movie_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast("预留Top 250");
            }
        });

        mHotMovieAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                  ToastUtils.showToast("预留详情");
            }
        });
    }

    @Override
    public void showNetWorkError() {
        mHotMovieAdapter.setEmptyView(errorView);
    }


}
