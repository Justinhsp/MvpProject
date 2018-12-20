package com.hui.example.yizhi.ui.fragment.home;

import android.os.Bundle;
import android.view.View;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.base.BaseMVPCompatFragment;
import com.hui.example.yizhi.base.BasePresenter;

import androidx.annotation.NonNull;

public class HomeFragment extends BaseMVPCompatFragment {

    public static HomeFragment newInstance(){
        Bundle bundle=new Bundle();
        HomeFragment fragment=new HomeFragment();
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
