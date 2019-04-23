package com.lcz.geek.utils;

import android.util.Log;

import com.lcz.geek.Base.Constants;

/**
 * Created by asus on 2019/3/5.
 */

public class Logger {
    public static void logD(String tag,String msg){
        if (Constants.isDebug){
            Log.d(tag, "logD: "+msg);
        }
    }
}
