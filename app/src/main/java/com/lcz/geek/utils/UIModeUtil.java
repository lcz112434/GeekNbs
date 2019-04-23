package com.lcz.geek.utils;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.lcz.geek.Base.BaseApp;
import com.lcz.geek.Base.Constants;

/**
 * 使用这个类需要把style设置成日夜间的样式:Theme.AppCompat.DayNight.NoActionBar
 */
public class UIModeUtil {

    /**
     * 夜间模式切换
     */
    public static void changeModeUI(AppCompatActivity activity){
        int currentNightMode = activity.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        if(currentNightMode == Configuration.UI_MODE_NIGHT_NO){
            //日间模式,切成夜间模式
            activity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            SpUtil.setParam(Constants.MODE,AppCompatDelegate.MODE_NIGHT_YES);
            BaseApp.mMode = AppCompatDelegate.MODE_NIGHT_YES;
        }else{
            activity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            SpUtil.setParam(Constants.MODE,AppCompatDelegate.MODE_NIGHT_NO);
            BaseApp.mMode = AppCompatDelegate.MODE_NIGHT_NO;
        }
    }

    /**
     * 设置当前的模式
     * @param activity
     */
    public static void setActModeFromSp(AppCompatActivity activity){
        int mode = (int) SpUtil.getParam(Constants.MODE, AppCompatDelegate.MODE_NIGHT_NO);
        activity.getDelegate().setLocalNightMode(mode);
    }

    /**
     * 设置当前的模式
     * @param activity
     */
    public static void setActModeUseMode(AppCompatActivity activity,int mode){
        activity.getDelegate().setLocalNightMode(mode);
    }

    public static void setAppMode(int mode){
        AppCompatDelegate.setDefaultNightMode(mode);
    }
}