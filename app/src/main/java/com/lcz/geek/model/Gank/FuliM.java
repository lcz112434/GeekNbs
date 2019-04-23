package com.lcz.geek.model.Gank;

import com.lcz.geek.Api.GankServer;
import com.lcz.geek.Base.BaseMvpModel;
import com.lcz.geek.CallBackss.Gank.FuliCallBack;
import com.lcz.geek.bean.FuliBean;
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
public class FuliM extends BaseMvpModel {

    public void setData(int page, final FuliCallBack fuliCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GankServer.url2)
                .build();
        GankServer gankServer = retrofit.create(GankServer.class);
        Observable<FuliBean> fuli = gankServer.getFuli(page);
        fuli.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(FuliBean listBean) {
                        fuliCallBack.onSussion(listBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        fuliCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
