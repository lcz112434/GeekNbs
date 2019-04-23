package com.lcz.geek.Base;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public abstract class Basepresenter<V extends BaseMvpView> {
    protected V mview;
    protected ArrayList<BaseMvpModel> models = new ArrayList<>();

    public Basepresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void hind(V mview) {
        this.mview = mview;
    }

    public void onDestroy() {
        mview = null;
        if (models.size() > 0) {
            for (BaseMvpModel model : models) {
                model.Destroy();
            }
        }
    }
}
