package com.lcz.geek.view;

import com.lcz.geek.Base.BaseMvpView;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public interface LoginV extends BaseMvpView{
    String getUserName();
    String getUserpsw();
    void showToast(String msg);
}
