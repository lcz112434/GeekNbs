package com.lcz.geek.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class ZHPagerAdapter extends FragmentPagerAdapter{
    ArrayList<String> title;
    ArrayList<Fragment> mFragments;

    public ZHPagerAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> fragments) {
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
