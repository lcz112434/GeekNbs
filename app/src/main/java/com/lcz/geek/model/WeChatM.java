package com.lcz.geek.model;

import android.util.Log;

import com.lcz.geek.Api.WeChatSever;
import com.lcz.geek.Api.ZhihuApi.ZhihuServer;
import com.lcz.geek.Base.BaseMvpModel;
import com.lcz.geek.CallBackss.WeChatCallback.MyCallBack;
import com.lcz.geek.bean.WeChatListBean;
import com.lcz.geek.bean.Zhihu.HotBean;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李承泽 on 2019/4/17.
 */
public class WeChatM extends BaseMvpModel {

    private static final String TAG = "WeChatM";

    public void getData(Map<String, Object> map, final MyCallBack<WeChatListBean> myCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(WeChatSever.url)
                .build();

        WeChatSever weChatSever = retrofit.create(WeChatSever.class);
        Observable<WeChatListBean> wechatList = weChatSever.getWechatList(map);

        wechatList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeChatListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WeChatListBean ribaoBean) {
                        myCallBack.onSussion(ribaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                        myCallBack.onFail("请求不到网络数据");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
