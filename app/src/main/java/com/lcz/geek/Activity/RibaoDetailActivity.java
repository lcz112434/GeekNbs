package com.lcz.geek.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lcz.geek.Base.BaseActivity;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.RibaoitemBean;
import com.lcz.geek.presenter.ZhihuP.DetailsP;
import com.lcz.geek.utils.SystemUtil;
import com.lcz.geek.view.ZhihuV.DetailsV;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RibaoDetailActivity extends BaseActivity<DetailsV, DetailsP> implements DetailsV {

    private static final String TAG = "RibaoDetailActivity";
    @BindView(R.id.detail_iv)
    ImageView detailIv;
    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.cllayout)
    CollapsingToolbarLayout cllayout;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.detail_web)
    WebView detailWeb;
    @BindView(R.id.nescll)
    NestedScrollView nescll;
    @BindView(R.id.title_toobar)
    TextView titleToobar;
    @BindView(R.id.iv_return)
    ImageView ivReturn;
    private int mId;
    private String mImage;

    @Override
    protected DetailsP initpresenter() {
        return new DetailsP();
    }

    @Override
    protected int ActivityId() {
        return R.layout.activity_ribao_detail;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        mId = intent.getIntExtra("id", 1);
        mpresenter.getData(mId);
    }

    @Override
    public void onSussion(RibaoitemBean bean) {
        mImage = bean.getImage();
        Log.d(TAG, "onSussion: " + mImage);
        final String share_url = bean.getShare_url();
        final String title = bean.getTitle();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                detailWeb.loadUrl(share_url);
                detailWeb.setWebViewClient(new WebViewClient());

                toobar.setTitle(title);

                setSupportActionBar(toobar);

                Glide.with(RibaoDetailActivity.this).load(mImage).into(detailIv);
                appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                    @Override
                    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                        int imgHeight = SystemUtil.dp2px(256);
                        //verticalOffset 0到-768
                        //verticalOffset / imgHeight(768)范围:0到-1
                        float rate = 1 + verticalOffset * 2.0f / imgHeight;
                        if (rate >= 0) {
                            detailIv.setAlpha(rate);
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onFali(String str) {
        Log.d(TAG, "onFali: " + str);
    }


    @OnClick(R.id.iv_return)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
