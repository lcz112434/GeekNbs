package com.lcz.geek.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lcz.geek.R;
import com.lcz.geek.utils.ToastUtil;
import com.lcz.geek.wight.FlowLayout;

import java.util.ArrayList;

public class FlowActivity extends AppCompatActivity {

    private FlowLayout mFl;
    private ArrayList<String> Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        inidata();
        initView();
    }

    private void inidata() {
        Data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Data.add("流式布局:" + i);
        }
    }

    private void initView() {
        mFl = (FlowLayout) findViewById(R.id.fl);
        for (int i = 0; i < 30; i++) {
            TextView textview = (TextView) LayoutInflater.from(this).inflate(R.layout.layout_able, null);
            textview.setText(Data.get(i));
            final int finalI = i;
            textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtil.showShort(Data.get(finalI));
                }
            });
            mFl.addView(textview);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
