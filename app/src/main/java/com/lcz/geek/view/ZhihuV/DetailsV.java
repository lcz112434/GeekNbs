package com.lcz.geek.view.ZhihuV;

import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.bean.Zhihu.RibaoitemBean;

/**
 * Created by 李承泽 on 2019/4/22.
 */
public interface DetailsV extends BaseMvpView{
    void onSussion(RibaoitemBean bean);

    void onFali(String str);
}
