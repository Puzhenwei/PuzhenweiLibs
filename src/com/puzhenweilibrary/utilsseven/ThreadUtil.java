package com.puzhenweilibrary.utilsseven;

import android.os.Looper;

/**
 * ThreadUtil helps to manage thread conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ThreadUtil {

    public static boolean isMain() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}