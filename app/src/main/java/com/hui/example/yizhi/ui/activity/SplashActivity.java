package com.hui.example.yizhi.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

import com.hui.example.yizhi.R;
import com.hui.example.yizhi.base.BaseCompatActivity;
import com.hui.example.yizhi.helper.RxHelper;
import com.hui.example.yizhi.utils.StringUtils;
import com.hui.example.yizhi.utils.ToastUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class SplashActivity extends BaseCompatActivity {
    @BindView(R.id.tv_count_down)
    TextView tvCountDown;

    private  boolean mIsCancle;
    private int mTime=3;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }


    @SuppressLint("NewApi")
    @Override
    protected void initView(Bundle savedInstanceState) {
        //注：魅族pro6s-7.0-flyme6权限没有像类似6.0以上手机一样正常的提示dialog获取运行时权限，而是直接默认给了权限
        requestPermissions();
    }


    /**
     * 动态权限申请
     */
    @SuppressLint("CheckResult")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void requestPermissions() {
        RxPermissions rxPermissions=new RxPermissions(SplashActivity.this);
             rxPermissions.request(
                     Manifest.permission.CAMERA,
                     Manifest.permission.READ_PHONE_STATE,
                     Manifest.permission.WRITE_EXTERNAL_STORAGE,
                     Manifest.permission.READ_EXTERNAL_STORAGE,
                     Manifest.permission.ACCESS_COARSE_LOCATION).subscribe(new Consumer<Boolean>() {
                 @Override
                 public void accept(Boolean aBoolean) throws Exception {
                     if (!aBoolean){
                         ToastUtils.showToast("App未能获取全部需要的相关权限，部分功能可能不能正常使用.");
                     }else {
                         initCountDown();  //不管有没有获取到全部权限  进入主页
                     }
                 }
             });
    }

    /**
     * 计时器
     */
    @SuppressLint("CheckResult")
    private void initCountDown() {
        Observable.interval(1,TimeUnit.SECONDS)
                .take(3)   //计时次数
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return mTime-aLong;
                    }
                }).compose(RxHelper.rxSchedulerHelper())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        String s=String.valueOf(aLong);
                        if (tvCountDown!=null){
                            tvCountDown.setText(StringUtils.isEmpty(s)?":":s);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (!mIsCancle) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }



    @OnClick(R.id.ll_skip)
    public void OnClickView(){
        mIsCancle=true;
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        finish();
    }

}
