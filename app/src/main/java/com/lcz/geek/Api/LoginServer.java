package com.lcz.geek.Api;

import com.lcz.geek.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public interface LoginServer {
    String sBaseUrl = "http://yun918.cn/study/public/index.php/";

    /**
     * 登录
     * @param name,用户名
     * @param psd,密码
     * @return
     */
    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@Field("username") String name,
                                @Field("password") String psd);
}
