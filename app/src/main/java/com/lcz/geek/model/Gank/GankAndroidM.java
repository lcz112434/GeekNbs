package com.lcz.geek.model.Gank;

import com.google.gson.Gson;
import com.lcz.geek.Api.GankServer;
import com.lcz.geek.Base.BaseMvpModel;
import com.lcz.geek.CallBackss.Gank.GankAndroidCallBack;
import com.lcz.geek.bean.GankListBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public class GankAndroidM extends BaseMvpModel {

    public void setData(String name, final GankAndroidCallBack gankAndroidCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GankServer.url)
                .build();
        GankServer gankServer = retrofit.create(GankServer.class);
        Observable<GankListBean> gank = gankServer.getGank(name);
        gank.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(GankListBean listBean) {
                        gankAndroidCallBack.onSussion(listBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        gankAndroidCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
