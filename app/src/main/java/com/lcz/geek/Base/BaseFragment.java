package com.lcz.geek.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public abstract class BaseFragment<V extends BaseMvpView,P extends Basepresenter>
        extends Fragment implements BaseMvpView{

    protected P mpresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getFragmentId(), null);
        ButterKnife.bind(this,inflate);
        mpresenter = initpresenter();
        if(mpresenter!=null){
        mpresenter.hind((V) this);
        }
        initView();
        initData();
        initClick();
        return inflate;
    }

    protected abstract P initpresenter();

    protected void initClick() {
    }

    protected  void initView(){}

    protected  void initData(){}

    protected abstract int getFragmentId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mpresenter.onDestroy();
        mpresenter=null;
    }
}
