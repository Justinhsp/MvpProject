package com.hui.example.yizhi.ui.fragment.book;

import android.os.Bundle;
import android.view.View;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.base.BaseMVPCompatFragment;
import com.hui.example.yizhi.base.BasePresenter;

import androidx.annotation.NonNull;

public class BookFragment extends BaseMVPCompatFragment {

    public static BookFragment newInstance() {
        Bundle bundle = new Bundle();
        BookFragment fragment = new BookFragment();
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
