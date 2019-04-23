package com.lcz.geek.view.Gank;

import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.bean.FuliBean;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public interface FuliV extends BaseMvpView{
    void onSussion(FuliBean listBean);

    void onFail(String str);
}
