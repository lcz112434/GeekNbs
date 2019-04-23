package com.lcz.geek.fragment.ZhihuFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcz.geek.Activity.WebActivity;
import com.lcz.geek.Adapters.ZhuAdaptes.HoAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.HotBean;
import com.lcz.geek.presenter.ZhihuP.HotP;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.view.ZhihuV.HotV;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment<HotV, HotP> implements HotV {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    Unbinder unbinder;
    @BindView(R.id.smart_hot)
    SmartRefreshLayout smartHot;
    Unbinder unbinder1;
    private ArrayList<HotBean.RecentBean> mList;
    private HoAdapter mHoAdapter;

    @Override
    protected HotP initpresenter() {
        return new HotP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        super.initView();
        mList = new ArrayList<>();
        mHoAdapter = new HoAdapter(mList, getContext());
        rlv.setAdapter(mHoAdapter);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mHoAdapter.setIteclick(new HoAdapter.iteclick() {
            @Override
            public void itemclick(int id) {
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        smartHot.setRefreshHeader(new MaterialHeader(getContext()));
        smartHot.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mpresenter.getData();
    }

    @Override
    public void onSussion(HotBean hotBean) {
        mList.addAll(hotBean.getRecent());
        mHoAdapter.setList(mList);
        mHoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFali(final String str) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtil.showShort(str);
            }
        });
    }

}
