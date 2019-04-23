package com.lcz.geek.model.ZhihuModels;

import android.util.Log;

import com.lcz.geek.Api.ZhihuApi.ZhihuServer;
import com.lcz.geek.Base.BaseMvpModel;
import com.lcz.geek.bean.Zhihu.RibaoBean;
import com.lcz.geek.CallBackss.RibaoCallBack;
import com.lcz.geek.bean.Zhihu.oldRibaoBean;
import com.lcz.geek.utils.ToastUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class RibaoM extends BaseMvpModel {
    private static final String TAG = "RibaoM";

    public void getdata(final RibaoCallBack ribaoCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ZhihuServer.url)
                .build();

        ZhihuServer zhihuServer = retrofit.create(ZhihuServer.class);
        Observable<RibaoBean> ribao = zhihuServer.getRibao();

        ribao.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RibaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(RibaoBean ribaoBean) {
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

    public void getData2(int page,final RibaoCallBack ribaoCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ZhihuServer.url)
                .build();

        ZhihuServer zhihuServer = retrofit.create(ZhihuServer.class);
        Observable<oldRibaoBean> oldRibaoBeanObservable = zhihuServer.getoldRibao(page);

        oldRibaoBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<oldRibaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(oldRibaoBean ribaoBean) {
                        ribaoCallBack.onOldSussion(ribaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        ribaoCallBack.onoldFail("请求不到网络数据1111111");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
