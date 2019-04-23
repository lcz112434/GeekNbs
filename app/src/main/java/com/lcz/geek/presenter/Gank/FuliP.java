package com.lcz.geek.presenter.Gank;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.CallBackss.Gank.FuliCallBack;
import com.lcz.geek.bean.FuliBean;
import com.lcz.geek.model.Gank.FuliM;
import com.lcz.geek.view.Gank.FuliV;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public class FuliP extends Basepresenter<FuliV> {

    private FuliM mFuliM;

    public void getData(int page) {
        mFuliM.setData(page, new FuliCallBack() {
            @Override
            public void onSussion(FuliBean listBean) {
                mview.onSussion(listBean);
            }

            @Override
            public void onFail(String str) {
                mview.onFail(str);
            }
        });
    }

    @Override
    protected void initModel() {
        mFuliM = new FuliM();
        models.add(mFuliM);
    }
}
