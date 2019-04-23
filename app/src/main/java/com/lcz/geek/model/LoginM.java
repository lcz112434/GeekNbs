package com.lcz.geek.model;

import com.lcz.geek.Api.BaseObserver;
import com.lcz.geek.Api.HttpUtils;
import com.lcz.geek.Api.LoginServer;
import com.lcz.geek.Api.ResultCallBack;
import com.lcz.geek.Api.RxUtils;
import com.lcz.geek.Base.BaseMvpModel;
import com.lcz.geek.bean.LoginBean;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class LoginM extends BaseMvpModel {

    public void login(String userName, String userpsw, final ResultCallBack resultCallBack) {
        LoginServer apiserver = HttpUtils.getInstance().getApiserver(LoginServer.sBaseUrl, LoginServer.class);
        Observable<LoginBean> login = apiserver.login(userName, userpsw);
        login.compose(RxUtils.<LoginBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                    resultCallBack.onSuccess(loginBean);
                    }
                });
    }
}
