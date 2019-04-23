package com.lcz.geek.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lcz.geek.Adapters.VPagerAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.fragment.Gank.AndroidFragment;
import com.lcz.geek.fragment.Gank.AppFragment;
import com.lcz.geek.fragment.Gank.FuliFragment;
import com.lcz.geek.fragment.Gank.iOSFragment;
import com.lcz.geek.presenter.GankP;
import com.lcz.geek.view.GankV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class GankFragment extends BaseFragment<GankV, GankP> implements GankV {
    @BindView(R.id.gank_tab)
    TabLayout gankTab;
    @BindView(R.id.gank_vp)
    ViewPager gankVp;
    Unbinder unbinder;

    @Override
    protected GankP initpresenter() {
        return new GankP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initView() {
        super.initView();
        ArrayList<String> title = new ArrayList<>();
        title.add("android");
        title.add("IOS");
        title.add("前端");
        title.add("福利");

        ArrayList<BaseFragment> list = new ArrayList<>();
        list.add(new AndroidFragment());
        list.add(new iOSFragment());
        list.add(new AppFragment());
        list.add(new FuliFragment());

        VPagerAdapter vPagerAdapter = new VPagerAdapter(getChildFragmentManager(), title, list);
        gankVp.setAdapter(vPagerAdapter);
        gankTab.setupWithViewPager(gankVp);
    }
}
