package com.hui.example.yizhi.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hui.example.yizhi.app.MvpApp;
import com.hui.example.yizhi.utils.AppUtils;
import com.hui.example.yizhi.widget.WaitPorgressDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseCompatFragment extends SupportFragment {

    protected  String TAG;
    protected Context  mContext;
    protected Activity mActivity;
    protected MvpApp mvpApp;
    protected WaitPorgressDialog mWaitPorgressDialog;
    private Unbinder unbinder;


    @Override
    public void onAttach(Context context) {
        mActivity= (Activity)context;
        mContext=context;
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        if (getLayoutView()!=null){
            Log.d(TAG, "onCreateView:getLayoutView");
            return getLayoutView();
        }else {
            Log.d(TAG, "onCreateView:getLayoutId");
            return inflater.inflate(getLayoutId(),container,false);
        }
    }


    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG=getClass().getSimpleName();
        unbinder=ButterKnife.bind(this,view);
        getBundle(getArguments());
        initData();
        initUI(view,savedInstanceState);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder!=null){
            unbinder.unbind();
        }
        Log.d(TAG, "onDestroyView: ");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @LayoutRes
    public abstract int getLayoutId();

    public View getLayoutView() {
        Log.d(TAG, "getLayoutView: ");
        return null;
    }

    /**
     * 得到Activity传进来的值
     */
    public void getBundle(Bundle bundle) {
        Log.d(TAG, "getBundle: ");
    }

    /**
     * 初始化UI
     */
    public abstract void initUI(View view,Bundle savedInstanceState);

    /**
     * 在监听器之前把数据准备好
     */
    public void initData() {
        Log.d(TAG, "initData: ");
        mWaitPorgressDialog=new WaitPorgressDialog(mActivity);
        mContext=AppUtils.getContext();
        mvpApp= (MvpApp) mActivity.getApplication();
    }


    @Override
    public boolean onBackPressedSupport() {
        if (getFragmentManager().getBackStackEntryCount()>1){
            pop();  //如果当前存在fragment>1 则出栈
        }else {
            //已经退栈到root 由Activity处理回退事件
            return false;
        }
        return true;
    }

    /**
     * 显示提示框
     *
     * @param msg 提示框内容字符串
     */
    protected void showProgressDialog(String msg) {
        if (mWaitPorgressDialog.isShowing()) {
            mWaitPorgressDialog.dismiss();
        }

        mWaitPorgressDialog.setMessage(msg);
        mWaitPorgressDialog.show();
    }

    /**
     * 隐藏提示框
     */
    protected void hideProgressDialog() {
        if (mWaitPorgressDialog != null) {
            mWaitPorgressDialog.dismiss();
        }
    }
}
