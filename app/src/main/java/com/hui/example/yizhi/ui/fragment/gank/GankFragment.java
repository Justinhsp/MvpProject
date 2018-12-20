package com.hui.example.yizhi.ui.fragment.gank;

import android.os.Bundle;
import android.view.View;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.base.BaseMVPCompatFragment;
import com.hui.example.yizhi.base.BasePresenter;

import androidx.annotation.NonNull;

public class GankFragment extends BaseMVPCompatFragment {


    public static  GankFragment newInstance(){
        Bundle bundle=new Bundle();
        GankFragment fragment=new GankFragment();
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
