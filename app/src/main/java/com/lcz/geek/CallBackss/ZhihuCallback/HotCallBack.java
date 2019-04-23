package com.lcz.geek.CallBackss.ZhihuCallback;

import com.lcz.geek.bean.Zhihu.HotBean;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public interface HotCallBack {
    void onSussion(HotBean hotBean);

    void onFali(String str);
}
