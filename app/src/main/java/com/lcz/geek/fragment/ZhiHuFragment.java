package com.lcz.geek.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.Adapters.ZHPagerAdapter;
import com.lcz.geek.fragment.ZhihuFragments.HotFragment;
import com.lcz.geek.fragment.ZhihuFragments.RibaoFragment;
import com.lcz.geek.fragment.ZhihuFragments.SpecialFragment;
import com.lcz.geek.fragment.ZhihuFragments.ThemeFragment;
import com.lcz.geek.presenter.ZhiHuP;
import com.lcz.geek.view.ZhiHuV;
import com.lcz.geek.view.ZhihuV.RibaoV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class ZhiHuFragment extends BaseFragment<ZhiHuV, ZhiHuP> implements ZhiHuV {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    @Override
    protected ZhiHuP initpresenter() {
        return new ZhiHuP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initData() {
        super.initData();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RibaoFragment());
        fragments.add(new ThemeFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new HotFragment());

        ArrayList<String> title = new ArrayList<>();
        title.add("日报");
        title.add("主题");
        title.add("专栏");
        title.add("热门");

        ZHPagerAdapter zhPagerAdapter = new ZHPagerAdapter(getChildFragmentManager(), title, fragments);
        vp.setAdapter(zhPagerAdapter);

        tab.setupWithViewPager(vp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
