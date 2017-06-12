package com.puzhenweilibrary.Log;

import android.util.Log;

public class DLog {

    private static boolean DEBUG = true;
    private static boolean ERROR = true;
    private static boolean WARN = true;
    private static boolean INFO = true;
    private static boolean ASSERT = true;
    private static boolean VERBOSE = true;
    private final static int LEVEL_DEBUG = 0;// 0, 全部打开
    private final static int LEVEL_RELEASE = 1;// 1,发布,打开w,e
    private final static int LEVEL_EXTEND = 2;// 其余, 可扩展等级
    private final static String TAG = "DLog";

    /**
     * 初始化日志
     *
     * @param logLevel   0, 1, 2
     * @param needLog    必须为true
     * @param notNeedLog 必须为false
     */
    public static void init(int logLevel, boolean needLog, boolean notNeedLog) {
        switch (logLevel) {
            case LEVEL_DEBUG:
                DEBUG = needLog;
                ERROR = needLog;
                WARN = needLog;
                INFO = needLog;
                ASSERT = needLog;
                VERBOSE = needLog;
                break;
            case LEVEL_RELEASE:
                DEBUG = notNeedLog;
                ERROR = needLog;
                WARN = needLog;
                INFO = notNeedLog;
                ASSERT = notNeedLog;
                VERBOSE = notNeedLog;
                break;
            case LEVEL_EXTEND:
                break;
        }
    }

    public static void e(String s) {
        if (ERROR)
            Log.e(TAG, s);
    }

    public static void e(String s, Throwable e) {
        if (ERROR)
            Log.e(TAG, s, e);
    }

    public static void d(String s, Throwable e) {
        if (DEBUG)
            Log.e(TAG, s, e);
    }

    public static void d(String s) {
        if (DEBUG)
            Log.d(TAG, s);
    }

    public static void i(String s) {
        if (INFO)
            Log.i(TAG, s);
    }

    public static void w(String s) {
        if (WARN)
            Log.w(TAG, s);
    }

    public static void v(String s) {
        if (VERBOSE)
            Log.v(TAG, s);
    }

    public static void e(String tag, String s) {
        if (ERROR)
            Log.e(tag, s);
    }

    public static void e(String tag, String s, Throwable e) {
        if (ERROR)
            Log.e(tag, s, e);
    }

    public static void w(String tag, String s, Throwable e) {
        if (WARN)
            Log.w(tag, s, e);
    }

    public static void d(String tag, String s, Throwable e) {
        if (DEBUG)
            Log.e(tag, s, e);
    }

    public static void d(String tag, String s) {
        if (DEBUG)
            Log.d(tag, s);
    }

    public static void i(String tag, String s) {
        if (INFO)
            Log.i(tag, s);
    }

    public static void w(String tag, String s) {
        if (WARN)
            Log.w(tag, s);
    }

    public static void v(String tag, String s) {
        if (VERBOSE)
            Log.v(tag, s);
    }
}
