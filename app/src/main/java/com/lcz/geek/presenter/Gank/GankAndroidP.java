package com.lcz.geek.presenter.Gank;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.CallBackss.Gank.GankAndroidCallBack;
import com.lcz.geek.bean.GankListBean;
import com.lcz.geek.model.Gank.GankAndroidM;
import com.lcz.geek.view.Gank.GankAndroidV;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public class GankAndroidP extends Basepresenter<GankAndroidV> {
    private GankAndroidM mGankAndroidM;

    public void getData(String name) {
        mGankAndroidM.setData(name, new GankAndroidCallBack() {
            @Override
            public void onSussion(GankListBean listBean) {
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
        mGankAndroidM = new GankAndroidM();
        models.add(mGankAndroidM);
    }
}
