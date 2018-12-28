package com.hui.example.yizhi.ui.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.hui.example.yizhi.R;
import com.hui.example.yizhi.adapter.FragmentAdapter;
import com.hui.example.yizhi.base.BaseMVPCompatFragment;
import com.hui.example.yizhi.base.BasePresenter;
import com.hui.example.yizhi.constant.TabFragmentIndex;
import com.hui.example.yizhi.contract.HomeContract;
import com.hui.example.yizhi.presenter.HomePresenter;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import butterknife.BindView;

public class HomeFragment extends BaseMVPCompatFragment<HomeContract.HomePresenter> implements HomeContract.HomeView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.vp_home)
    ViewPager vpHome;


    private List<Fragment> fragments;

    public static HomeFragment newInstance() {
        Bundle bundle = new Bundle();
        HomeFragment fragment = new HomeFragment();
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
        return R.layout.fragment_home;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
         toolbar.setTitle("首页");
    }



    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomePresenter.newInstance();
    }


    @Override
    public void showTabList(String[] tabs) {
        Logger.w(Arrays.toString(tabs));
        for (int i=0;i<tabs.length;i++){
            switch (i){
                case TabFragmentIndex.TAB_ZHIHU_INDEX:
                    fragments.add(ZhiHuFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_WANGYI_INDEX:
                    fragments.add(WangYiFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_WEIXIN_INDEX:
                    fragments.add(WeiXinFragment.newInstance());
                    break;
                     default:
                         fragments.add(ZhiHuFragment.newInstance());
                         break;
            }
        }
        vpHome.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));
        vpHome.setCurrentItem(TabFragmentIndex.TAB_ZHIHU_INDEX);
        tlTabs.setupWithViewPager(vpHome);
        tlTabs.setVerticalScrollbarPosition(TabFragmentIndex.TAB_ZHIHU_INDEX);
        //tlTabs.setupWithViewPager方法内部会remove所有的tabs，这里重新设置一遍tabs的text 否则tabs的text不显示
        for (int i=0;i<tabs.length;i++){
            tlTabs.getTabAt(i).setText(tabs[i]);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
