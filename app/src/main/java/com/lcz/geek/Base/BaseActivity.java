package com.lcz.geek.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lcz.geek.view.LoginV;

import butterknife.ButterKnife;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public abstract class BaseActivity<V extends BaseMvpView,P extends Basepresenter>
        extends AppCompatActivity implements BaseMvpView{

    protected P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ActivityId());
        ButterKnife.bind(this);
        mpresenter = initpresenter();
        if(mpresenter!=null){
            mpresenter.hind((V) this);
        }
        initView();
        initData();
        initClick();
    }

    protected abstract P initpresenter();

    protected abstract int ActivityId();


    protected void initClick() {
    }

    protected void initView() {
    }

    protected void initData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresenter.onDestroy();
        mpresenter=null;
    }
}
