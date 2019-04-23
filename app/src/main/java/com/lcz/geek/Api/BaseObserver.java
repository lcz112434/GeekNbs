package com.lcz.geek.Api;

import android.util.Log;


import com.lcz.geek.utils.ToastUtil;

import io.reactivex.Observer;

/**
 * Created by asus on 2019/3/4.
 */

public abstract class BaseObserver<T> implements Observer<T> {
    private final String TAG = getClass().getName();

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: "+e.toString());
        ToastUtil.showShort("数据加载失败");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }
}
