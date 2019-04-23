package com.lcz.geek.Base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class BaseMvpModel {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();
    public void Destroy(){
        compositeDisposable.clear();
    }

}
