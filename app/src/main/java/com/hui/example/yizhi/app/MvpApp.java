package com.hui.example.yizhi.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class MvpApp extends Application {

    protected static Context context;   //上下文
    protected static Handler handler;  //全局Handler
    protected static int mainThreadId;  //主线程ID
    private static MvpApp mApp;

    public static synchronized MvpApp getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myTid();
    }



    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取全局handler
     *
     * @return 全局handler
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 获取主线程id
     *
     * @return 主线程id
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }
}
