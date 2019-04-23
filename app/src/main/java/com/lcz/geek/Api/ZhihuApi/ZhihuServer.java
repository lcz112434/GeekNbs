package com.lcz.geek.Api.ZhihuApi;

import com.lcz.geek.bean.Zhihu.HotBean;
import com.lcz.geek.bean.Zhihu.RibaoBean;
import com.lcz.geek.bean.Zhihu.RibaoitemBean;
import com.lcz.geek.bean.Zhihu.SpecialBean;
import com.lcz.geek.bean.Zhihu.SpecialtemBean;
import com.lcz.geek.bean.Zhihu.oldRibaoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public interface ZhihuServer {
    String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<RibaoBean> getRibao();

    @GET("sections")
    Observable<SpecialBean> getSpecial();

    @GET("news/hot")
    Observable<HotBean> getHot();

    @GET("section/{page}")
    Observable<SpecialtemBean> getSpecialtem(@Path("page") int page);


    @GET("news/before/{date}")
    Observable<oldRibaoBean> getoldRibao(@Path("date") int a);

    @GET("news/{news_id}")
    Observable<RibaoitemBean> getitem(@Path("news_id") int page);
}
