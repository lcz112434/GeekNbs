package com.lcz.geek.presenter.ZhihuP;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.CallBackss.ZhihuCallback.SpecialitemCallBack;
import com.lcz.geek.bean.Zhihu.SpecialBean;
import com.lcz.geek.bean.Zhihu.SpecialtemBean;
import com.lcz.geek.model.ZhihuModels.SpecialM;
import com.lcz.geek.model.ZhihuModels.SpecialtemM;
import com.lcz.geek.view.ZhihuV.SpecialitemV;

/**
 * Created by 李承泽 on 2019/4/14.
 */
public class SpecialtemP extends Basepresenter<SpecialitemV> {

    private SpecialtemM mSpecialM;

    public void setData(int page) {
        mSpecialM.getData(page, new SpecialitemCallBack() {
            @Override
            public void onSussion(SpecialtemBean specialBean) {
                mview.onSussion(specialBean);
            }

            @Override
            public void onFail(String str) {
                mview.onFail(str);
            }
        });
    }

    @Override
    protected void initModel() {
        mSpecialM = new SpecialtemM();
        models.add(mSpecialM);
    }
}
