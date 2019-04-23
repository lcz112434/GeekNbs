package com.lcz.geek.CallBackss.ZhihuCallback;

import com.lcz.geek.bean.Zhihu.SpecialBean;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public interface SpecialCallBack {
    void onSussion(SpecialBean specialBean);

    void  onFail(String str);
}
