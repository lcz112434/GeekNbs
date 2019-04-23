package com.lcz.geek.presenter;

import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.CallBackss.WeChatCallback.MyCallBack;
import com.lcz.geek.bean.WeChatListBean;
import com.lcz.geek.model.WeChatM;
import com.lcz.geek.view.WeChatV;
import com.lcz.geek.view.ZhiHuV;

import java.util.Map;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class WeChatP extends Basepresenter<WeChatV> {

    private WeChatM mWeChatM;

    public void setData(Map<String,Object> map) {
        mWeChatM.getData(map ,new MyCallBack<WeChatListBean>() {
            @Override
            public void onSussion(WeChatListBean listBean) {
                if (listBean != null) {
                    mview.onSussion(listBean);
                }
            }

            @Override
            public void onFail(String str) {
                mview.onFail(str);
            }
        });
    }

    @Override
    protected void initModel() {
        mWeChatM = new WeChatM();
        models.add(mWeChatM);
    }
}
