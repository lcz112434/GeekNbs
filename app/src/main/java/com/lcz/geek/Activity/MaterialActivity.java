package com.lcz.geek.Activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lcz.geek.R;

public class MaterialActivity extends AppCompatActivity {

    private Toolbar mToobar;
    private CollapsingToolbarLayout mCllayout;
    private AppBarLayout mAppBar;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        initView();
    }

    private void initView() {
        mToobar = (Toolbar) findViewById(R.id.toobar);
        setSupportActionBar(mToobar);
        mCllayout = (CollapsingToolbarLayout) findViewById(R.id.cllayout);
        mAppBar = (AppBarLayout) findViewById(R.id.appBar);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
    }
}
