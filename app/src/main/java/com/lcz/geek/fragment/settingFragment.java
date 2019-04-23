package com.lcz.geek.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.presenter.EmptyP;
import com.lcz.geek.view.EmptyV;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class settingFragment extends BaseFragment<EmptyV, EmptyP> implements EmptyV {
    @BindView(R.id.ck_cache)
    CheckBox ckCache;
    @BindView(R.id.ck_image)
    CheckBox ckImage;
    @BindView(R.id.ck_night)
    CheckBox ckNight;
    @BindView(R.id.tv_clear)
    TextView tvClear;
    @BindView(R.id.ck_update)
    TextView ckUpdate;
    Unbinder unbinder;

    @Override
    protected EmptyP initpresenter() {
        return new EmptyP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView() {
        super.initView();
        ckCache.setChecked(true);
    }
}
