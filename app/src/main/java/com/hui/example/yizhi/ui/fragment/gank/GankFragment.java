package com.hui.example.yizhi.ui.fragment.gank;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.FragmentAdapter;
import com.hui.example.yizhi.base.BaseMVPCompatFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.constant.TabFragmentIndex;
import com.hui.example.yizhi.contract.GankContract;
import com.hui.example.yizhi.presenter.GankPresenter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GankFragment extends BaseMVPCompatFragment<GankContract.GankPresenter> implements GankContract.GankView {
    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.fab_classify)
    FloatingActionButton fabClassify;

    private List<Fragment> fragments;

    public static GankFragment newInstance() {
        Bundle bundle = new Bundle();
        GankFragment fragment = new GankFragment();
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
        return R.layout.fragment_gank;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return GankPresenter.newInstance();
    }


    @Override
    public void showTabList(String[] tabs) {
        Logger.w(Arrays.toString(tabs));
        for (int i=0;i<tabs.length;i++){
            tlTabs.addTab(tlTabs.newTab().setText(tabs[i]));
            switch (i){
                case TabFragmentIndex.TAB_GANK_DAY_INDEX:
                    fragments.add(GankDayFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_GANK_CUSTOM_INDEX:
                    fragments.add(GankCustomFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_GANK_WELFARE_INDEX:
                    fragments.add(GankWelFareFragment.newInstance());
                    break;
                     default:
                         fragments.add(GankDayFragment.newInstance());
                         break;
            }
        }
        vpFragment.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));
        vpFragment.setCurrentItem(TabFragmentIndex.TAB_GANK_DAY_INDEX);//要设置到viewpager
        tlTabs.setupWithViewPager(vpFragment);
        tlTabs.setVerticalScrollbarPosition(TabFragmentIndex.TAB_GANK_DAY_INDEX);
        //tlTabs.setupWithViewPager方法内部会remove所有的tabs，这里重新设置一遍tabs的text，否则tabs的text不显示
        for (int i = 0; i < tabs.length; i++) {
            tlTabs.getTabAt(i).setText(tabs[i]);
        }
    }


}
