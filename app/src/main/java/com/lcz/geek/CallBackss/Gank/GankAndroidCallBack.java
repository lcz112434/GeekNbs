package com.lcz.geek.CallBackss.Gank;

import com.lcz.geek.bean.GankListBean;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public interface GankAndroidCallBack {
    void onSussion(GankListBean listBean);

    void onFail(String str);
}
