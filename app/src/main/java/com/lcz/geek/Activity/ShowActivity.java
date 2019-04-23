package com.lcz.geek.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lcz.geek.Adapters.ShowAdapter;
import com.lcz.geek.CallBackss.SimepleTouchCallBack;
import com.lcz.geek.R;
import com.lcz.geek.bean.GoldBean;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ShowActivity";
    private RecyclerView mRlvShow;
    private ImageView mShowIv;
    private Toolbar mToobar;
    private Intent mIntent;
    private ArrayList<GoldBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
    }

    private void initView() {
        mRlvShow = (RecyclerView) findViewById(R.id.rlv_show);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRlvShow.setLayoutManager(linearLayoutManager);

        mIntent = getIntent();
        mList = (ArrayList<GoldBean>) mIntent.getSerializableExtra("list");
//        Log.d(TAG, "initView: "+mList.get(0).title);

        ShowAdapter showAdapter = new ShowAdapter(mList, this);
        mRlvShow.setAdapter(showAdapter);
        SimepleTouchCallBack simepleTouchCallBack = new SimepleTouchCallBack(showAdapter);
        //设置是否可以左滑
        simepleTouchCallBack.setSwienable(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simepleTouchCallBack);
        itemTouchHelper.attachToRecyclerView(mRlvShow);


        mRlvShow.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mShowIv = (ImageView) findViewById(R.id.show_iv);
        mShowIv.setOnClickListener(this);
        mToobar = (Toolbar) findViewById(R.id.toobar);
        mToobar.setTitle("");
        setSupportActionBar(mToobar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.show_iv:
                finshGold();
                break;
        }
    }

    private void finshGold() {
        mIntent.putExtra("mlist", mList);
        setResult(1000, mIntent);
        finish();
    }

    @Override
    public void onBackPressed() {

        finshGold();
    }
}
