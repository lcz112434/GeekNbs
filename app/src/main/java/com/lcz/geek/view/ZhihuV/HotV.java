package com.lcz.geek.view.ZhihuV;

import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.bean.Zhihu.HotBean;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public interface HotV extends BaseMvpView{
    void onSussion(HotBean hotBean);

    void onFali(String str);
}
