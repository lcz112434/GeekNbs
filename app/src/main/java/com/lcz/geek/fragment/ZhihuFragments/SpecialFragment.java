package com.lcz.geek.fragment.ZhihuFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcz.geek.Activity.Specia_itemActivity;
import com.lcz.geek.Adapters.ZhuAdaptes.SpecialAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.CallBackss.ZhihuCallback.ItemClick;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.SpecialBean;
import com.lcz.geek.presenter.ZhihuP.SpecialP;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.view.ZhihuV.SpecialV;
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
public class SpecialFragment extends BaseFragment<SpecialV, SpecialP> implements SpecialV {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    Unbinder unbinder;
    @BindView(R.id.smart_special)
    SmartRefreshLayout smartSpecial;
    private ArrayList<SpecialBean.DataBean> mList;
    private SpecialAdapter mSpecialAdapter;

    @Override
    protected SpecialP initpresenter() {
        return new SpecialP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initView() {
        super.initView();
        mList = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rlv.setLayoutManager(gridLayoutManager);
        mSpecialAdapter = new SpecialAdapter(mList, getActivity());
        rlv.setAdapter(mSpecialAdapter);
        mSpecialAdapter.setItemClick(new ItemClick() {
            @Override
            public void onitemclick(int position, int id) {
                Intent intent = new Intent(getContext(), Specia_itemActivity.class);
                intent.putExtra("title", mList.get(position).getName());
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        smartSpecial.setRefreshHeader(new MaterialHeader(getContext()));
        smartSpecial.setOnRefreshListener(new OnRefreshListener() {
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
    public void onSussion(SpecialBean specialBean) {
        mList.addAll(specialBean.getData());
        mSpecialAdapter.setList(mList);
        mSpecialAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(final String str) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtil.showShort(str);
            }
        });
    }
}
