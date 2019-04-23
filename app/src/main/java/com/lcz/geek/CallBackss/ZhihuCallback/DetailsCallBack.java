package com.lcz.geek.CallBackss.ZhihuCallback;

import com.lcz.geek.bean.Zhihu.HotBean;
import com.lcz.geek.bean.Zhihu.RibaoitemBean;

/**
 * Created by 李承泽 on 2019/4/22.
 */
public interface DetailsCallBack {
    void onSussion(RibaoitemBean bean);

    void onFali(String str);
}
