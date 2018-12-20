package com.hui.example.yizhi.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * 管理Activity栈
 */
public class AppManager {

    private  static Stack<Activity> activityStack;
    private static  AppManager instance;

    public AppManager() {
    }


    /**
     * 单一实例
     * @return
     */
    public  static  AppManager getAppManager(){
        if (instance==null){
            instance=new AppManager();
        }
        return instance;
    }


    /**
     * 添加Activity到堆栈
     * @param activity
     */
    public void addActivity(Activity activity){
        if (activityStack==null){
            activityStack=new Stack<>();
        }
        activityStack.add(activity);
    }


    /**
     * 获取当前Activity(堆栈中最后一个压入的)
     * @return
     */
    public Activity currentActivity(){
        Activity activity=activityStack.lastElement();
        return activity;
    }


    /**
     * 结束指定Activity
     * @param activity
     */
    public void finishActivity(Activity activity){
        if (activity!=null){
            activityStack.remove(activity);
            activity.finish();
            activity=null;
        }
    }


    /**
     * 结束指定类名Activity
     * @param cls
     */
    public  void finishActivity(Class<?> cls){
        for (Activity activity:activityStack){
            if (activity.getClass().equals(cls)){
                finishActivity(activity);
            }
        }
    }


    /**
     * 结束所有Activity
     */
    public void finishAllActivity(){
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }


    /**
     * 退出应用程序
     * @param context
     */
    public void AppExit(Context context){
        finishAllActivity();
        ActivityManager activityManager= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }


    /**
     * 是否退出
     * @return
     */
    public boolean isAppExit(){
        return activityStack==null || activityStack.isEmpty();
    }


}
