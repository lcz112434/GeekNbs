package com.lcz.geek.CallBackss;

import com.lcz.geek.bean.Zhihu.RibaoBean;
import com.lcz.geek.bean.Zhihu.oldRibaoBean;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public interface RibaoCallBack {
    void onSussion(RibaoBean ribaoBean);

    void onFail(String str);

    void onOldSussion(oldRibaoBean oldRibaoBean);

    void onoldFail(String str);
}
