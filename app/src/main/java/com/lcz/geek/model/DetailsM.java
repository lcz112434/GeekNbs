package com.lcz.geek.model;

import android.util.Log;

import com.lcz.geek.Api.ZhihuApi.ZhihuServer;
import com.lcz.geek.Base.BaseMvpModel;
import com.lcz.geek.CallBackss.ZhihuCallback.DetailsCallBack;
import com.lcz.geek.bean.Zhihu.RibaoitemBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李承泽 on 2019/4/22.
 */
public class DetailsM extends BaseMvpModel {

    public void setData(int page, final DetailsCallBack detailsCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ZhihuServer.url)
                .build();

        ZhihuServer zhihuServer = retrofit.create(ZhihuServer.class);

        Observable<RibaoitemBean> getitem = zhihuServer.getitem(page);

        getitem.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RibaoitemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
//                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(RibaoitemBean bean) {
                        detailsCallBack.onSussion(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailsCallBack.onFali(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                })
        ;
    }
}
