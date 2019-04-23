package com.lcz.geek.CallBackss.ZhihuCallback;

import com.lcz.geek.bean.Zhihu.SpecialBean;
import com.lcz.geek.bean.Zhihu.SpecialtemBean;

/**
 * Created by 李承泽 on 2019/4/14.
 */
public interface SpecialitemCallBack {
    void onSussion(SpecialtemBean specialBean);

    void onFail(String str);
}
