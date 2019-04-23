package com.lcz.geek.fragment.Gank;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lcz.geek.Adapters.FuliAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.FuliBean;
import com.lcz.geek.presenter.Gank.FuliP;
import com.lcz.geek.view.Gank.FuliV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class FuliFragment extends BaseFragment<FuliV, FuliP> implements FuliV {

    private static final String TAG = "FuliFragment";
    int page = 1;
    @BindView(R.id.fuli_rlv)
    RecyclerView fuliRlv;
    Unbinder unbinder;
    @BindView(R.id.fuli_iv)
    ImageView fuliIv;
    Unbinder unbinder1;
    private ArrayList<FuliBean.ResultsBean> mList;
    private FuliAdapter mFuliAdapter;

    @Override
    protected FuliP initpresenter() {
        return new FuliP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_fuli;
    }

    @Override
    protected void initView() {
        super.initView();
        fuliRlv.setVisibility(View.VISIBLE);
        fuliIv.setVisibility(View.INVISIBLE);
        fuliRlv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mList = new ArrayList<>();
        mFuliAdapter = new FuliAdapter(mList, getContext());
        fuliRlv.setAdapter(mFuliAdapter);
        mFuliAdapter.setItemclick(new FuliAdapter.itemclick() {
            @Override
            public void onitemclick(int position) {
                String url = mList.get(position).getUrl();

                RequestOptions requestOptions = new RequestOptions().centerCrop();
                Glide.with(getActivity()).load(url).apply(requestOptions).into(fuliIv);
                fuliRlv.setVisibility(View.INVISIBLE);
                fuliIv.setVisibility(View.VISIBLE);
                fuliIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fuliRlv.setVisibility(View.VISIBLE);
                        fuliIv.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });


    }

    @Override
    protected void initData() {
        super.initData();
        mpresenter.getData(page);
    }

    @Override
    public void onSussion(FuliBean listBean) {
        mList.addAll(listBean.getResults());
        mFuliAdapter.setList(mList);
        mFuliAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String str) {
        Log.d(TAG, "onFail: " + str);
    }


}
