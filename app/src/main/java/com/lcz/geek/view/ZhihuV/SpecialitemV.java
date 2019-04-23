package com.lcz.geek.view.ZhihuV;

import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.bean.Zhihu.SpecialBean;
import com.lcz.geek.bean.Zhihu.SpecialtemBean;

/**
 * Created by 李承泽 on 2019/4/14.
 */
public interface SpecialitemV extends BaseMvpView{
    void onSussion(SpecialtemBean specialBean);

    void onFail(String str);
}
