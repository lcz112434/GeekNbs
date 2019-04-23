package com.lcz.geek.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcz.geek.Adapters.V2exAdapter;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.bean.V2exBean;
import com.lcz.geek.presenter.V2exP;
import com.lcz.geek.view.V2exV;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/19.
 */
@SuppressLint("ValidFragment")
public class V2ex_bodyFragment extends BaseFragment<V2exV, V2exP> implements V2exV {
    private static final String TAG = "V2ex_bodyFragment";
    String name;
    @BindView(R.id.rlv_body)
    RecyclerView rlvBody;
    Unbinder unbinder;
    @BindView(R.id.v2ex_smart)
    SmartRefreshLayout v2exSmart;
    Unbinder unbinder1;

    private String mAutor;
    private String mCommentpeopel;
    private String mTwotitle;
    private String mTopic;
    private String mTitle;
    private String mCommentnum;
    private String mHref;
    private String mSrc;
    private V2exAdapter mV2exAdapter;
    private ArrayList<V2exBean> mList;


    public V2ex_bodyFragment(String name) {
        this.name = name;
    }

    @Override
    protected V2exP initpresenter() {
        return new V2exP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.layout_body_item;
    }

    @Override
    protected void initData() {
        super.initData();
        final ArrayList<V2exBean> list = new ArrayList<>();
        Log.i("Tag", name);
        if (name != null) {
            final String mUrl = "https://www.v2ex.com" + name;
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        Document doc = Jsoup.connect(mUrl).get();
                        Log.d(TAG, "mUrl: " + mUrl);

                        Elements items = doc.select("div.cell.item");
                        for (Element item : items) {
                            Element img = item.select("table tbody tr td > a > img.avatar").first();
                            //头像
                            mSrc = img.attr("src");

                            Element comment = item.select("table tbody tr td > a.count_livid").first();
                            if (comment != null) {
                                mCommentnum = comment.text();
                                mHref = comment.attr("href");
//                                Log.d(TAG, "评论数量: " + mCommentnum + ",链接地址:" + mHref);
                            }

                            Element first = item.select("table tbody tr td span.item_title > a").first();
                            mTitle = first.text();
//                           Log.d(TAG, "标题: " + mTitle);

                            Elements twoelement = item.select("table tbody tr td span.topic_info");
                            mTopic = twoelement.text();

                            Element secondtab = twoelement.select("a.node").first();
                            mTwotitle = secondtab.text();

                            Elements people = twoelement.select("strong > a");
                            if (people.size() > 0) {
                                Element autors = people.get(0);
                                mAutor = autors.text();
                            }
                            if (people.size() > 1) {
                                Element element = people.get(1);
                                mCommentpeopel = element.text();
                            }
                            V2exBean v2exBean1 = new V2exBean("http:" + mSrc, mAutor, mTitle, mCommentpeopel, mUrl, mCommentnum, mTwotitle);
                            list.add(v2exBean1);
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (list != null && list.size() > 0) {
                                    mList.addAll(list);
                                    mV2exAdapter.setList(mList);
                                    mV2exAdapter.notifyDataSetChanged();
                                }
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @Override
    protected void initView() {
        super.initView();
        mList = new ArrayList<>();
        mV2exAdapter = new V2exAdapter(mList, getActivity());
        rlvBody.setAdapter(mV2exAdapter);
        rlvBody.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvBody.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
//        /?tab=tech

        v2exSmart.setRefreshHeader(new MaterialHeader(getContext()));
        v2exSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh();
            }
        });
    }

}
