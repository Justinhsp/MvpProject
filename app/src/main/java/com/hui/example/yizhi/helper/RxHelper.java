package com.hui.example.yizhi.helper;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxHelper {

    /**
     * 统一线程处理
     * @param <T>
     * @return
     * 发布事件io线程  接收事件主线程
     */
    public static <T>ObservableTransformer<T,T> rxSchedulerHelper(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    /**
     * 生成Flowable
     * @param t
     * @param <T>
     * @return
     */
    public static <T>Flowable<T> createFlowable(final  T t){
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                }catch (Exception e){
                    emitter.onError(e);
                }
            }
        },BackpressureStrategy.BUFFER);
    }


    /**
     * 生成Observable
     * @param t
     * @param <T>
     * @return
     */
    public static <T>Observable<T> createObservable(final  T t){
        return  Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                }catch (Exception e){
                    emitter.onError(e);
                }
            }
        });
    }

}
