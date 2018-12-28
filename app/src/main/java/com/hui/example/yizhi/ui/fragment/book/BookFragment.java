package com.hui.example.yizhi.ui.fragment.book;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.FragmentAdapter;
import com.hui.example.yizhi.base.BaseMVPCompatFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.constant.TabFragmentIndex;
import com.hui.example.yizhi.contract.BookContract;
import com.hui.example.yizhi.presenter.BookPresenter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class BookFragment extends BaseMVPCompatFragment<BookContract.BookPresenter> implements BookContract.BookView {


    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;

    private List<Fragment> fragments;

    public static BookFragment newInstance() {
        Bundle bundle = new Bundle();
        BookFragment fragment = new BookFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragments=new ArrayList<>();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.getTabList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_book;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return BookPresenter.newInstance();
    }

    @Override
    public void showTabList(String[] tabs) {
        Logger.w(Arrays.toString(tabs));
        //实际上3个子布局是一样的，都只有一个recycleview，但是为了后续升级拓展，子fragment都是使用单独的布局文件
        for (int i = 0; i < tabs.length; i++) {
            tlTabs.addTab(tlTabs.newTab().setText(tabs[i]));
            switch (i) {
                case TabFragmentIndex.TAB_BOOK_LITERATURE_INDEX:
                    fragments.add(BookCustomFragment.newInstance("文学"));
                    break;
                case TabFragmentIndex.TAB_BOOK_CULTURE_INDEX:
                    fragments.add(BookCustomFragment.newInstance("文化"));
                    break;
                case TabFragmentIndex.TAB_BOOK_LIFE_INDEX:
                    fragments.add(BookCustomFragment.newInstance("生活"));
                    break;
                default:
                    fragments.add(BookCustomFragment.newInstance("文学"));
                    break;
            }
        }
        vpFragment.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        vpFragment.setCurrentItem(TabFragmentIndex.TAB_BOOK_LITERATURE_INDEX);
        tlTabs.setupWithViewPager(vpFragment);
        tlTabs.setVerticalScrollbarPosition(TabFragmentIndex.TAB_BOOK_LITERATURE_INDEX);
        //tlTabs.setupWithViewPager方法内部会remove所有的tabs，这里重新设置一遍tabs的text，否则tabs的text不显示
        for (int i = 0; i < tabs.length; i++) {
            tlTabs.getTabAt(i).setText(tabs[i]);
        }
    }
}
