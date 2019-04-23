package com.lcz.geek.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.lcz.geek.Api.ResultCallBack;
import com.lcz.geek.Base.Basepresenter;
import com.lcz.geek.bean.LoginBean;
import com.lcz.geek.model.LoginM;
import com.lcz.geek.view.LoginV;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class LoginP extends Basepresenter<LoginV> {
    private static final String TAG = "Loginp";
    protected LoginM loginM;

    public void login() {
        String userName = mview.getUserName();
        String userpsw = mview.getUserpsw();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userpsw)) {
            mview.showToast("账号密码不能为空");
            return;
        }

        loginM.login(userName, userpsw, new ResultCallBack<LoginBean>() {

            @Override
            public void onSuccess(LoginBean loginBean) {
                if (loginBean != null) {
                    Log.d(TAG, "Sussion: " + loginBean.toString());
                    if (loginBean.getCode() == 200) {
                        if (mview != null) {
                            mview.showToast("登陆成功");
                        }
                    } else {
                        if (mview != null) {
                            mview.showToast("登陆失败");
                        }
                    }
                }
            }

            @Override
            public void onFail(String str) {
                Log.d(TAG, "Fail: " + str);
                if (mview != null) {
                    mview.showToast("登陆失败");
                }
            }
        });
    }

    @Override
    protected void initModel() {
        loginM = new LoginM();
        models.add(loginM);
    }
}
