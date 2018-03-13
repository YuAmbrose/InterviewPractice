package com.example.interviewpractice.utils.rxbus;

/**
 * Created by Administrator on 2017/9/28 0028.
 */

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

public class RxBus {

    private final FlowableProcessor<Object> mBus;

    private RxBus() {
        mBus = PublishProcessor.create().toSerialized();
    }

    private static class Holder {
        private static RxBus instance = new RxBus();
    }

    public static RxBus getInstance() {
        return Holder.instance;
    }

    public void post(Object obj) {
        mBus.onNext(obj);
    }

    public <T> Flowable<T> register(Class<T> clz) {
        return mBus.ofType(clz);
    }

    public Flowable<Object> register() {
        return mBus;
    }

    public void unregisterAll() {
        //会将所有由mBus生成的Flowable都置completed状态后续的所有消息都收不到了
        mBus.onComplete();
    }

    public boolean hasSubscribers() {
        return mBus.hasSubscribers();
    }
}