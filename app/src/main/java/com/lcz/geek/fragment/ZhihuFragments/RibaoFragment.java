package com.lcz.geek.fragment.ZhihuFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcz.geek.Activity.RibaoDetailActivity;
import com.lcz.geek.Activity.TimeActivity;
import com.lcz.geek.Adapters.ZhuAdaptes.RibaoAdapter;
import com.lcz.geek.Adapters.ZhuAdaptes.RibaoVpAdapter;
import com.lcz.geek.Adapters.ZhuAdaptes.oldAdpater;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.RibaoBean;
import com.lcz.geek.bean.Zhihu.oldRibaoBean;
import com.lcz.geek.presenter.ZhihuP.RibaoPresenter;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.view.ZhihuV.RibaoV;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class RibaoFragment extends BaseFragment<RibaoV, RibaoPresenter> implements RibaoV {
    private static final String TAG = "RibaoFragment";
    @BindView(R.id.rlv)
    RecyclerView rlv;
    Unbinder unbinder;
    @BindView(R.id.vp_ribao)
    ViewPager vp_ribao;
    @BindView(R.id.smart_ribao)
    SmartRefreshLayout smartRibao;
    Unbinder unbinder1;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    Unbinder unbinder2;
    @BindView(R.id.tv_new)
    TextView tvNew;
    @BindView(R.id.rlv_old)
    RecyclerView rlvOld;
    Unbinder unbinder3;

    private ArrayList<RibaoBean.StoriesBean> mList_item;
    private ArrayList<RibaoBean.TopStoriesBean> mList_banner;
    private RibaoAdapter mRibaoAdapter;
    private int a = 10000;
    private int mTime;
    private ArrayList<oldRibaoBean.StoriesBean> mOldlist;
    private oldAdpater mOldAdpater;

    @Override
    protected RibaoPresenter initpresenter() {
        return new RibaoPresenter();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_ribao;
    }

    @Override
    protected void initView() {
        super.initView();


        mList_item = new ArrayList<>();
        mList_banner = new ArrayList<>();

        mRibaoAdapter = new RibaoAdapter(mList_item, getContext());
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        rlv.setAdapter(mRibaoAdapter);
        mRibaoAdapter.setItemclick(new RibaoAdapter.itemclick() {
            @Override
            public void onitemclick(int position) {
                RibaoBean.StoriesBean storiesBean = mList_item.get(position);
                int id = storiesBean.getId();
                Intent intent = new Intent(getActivity(), RibaoDetailActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        smartRibao.setRefreshHeader(new MaterialHeader(getContext()));
        smartRibao.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh();
            }
        });

        setoldAdapter();

        vp_ribao.setVisibility(View.VISIBLE);
        tvNew.setVisibility(View.VISIBLE);
        rlv.setVisibility(View.VISIBLE);
        rlvOld.setVisibility(View.INVISIBLE);
    }

    private void setoldAdapter() {
        rlvOld.setLayoutManager(new LinearLayoutManager(getContext()));
        mOldlist = new ArrayList<>();
        mOldAdpater = new oldAdpater(mOldlist, getContext(), mTime);

        rlvOld.setAdapter(mOldAdpater);
        rlvOld.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mOldAdpater.setItemclick(new oldAdpater.itemclick() {
            @Override
            public void onitemclick(int position) {
                oldRibaoBean.StoriesBean storiesBean = mOldlist.get(position);
                int id = storiesBean.getId();
                Intent intent = new Intent(getActivity(), RibaoDetailActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mpresenter.getData();
        Log.d(TAG, "initData: " + mTime);

    }

    @Override
    public void onSussion(final RibaoBean ribaoBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setVp(ribaoBean);
            }
        });
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

    @Override
    public void onOldSussion(oldRibaoBean oldRibaoBean) {
        if (oldRibaoBean.getStories().size() > 0) {
            mOldlist.addAll(oldRibaoBean.getStories());
            mOldAdpater.setOldlist(mOldlist);
            mOldAdpater.notifyDataSetChanged();
            Log.i("RibaoFragment", oldRibaoBean.getStories().size() + "");
        } else {
            Log.d(TAG, "onOldSussion: " + "没有数据");
        }
    }

    @Override
    public void onoldFail(String str) {
        ToastUtil.showShort(str);
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        mOldlist.clear();
        Intent intent = new Intent(getActivity(), TimeActivity.class);
        startActivityForResult(intent, 166);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 166 && resultCode == 260) {
            mTime = data.getIntExtra("time", 0);

            mpresenter.getData2(mTime);
            Log.i("tag", mTime + "");
            mOldAdpater.setTime(mTime);

            vp_ribao.setVisibility(View.INVISIBLE);
            tvNew.setVisibility(View.INVISIBLE);
            rlv.setVisibility(View.INVISIBLE);
            rlvOld.setVisibility(View.VISIBLE);
        }
    }


    private void setVp(RibaoBean ribaoBean) {
        mList_item.addAll(ribaoBean.getStories());
        mRibaoAdapter.setList_item(mList_item);
        mRibaoAdapter.notifyDataSetChanged();

        mList_banner.addAll(ribaoBean.getTop_stories());
        ArrayList<View> views = new ArrayList<>();
        for (int i = 0; i < mList_banner.size(); i++) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.ribao_vp, null);
            views.add(inflate);
        }
        final RibaoVpAdapter ribaoVpAdapter = new RibaoVpAdapter(views, getActivity(), mList_banner);
        vp_ribao.setAdapter(ribaoVpAdapter);
        ribaoVpAdapter.setItemclick(new RibaoVpAdapter.itemclick() {
            @Override
            public void onitemclick(int position, RibaoBean.TopStoriesBean topStoriesBean) {
                int id = topStoriesBean.getId();
                Intent intent = new Intent(getActivity(), RibaoDetailActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (a > 0) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            a--;
                            if (a % 5 == 4) {
                                vp_ribao.setCurrentItem(0);
                            } else if (a % 5 == 3) {
                                vp_ribao.setCurrentItem(1);
                            } else if (a % 5 == 2) {
                                vp_ribao.setCurrentItem(2);
                            } else if (a % 5 == 1) {
                                vp_ribao.setCurrentItem(3);
                            } else if (a % 5 == 0) {
                                vp_ribao.setCurrentItem(4);
                            }
                        }
                    });
                } else {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 3000, 3000);
    }
}
