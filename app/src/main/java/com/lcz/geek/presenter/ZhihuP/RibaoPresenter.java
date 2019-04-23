package com.lcz.geek.presenter.ZhihuP;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.bean.Zhihu.RibaoBean;
import com.lcz.geek.CallBackss.RibaoCallBack;
import com.lcz.geek.bean.Zhihu.oldRibaoBean;
import com.lcz.geek.model.ZhihuModels.RibaoM;
import com.lcz.geek.view.ZhihuV.RibaoV;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class RibaoPresenter extends Basepresenter<RibaoV> {
    private RibaoM mRibaoM;

    public void getData() {
        mRibaoM.getdata(new RibaoCallBack() {
            @Override
            public void onSussion(RibaoBean ribaoBean) {
                if (ribaoBean != null) {
                    mview.onSussion(ribaoBean);
                }

            }

            @Override
            public void onFail(String str) {
                if (mview != null) {
                    mview.onFail(str);
                }
            }

            @Override
            public void onOldSussion(oldRibaoBean oldRibaoBean) {

            }

            @Override
            public void onoldFail(String str) {

            }
        });


    }
    public void getData2(int page){
        mRibaoM.getData2(page, new RibaoCallBack() {
            @Override
            public void onSussion(RibaoBean ribaoBean) {

            }

            @Override
            public void onFail(String str) {

            }

            @Override
            public void onOldSussion(oldRibaoBean oldRibaoBean) {
                mview.onOldSussion(oldRibaoBean);
            }

            @Override
            public void onoldFail(String str) {
                mview.onoldFail(str);
            }
        });
    }

    @Override
    protected void initModel() {
        mRibaoM = new RibaoM();
        models.add(mRibaoM);
    }
}
