package com.lcz.geek.CallBackss.WeChatCallback;

import com.lcz.geek.bean.WeChatListBean;

/**
 * Created by 李承泽 on 2019/4/17.
 */
public interface MyCallBack<T> {
    void onSussion(T listBean);

    void onFail(String str);
}
