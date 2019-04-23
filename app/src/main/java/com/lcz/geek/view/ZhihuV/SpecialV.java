package com.lcz.geek.view.ZhihuV;

import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.bean.Zhihu.SpecialBean;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public interface SpecialV extends BaseMvpView{
    void onSussion(SpecialBean specialBean);

    void  onFail(String str);
}
