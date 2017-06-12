package com.puzhenweilibrary.utilsone;

import android.util.Log;

/**
 * Log统一管理类
 * 
 * @author XiaoWei
 * @date 2015-4-24 16:48:39
 */
public final class MyLog {

    private MyLog() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static final boolean DEBUG = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "dahuoshua";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (DEBUG)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (DEBUG)
            Log.d(TAG, msg);
    }

    public static void w(String msg) {
        if (DEBUG)
            Log.w(TAG, msg);
    }

    public static void e(String msg) {
        if (DEBUG)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (DEBUG)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (DEBUG)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (DEBUG)
            Log.d(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (DEBUG)
            Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (DEBUG)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (DEBUG)
            Log.v(tag, msg);
    }
}