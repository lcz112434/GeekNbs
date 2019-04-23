package com.lcz.geek.model.ZhihuModels;

import android.util.Log;

import com.lcz.geek.Api.ZhihuApi.ZhihuServer;
import com.lcz.geek.Base.BaseMvpModel;
import com.lcz.geek.CallBackss.ZhihuCallback.SpecialCallBack;
import com.lcz.geek.CallBackss.ZhihuCallback.SpecialitemCallBack;
import com.lcz.geek.bean.Zhihu.SpecialBean;
import com.lcz.geek.bean.Zhihu.SpecialtemBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李承泽 on 2019/4/14.
 */
public class SpecialtemM extends BaseMvpModel{
    private static final String TAG = "SpecialtemM";

    public void getData(int page ,final SpecialitemCallBack ribaoCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ZhihuServer.url)
                .build();

        ZhihuServer zhihuServer = retrofit.create(ZhihuServer.class);
        Observable<SpecialtemBean> specialtem = zhihuServer.getSpecialtem(page);
        Log.i(TAG,page+"");

        specialtem.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SpecialtemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SpecialtemBean ribaoBean) {
                        ribaoCallBack.onSussion(ribaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        ribaoCallBack.onFail("请求不到网络数据");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
