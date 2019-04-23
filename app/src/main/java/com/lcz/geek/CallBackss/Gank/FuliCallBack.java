package com.lcz.geek.CallBackss.Gank;

import com.lcz.geek.bean.FuliBean;
import com.lcz.geek.bean.GankListBean;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public interface FuliCallBack {
    void onSussion(FuliBean listBean);

    void onFail(String str);
}
