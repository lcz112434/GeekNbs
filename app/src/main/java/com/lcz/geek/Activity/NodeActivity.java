package com.lcz.geek.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lcz.geek.Adapters.NodyAdapter;
import com.lcz.geek.R;
import com.lcz.geek.bean.Car;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import qdx.stickyheaderdecoration.NormalDecoration;

public class NodeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "NodeActivity";

    private ImageView mIvFinsh;
    private Toolbar mNodeToobar;
    private RecyclerView mRlvNode;
    private ArrayList<Car> mlist;
    private NodyAdapter mNodyAdapter;
    private String mText;
    private String mText1;
    private ArrayList<Car> mCars;
    private String mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initData() {
        final String Url = "https://www.v2ex.com/";
        mlist = new ArrayList<>();

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Document doc = Jsoup.connect(Url).get();
                    Elements select = doc.select("div.cell");
                    for (Element element : select) {
                        Elements select1 = element.select("table tbody tr td span.fade");
                        mText = select1.text();
//                        Log.d(TAG, "text: "+text);


                        Elements select2 = element.select("table tbody tr td > a");
                        for (Element element1 : select2) {
                            String text1 = element1.text();
                            if (text1.length()>1) {
                                //二级列表内容
                                mResult = text1.replaceAll("\\d+", "");
                                if (mResult.equals("")) {

                                }else{
                                    Log.d(TAG, "集合内容: " + mResult);
                                    Car car = new Car(mText, mResult);
                                    mlist.add(car);
                                }
                            }
                        }
                    }
                    Elements first = doc.select("div.inner");
                    for (Element element : first) {
                        Elements first1 = element.select("table tbody tr td span.fade");
                        mText1 = first1.text();

                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mCars.addAll(mlist);
                            mNodyAdapter.setList(mCars);
                            mNodyAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    private void initView() {
        mIvFinsh = (ImageView) findViewById(R.id.iv_finsh);
        mIvFinsh.setOnClickListener(this);
        mNodeToobar = (Toolbar) findViewById(R.id.node_toobar);
        mNodeToobar.setTitle("");
        setSupportActionBar(mNodeToobar);

        mRlvNode = (RecyclerView) findViewById(R.id.rlv_node);
        NormalDecoration normalDecoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return mlist.get(i).getName();
            }
        };
        mCars = new ArrayList<>();
        mRlvNode.addItemDecoration(normalDecoration);
        mRlvNode.setLayoutManager(new LinearLayoutManager(this));
        mNodyAdapter = new NodyAdapter(mCars, this);
        mRlvNode.setAdapter(mNodyAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_finsh:
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
