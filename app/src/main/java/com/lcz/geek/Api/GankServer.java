package com.lcz.geek.Api;

import com.lcz.geek.bean.FuliBean;
import com.lcz.geek.bean.GankListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public interface GankServer {
    String url = "http://gank.io/api/";

    @GET("data/{page}")
//    data/{tech}/{num}/{page}
    Observable<GankListBean> getGank(@Path("page") String name);

    String url2="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("20/{page}")
    Observable<FuliBean> getFuli(@Path("page") int a);
}
