package com.lcz.geek.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.bean.GoldBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class GoldPagerAdapter extends FragmentStatePagerAdapter{
    ArrayList<GoldBean> titles;
    ArrayList<BaseFragment> mFragments;
    ArrayList<String> mnewtietl=new ArrayList<>();


    public GoldPagerAdapter(FragmentManager fm, ArrayList<GoldBean> title, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.titles = title;
        mFragments = fragments;


        for (int i = 0; i <titles.size() ; i++) {
            GoldBean goldBean = title.get(i);
            if(goldBean.checked){
                mnewtietl.add(goldBean.title);
            }
        }
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
        return mnewtietl.get(position);
    }
}
