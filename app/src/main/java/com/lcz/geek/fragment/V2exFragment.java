package com.lcz.geek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lcz.geek.Activity.NodeActivity;
import com.lcz.geek.Adapters.V2exPagerAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.V2exTabBean;
import com.lcz.geek.presenter.V2exP;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.view.V2exV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class V2exFragment extends BaseFragment<V2exV, V2exP> implements V2exV {
    private static final String TAG = "V2exFragment";
    @BindView(R.id.tab_v2ex)
    TabLayout tabV2ex;
    @BindView(R.id.vp_v2ex)
    ViewPager vpV2ex;
    Unbinder unbinder;
    @BindView(R.id.tab_iv)
    ImageView tabIv;
    Unbinder unbinder1;
    private String url = "https://www.v2ex.com/";
    private ArrayList<V2exTabBean> mList;

    @Override
    protected V2exP initpresenter() {
        return new V2exP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_v2ex;
    }

    @Override
    protected void initData() {
        super.initData();

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    mList = new ArrayList<>();
                    Document doc = Jsoup.connect(url).get();
                    //查找id是Tabs的div元素
                    Elements elements = doc.select("div#Tabs");
                    Elements alltabs = elements.select("a[href]");
                    for (Element alltab : alltabs) {
                        String linkHref = alltab.attr("href");
                        String tab = alltab.text();
                        Log.d(TAG, "  : " + linkHref + ",tab:" + tab);
                        mList.add(new V2exTabBean(linkHref, tab));
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mList.size() > 0) {
                                ArrayList<BaseFragment> baseFragments = new ArrayList<>();
                                for (int i = 0; i < mList.size(); i++) {
                                    baseFragments.add(new V2ex_bodyFragment(mList.get(i).html));
                                }
                                V2exPagerAdapter v2exPagerAdapter = new V2exPagerAdapter(getChildFragmentManager(), mList, baseFragments);
                                vpV2ex.setAdapter(v2exPagerAdapter);
                                tabV2ex.setupWithViewPager(vpV2ex);

                            } else {
                                ToastUtil.showShort("暂无数据");
                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }



    @OnClick(R.id.tab_iv)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), NodeActivity.class);
        startActivity(intent);
    }
}
