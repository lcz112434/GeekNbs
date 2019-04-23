package com.lcz.geek.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lcz.geek.Base.BaseActivity;
import com.lcz.geek.Base.BaseMvpView;
import com.lcz.geek.R;
import com.lcz.geek.fragment.CollectFragment;
import com.lcz.geek.fragment.GankFragment;
import com.lcz.geek.fragment.GoldFragment;
import com.lcz.geek.fragment.V2exFragment;
import com.lcz.geek.fragment.WeChatFragment;
import com.lcz.geek.fragment.ZhiHuFragment;
import com.lcz.geek.fragment.aboutFragment;
import com.lcz.geek.fragment.settingFragment;
import com.lcz.geek.presenter.MainP;
import com.lcz.geek.view.MainV;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainV, MainP> implements BaseMvpView {
    private static final String TAG = "MainActivity";
    //https://github.com/lcz112434/TestProject.git
    //李承泽 1808c 410725200011242434
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fly)
    FrameLayout fly;
    @BindView(R.id.nav)
    NavigationView nav;
    @BindView(R.id.dl)
    DrawerLayout dl;
    private final int TYPE_ZHIHU = 0;
    private final int TYPE_WECHAT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_XITU = 3;
    private final int TYPE_V2EX = 4;
    private final int TYPE_ABOUT = 7;
    private final int TYPE_SETTING = 6;
    private final int TYPE_COTTION = 5;
    @BindView(R.id.toolBarTitle)
    TextView toolBarTitle;
    @BindView(R.id.msv)
    MaterialSearchView msv;


    private int mLastFragmentPosition;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;
    private MenuItem mItem;

    @Override
    protected MainP initpresenter() {
        return new MainP();
    }

    @Override
    protected int ActivityId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolBarTitle.setTextColor(getResources().getColor(R.color.white));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(toggle);
        toggle.syncState();

        initFragment();
        initTitles();
        addZhihuiFragment();
    }

    @Override
    protected void initClick() {

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId != R.id.zixun && itemId != R.id.on) {
                    item.setChecked(true);
                    switch (itemId) {
                        case R.id.zhihu:
                            switchFragment(TYPE_ZHIHU);
                            toolBarTitle.setText(R.string.zhihu);
                            break;
                        case R.id.wechat:
                            switchFragment(TYPE_WECHAT);
                            toolBarTitle.setText(R.string.wechat);
                            break;
                        case R.id.gank:
                            switchFragment(TYPE_GANK);
                            toolBarTitle.setText(R.string.gank);
                            break;
                        case R.id.gold:
                            switchFragment(TYPE_XITU);
                            toolBarTitle.setText(R.string.xitu);
                            break;
                        case R.id.v2ex:
                            switchFragment(TYPE_V2EX);
                            toolBarTitle.setText(R.string.v2ex);
                            break;
                        case R.id.collect:
                            switchFragment(TYPE_COTTION);
                            toolBarTitle.setText(R.string.collect);
                            break;
                        case R.id.settings:
                            switchFragment(TYPE_SETTING);
                            toolBarTitle.setText(R.string.settings);
                            break;
                        case R.id.about:
                            switchFragment(TYPE_ABOUT);
                            toolBarTitle.setText(R.string.about);
                            break;
                    }
                    dl.closeDrawer(Gravity.LEFT);
                } else {
                    item.setChecked(false);
                }
                return false;
            }
        });
        msv.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "onQueryTextSubmit: " + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, "onQueryTextSubmit: " + newText);
                return false;
            }
        });
        msv.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                Log.d(TAG, "onSearchViewShown: " + "展示");
            }

            @Override
            public void onSearchViewClosed() {
                Log.d(TAG, "onSearchViewClosed: " + "取消展示");
            }
        });
    }

    private void switchFragment(int type) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(type);
        Fragment hideFragment = fragments.get(mLastFragmentPosition);

        if (!fragment.isAdded()) {
            transaction.add(R.id.fly, fragment);
        }

        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();

        mLastFragmentPosition = type;

        if (type == TYPE_WECHAT || type == TYPE_GANK) {
            mItem.setVisible(true);
        } else {
            mItem.setVisible(false);
        }

    }

    private void addZhihuiFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fly, fragments.get(0));
        transaction.commit();

        toolBarTitle.setText(R.string.zhihu);
    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(R.id.zhihu);
        titles.add(R.id.wechat);
        titles.add(R.id.gank);
        titles.add(R.id.gold);
        titles.add(R.id.v2ex);
        titles.add(R.id.collect);
        titles.add(R.id.settings);
        titles.add(R.id.about);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiHuFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new V2exFragment());
        fragments.add(new CollectFragment());
        fragments.add(new settingFragment());
        fragments.add(new aboutFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.openmenu, menu);
        mItem = menu.findItem(R.id.action_search);

        mItem.setVisible(false);
        msv.setMenuItem(mItem);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("确定退出GeekNBs吗")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();

        }
        return false;
    }
}
