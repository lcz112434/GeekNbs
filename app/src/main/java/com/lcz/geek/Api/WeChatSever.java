package com.lcz.geek.Api;

import com.lcz.geek.bean.WeChatListBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by 李承泽 on 2019/4/17.
 */
public interface WeChatSever {
    String url="http://api.tianapi.com/";


    @GET("wxnew/")
    Observable<WeChatListBean> getWechatList(@QueryMap Map<String,Object> map);


}
