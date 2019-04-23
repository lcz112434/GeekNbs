package com.lcz.geek.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.lcz.geek.Adapters.ZhuAdaptes.Specia_itemAdapter;
import com.lcz.geek.Base.BaseActivity;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.SpecialtemBean;
import com.lcz.geek.presenter.ZhihuP.SpecialtemP;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.view.ZhihuV.SpecialitemV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Specia_itemActivity extends BaseActivity<SpecialitemV, SpecialtemP> implements SpecialitemV {

    @BindView(R.id.rlv)
    RecyclerView rlv;

    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.tv_Specialtoobar)
    TextView tvSpecialtoobar;
    private ArrayList<SpecialtemBean.StoriesBean> mList;

    private Specia_itemAdapter mSpecia_itemAdapter;
    private String mTitle;

    @Override
    protected SpecialtemP initpresenter() {
        return new SpecialtemP();
    }

    @Override
    protected int ActivityId() {
        return R.layout.activity_specia_item;
    }

    @Override
    protected void initView() {
        super.initView();
        rlv.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();

        mSpecia_itemAdapter = new Specia_itemAdapter(mList, this);
        rlv.setAdapter(mSpecia_itemAdapter);
        tv2.setText(mTitle);
        toobar.setTitle("");
        setSupportActionBar(toobar);

    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        mTitle = intent.getStringExtra("title");
        int mId = intent.getIntExtra("id", 1);
        mpresenter.setData(mId);
    }

    @Override
    public void onSussion(SpecialtemBean specialBean) {
        Log.i("tag", specialBean.getName());
        mList.addAll(specialBean.getStories());
        mSpecia_itemAdapter.setList(mList);
        mSpecia_itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String str) {
        ToastUtil.showShort(str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }



    @OnClick(R.id.tv_Specialtoobar)
    public void onViewClicked() {
        finish();
    }
}
