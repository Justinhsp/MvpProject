package com.hui.example.yizhi.helper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 用于管理RXJava注册订阅  和取消订阅
 */
public class RxManager {
    //管理订阅者
    private CompositeDisposable mCompositeDisposable=new CompositeDisposable();

    //订阅
    public void register(Disposable d){
        mCompositeDisposable.add(d);
    }

    //取消订阅
    public void unSubscribe(){
        mCompositeDisposable.dispose();
    }
}
