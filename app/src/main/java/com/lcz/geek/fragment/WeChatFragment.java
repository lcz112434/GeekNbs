package com.lcz.geek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcz.geek.Activity.WebActivity;
import com.lcz.geek.Adapters.WeChatAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.WeChatListBean;
import com.lcz.geek.presenter.WeChatP;
import com.lcz.geek.view.WeChatV;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class WeChatFragment extends BaseFragment<WeChatV, WeChatP> implements WeChatV {
    private static final String TAG = "WeChatFragment";
    @BindView(R.id.rlv_wechat)
    RecyclerView rlvWechat;
    Unbinder unbinder;
    @BindView(R.id.smart_wehat)
    SmartRefreshLayout smartWehat;
    Unbinder unbinder1;
    private ArrayList<WeChatListBean.NewslistBean> mList = new ArrayList<>();
    private int page = 1;
    private WeChatAdapter mWeChatAdapter;
    private HashMap<String, Object> mMap;

    @Override
    protected WeChatP initpresenter() {
        return new WeChatP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {
        super.initView();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rlvWechat.setLayoutManager(linearLayoutManager);
        mWeChatAdapter = new WeChatAdapter(mList, getContext());
        rlvWechat.setAdapter(mWeChatAdapter);
        mWeChatAdapter.setWechatitemclick(new WeChatAdapter.Wechatitemclick() {
            @Override
            public void itemclick(String url) {
                Log.i("tag", url);
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        smartWehat.setRefreshHeader(new MaterialHeader(getContext()));
        smartWehat.setRefreshFooter(new ClassicsFooter(getContext()));
        smartWehat.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mList.clear();
                mpresenter.setData(mMap);
                mWeChatAdapter.notifyDataSetChanged();
                refreshlayout.finishRefresh();
            }
        });
        smartWehat.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                mpresenter.setData(mMap);
                mWeChatAdapter.notifyDataSetChanged();
                refreshlayout.finishLoadmore();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mMap = new HashMap<>();
        mMap.put("key", "52b7ec3471ac3bec6846577e79f20e4c");
        mMap.put("num", "10");
        mMap.put("page", page);
        mpresenter.setData(mMap);

    }

    @Override
    public void onSussion(WeChatListBean listBean) {
        Log.d(TAG, "onSussion: " + listBean.getMsg());
        Log.i("tag", listBean.getCode() + "");
        if (listBean != null && mList != null) {
            mList.addAll(listBean.getNewslist());
            mWeChatAdapter.setMlist(mList);
            mWeChatAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String str) {
        Log.i(TAG, str);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
