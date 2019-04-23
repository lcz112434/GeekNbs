package com.lcz.geek.presenter.ZhihuP;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.CallBackss.ZhihuCallback.SpecialCallBack;
import com.lcz.geek.bean.Zhihu.SpecialBean;
import com.lcz.geek.model.ZhihuModels.SpecialM;
import com.lcz.geek.view.ZhihuV.SpecialV;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class SpecialP extends Basepresenter<SpecialV>{
    private SpecialM mSpecialM;

    public void getData(){
        mSpecialM.getData(new SpecialCallBack() {
            @Override
            public void onSussion(SpecialBean specialBean) {
                if(mview!=null){
                    mview.onSussion(specialBean);
                }
            }

            @Override
            public void onFail(String str) {
                if(mview!=null){
                    mview.onFail(str);
                }
            }
        });
    }
    @Override
    protected void initModel() {
        mSpecialM=new SpecialM();
        models.add(mSpecialM);
    }
}
