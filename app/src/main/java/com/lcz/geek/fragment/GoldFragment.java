package com.lcz.geek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lcz.geek.Activity.ShowActivity;
import com.lcz.geek.Adapters.GoldPagerAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.GoldBean;
import com.lcz.geek.presenter.GoldP;
import com.lcz.geek.view.GoldV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class GoldFragment extends BaseFragment<GoldV, GoldP> implements GoldV {
    @BindView(R.id.tab_gold)
    TabLayout tabGold;
    @BindView(R.id.iv_gold)
    ImageView ivGold;
    @BindView(R.id.vp_gold)
    ViewPager vpGold;
    Unbinder unbinder;
    Unbinder unbinder1;
    private ArrayList<GoldBean> mList;
    private ArrayList<BaseFragment> mFragments;

    @Override
    protected GoldP initpresenter() {
        return new GoldP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView() {
        super.initView();
        initList();
        setTab();
    }

    private void setTab() {
        initFragments();
        GoldPagerAdapter goldPagerAdapter = new GoldPagerAdapter(getChildFragmentManager(), mList, mFragments);
        vpGold.setAdapter(goldPagerAdapter);
        tabGold.setupWithViewPager(vpGold);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).checked) {
                mFragments.add(Gold_bodyFragment.getInstead(mList.get(i).title));
            }
        }
    }

    private void initList() {
        mList = new ArrayList<>();
        mList.add(new GoldBean("Android", true));
        mList.add(new GoldBean("iOS", true));
        mList.add(new GoldBean("前段", true));
        mList.add(new GoldBean("后端", true));
        mList.add(new GoldBean("设计", true));
        mList.add(new GoldBean("产品", true));
        mList.add(new GoldBean("阅读", true));
        mList.add(new GoldBean("工具资源", true));
    }


    @OnClick(R.id.iv_gold)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), ShowActivity.class);
        intent.putExtra("list",mList);
        startActivityForResult(intent,20000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==20000 && resultCode==1000){
            mList = (ArrayList<GoldBean>) data.getSerializableExtra("mlist");
            setTab();
        }
    }
}
