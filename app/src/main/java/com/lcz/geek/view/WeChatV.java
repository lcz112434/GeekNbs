package com.lcz.geek.view;

import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.bean.WeChatListBean;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public interface WeChatV extends BaseMvpView {
    void onSussion(WeChatListBean listBean);

    void onFail(String str);
}
