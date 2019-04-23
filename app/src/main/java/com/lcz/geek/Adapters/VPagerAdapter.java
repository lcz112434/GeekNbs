package com.lcz.geek.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.bean.V2exTabBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class VPagerAdapter extends FragmentPagerAdapter {
    ArrayList<String> title;
    ArrayList<BaseFragment> mFragments;

    public VPagerAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.title = title;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
