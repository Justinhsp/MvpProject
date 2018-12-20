package com.hui.example.yizhi.ui.fragment.movie;

import android.os.Bundle;
import android.view.View;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.base.BaseMVPCompatFragment;
import com.hui.example.yizhi.base.BasePresenter;

import androidx.annotation.NonNull;

public class MovieFragment extends BaseMVPCompatFragment {


    public static MovieFragment newInstance(){
        Bundle bundle=new Bundle();
        MovieFragment fragment=new MovieFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
