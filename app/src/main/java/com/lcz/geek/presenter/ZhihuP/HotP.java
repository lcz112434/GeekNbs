package com.lcz.geek.presenter.ZhihuP;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.CallBackss.ZhihuCallback.HotCallBack;
import com.lcz.geek.bean.Zhihu.HotBean;
import com.lcz.geek.model.ZhihuModels.HotM;
import com.lcz.geek.view.ZhihuV.HotV;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class HotP extends Basepresenter<HotV> {
    private HotM mHotM;

    public void getData() {
        mHotM.getData(new HotCallBack() {
            @Override
            public void onSussion(HotBean hotBean) {
                if (mview != null) {
                    mview.onSussion(hotBean);
                }

            }

            @Override
            public void onFali(String str) {
                if (mview != null) {
                    mview.onFali(str);
                }
            }
        });
    }

    @Override
    protected void initModel() {
        mHotM = new HotM();
        models.add(mHotM);
    }
}
