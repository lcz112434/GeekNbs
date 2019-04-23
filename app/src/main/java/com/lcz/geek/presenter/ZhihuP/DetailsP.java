package com.lcz.geek.presenter.ZhihuP;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.CallBackss.ZhihuCallback.DetailsCallBack;
import com.lcz.geek.bean.Zhihu.RibaoitemBean;
import com.lcz.geek.model.DetailsM;
import com.lcz.geek.view.ZhihuV.DetailsV;

/**
 * Created by 李承泽 on 2019/4/22.
 */
public class DetailsP extends Basepresenter<DetailsV> {

    private DetailsM mDetailsM;

    public void getData(int page) {
        mDetailsM.setData(page, new DetailsCallBack() {
            @Override
            public void onSussion(RibaoitemBean bean) {
                mview.onSussion(bean);
            }

            @Override
            public void onFali(String str) {
                mview.onFali(str);
            }
        });
    }

    @Override
    protected void initModel() {
        mDetailsM = new DetailsM();
        models.add(mDetailsM);
    }
}
