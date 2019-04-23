package com.lcz.geek.fragment.Gank;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcz.geek.Adapters.GankAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.GankListBean;
import com.lcz.geek.presenter.Gank.GankAndroidP;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.view.Gank.GankAndroidV;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.FalsifyFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/19.
 */
@SuppressLint("ValidFragment")
public class AndroidFragment extends BaseFragment<GankAndroidV, GankAndroidP> implements GankAndroidV {
    private static final String TAG = "AndroidFragment";
    String name = "Android";

    @BindView(R.id.rlv_gank_android)
    RecyclerView rlvGankAndroid;
    int page = 1;
    @BindView(R.id.smrt)
    SmartRefreshLayout smrt;

    private ArrayList<GankListBean.ResultsBean> mlist;
    private GankAdapter mGankAdapter;

    @Override
    protected GankAndroidP initpresenter() {
        return new GankAndroidP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.layout_gank_1;
    }

    @Override
    protected void initView() {
        super.initView();
        mlist = new ArrayList<>();
        if (name != null) {
            String img = "http://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg";
            mGankAdapter = new GankAdapter(mlist, getContext(), name, img);
            Log.i("Tag",img);
            rlvGankAndroid.setAdapter(mGankAdapter);
            rlvGankAndroid.setLayoutManager(new LinearLayoutManager(getActivity()));
            rlvGankAndroid.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

            smrt.setRefreshHeader(new MaterialHeader(getContext()));
            smrt.setRefreshFooter(new FalsifyFooter(getContext()));
            smrt.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    page++;
                    mlist.clear();
                    initData();
                    mGankAdapter.notifyDataSetChanged();
                    refreshlayout.finishLoadmore();
                }
            });
            smrt.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    mlist.clear();
                    initData();
                    refreshlayout.finishRefresh();
                }
            });
        }
    }

    @Override
    protected void initData() {
        super.initData();
        int num = 20;
        String path = name + "/" + num + "/" + page;
        mpresenter.getData(path);
    }

    @Override
    public void onSussion(GankListBean listBean) {
        if (listBean != null) {
            mlist.addAll(listBean.getResults());
            mGankAdapter.setMlist(mlist);
            mGankAdapter.notifyDataSetChanged();
        } else {
            ToastUtil.showShort("错误");
        }
    }

    @Override
    public void onFail(String str) {
        Log.d(TAG, "onFail: " + str);
    }


}
