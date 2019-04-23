package com.lcz.geek.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.lcz.geek.Base.BaseActivity;
import com.lcz.geek.R;
import com.lcz.geek.presenter.LoginP;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.view.LoginV;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginV, LoginP> implements LoginV {
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected LoginP initpresenter() {
        return new LoginP();
    }

    @Override
    protected int ActivityId() {
        return R.layout.activity_login;
    }

    @Override
    public String getUserName() {
        return etName.getText().toString().trim();
    }

    @Override
    public String getUserpsw() {
        EventBus.getDefault().register(this);

        return etPsw.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showShort(msg);
    }


    @OnClick(R.id.btn)
    public void onViewClicked() {
        mpresenter.login();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//    }
}
