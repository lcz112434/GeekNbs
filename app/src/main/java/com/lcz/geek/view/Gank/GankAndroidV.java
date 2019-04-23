package com.lcz.geek.view.Gank;

import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.bean.GankListBean;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public interface GankAndroidV extends BaseMvpView {
    void onSussion(GankListBean listBean);

    void onFail(String str);
}
