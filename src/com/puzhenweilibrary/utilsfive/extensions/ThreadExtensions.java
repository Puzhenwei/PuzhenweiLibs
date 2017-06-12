package com.puzhenweilibrary.utilsfive.extensions;

import android.support.annotation.NonNull;

/**
 * Created by Jan Rabe on 22/10/15.
 */
final public class ThreadExtensions {
    
    private static final String TAG = ThreadExtensions.class.getSimpleName();
    
    private ThreadExtensions()
        throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    
    public static void setThreadPriority(final int priority) {
        android.os.Process.setThreadPriority(priority);
    }
    
    public static void safeSleep(final int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void startNewThread(@NonNull
    final Runnable runnable) {
        new Thread(runnable).start();
    }
}