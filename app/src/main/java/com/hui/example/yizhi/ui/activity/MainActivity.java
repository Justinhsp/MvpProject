package com.hui.example.yizhi.ui.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.base.BaseCompatActivity;
import com.hui.example.yizhi.helper.BottomNavigationViewHelper;
import com.hui.example.yizhi.ui.fragment.book.BookFragment;
import com.hui.example.yizhi.ui.fragment.gank.GankFragment;
import com.hui.example.yizhi.ui.fragment.home.HomeFragment;
import com.hui.example.yizhi.ui.fragment.movie.MovieFragment;
import com.hui.example.yizhi.ui.fragment.personal.PersonalFragment;
import com.hui.example.yizhi.utils.ToastUtils;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseCompatActivity {
    @BindView(R.id.bottom_bar)
    BottomNavigationView bottomBar;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;
    private SupportFragment[] mFragments = new SupportFragment[5];

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mFragments[FIRST] = HomeFragment.newInstance();
            mFragments[SECOND] = GankFragment.newInstance();
            mFragments[THIRD] = MovieFragment.newInstance();
            mFragments[FOURTH] = BookFragment.newInstance();
            mFragments[FIFTH] = PersonalFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]);
        } else {
            mFragments[FIRST].findFragment(HomeFragment.class);
            mFragments[SECOND].findFragment(GankFragment.class);
            mFragments[THIRD].findFragment(MovieFragment.class);
            mFragments[FOURTH].findFragment(BookFragment.class);
            mFragments[FIFTH].findFragment(PersonalFragment.class);
        }

        //禁止三个Item以上的动画切换效果  Api28 后已修复
        //BottomNavigationViewHelper.disableShiftMode(bottomBar);
    }


    /**
     * 按两次退出程序
     */
    @Override
    public void onBackPressedSupport() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            pop();  //如果当前存在Fragment>1 当前Fragment出栈
        } else {
            if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
                finish();
            } else {
                TOUCH_TIME = System.currentTimeMillis();
                ToastUtils.showToast(R.string.press_again);
            }
        }
    }
}
