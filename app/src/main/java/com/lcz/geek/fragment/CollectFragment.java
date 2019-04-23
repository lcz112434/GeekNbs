package com.lcz.geek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcz.geek.Activity.FlowActivity;
import com.lcz.geek.Activity.MaterialActivity;
import com.lcz.geek.Adapters.CollectAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.Car;
import com.lcz.geek.presenter.EmptyP;
import com.lcz.geek.view.EmptyV;

import java.text.Normalizer;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import qdx.stickyheaderdecoration.NormalDecoration;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class CollectFragment extends BaseFragment<EmptyV, EmptyP> implements EmptyV {

    Unbinder unbinder;
    Unbinder unbinder1;
    @BindView(R.id.collect_rlv)
    RecyclerView collectRlv;
    Unbinder unbinder2;
    private ArrayList<Car> mCars;

    @Override
    protected EmptyP initpresenter() {
        return new EmptyP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_collect;
    }

    @Override
    protected void initData() {
        super.initData();
        mCars = new ArrayList<>();
        mCars.add(new Car("奥迪", "A"));
        mCars.add(new Car("阿尔法罗密欧", "A"));
        mCars.add(new Car("阿斯顿马丁", "A"));
        mCars.add(new Car("ALPINA", "A"));
        mCars.add(new Car("安凯客车", "A"));


        mCars.add(new Car("本田", "B"));
        mCars.add(new Car("别克", "B"));
        mCars.add(new Car("奔驰", "B"));
        mCars.add(new Car("宝马", "B"));
        mCars.add(new Car("保时捷", "B"));
        mCars.add(new Car("比亚迪", "B"));
        mCars.add(new Car("北京", "B"));
        mCars.add(new Car("宾利", "B"));
        mCars.add(new Car("巴博斯", "B"));
        mCars.add(new Car("布加迪威龙", "B"));

        mCars.add(new Car("长安", "C"));
        mCars.add(new Car("长城", "C"));

        mCars.add(new Car("大众", "D"));
        mCars.add(new Car("东南", "D"));
        mCars.add(new Car("东风", "D"));
        mCars.add(new Car("DS", "D"));
        mCars.add(new Car("道奇", "D"));
        mCars.add(new Car("东风小康", "D"));

        setData();
    }

    private void setData() {
        collectRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        CollectAdapter collectAdapter = new CollectAdapter(mCars, getContext());
        //返回头部的内容
        collectRlv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        NormalDecoration normalDecoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return mCars.get(i).getName();
            }
        };
        //自定义布局
        normalDecoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(int i) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.head_item, null);
                TextView tv = inflate.findViewById(R.id.tv);
                tv.setText(mCars.get(i).getName());

                return inflate;
            }
        });
        normalDecoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int i) {
                //点击事件
//                Intent intent = new Intent(getContext(), FlowActivity.class);
                Intent intent2 = new Intent(getContext(), MaterialActivity.class);
                startActivity(intent2);
            }
        });
        collectRlv.addItemDecoration(normalDecoration);
        collectRlv.setAdapter(collectAdapter);
    }
}
