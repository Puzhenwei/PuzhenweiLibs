package com.puzhenweilibrary.utilsfive.extensions;

import android.annotation.SuppressLint;

public class AutoCloseableExtensions {
    
    private static final String TAG = AutoCloseableExtensions.class.getSimpleName();
    
    /**
     * Quietly close a {@link AutoCloseable} dealing with nulls and exceptions.
     *
     * @param closeable to be closed.
     */
    @SuppressLint("NewApi")
    public static void quietClose(final AutoCloseable closeable) {
        try {
            if (null != closeable) {
                closeable.close();
            }
        } catch (final Exception ignore) {
        }
    }
    
    /**
     * Close a {@link AutoCloseable} dealing with nulls and exceptions. This version re-throws exceptions as runtime
     * exceptions.
     *
     * @param closeable to be closed.
     */
    @SuppressLint("NewApi")
    public static void close(final AutoCloseable closeable) {
        try {
            if (null != closeable) {
                closeable.close();
            }
        } catch (final Exception e) {
            ThrowableExtensions.rethrowUnchecked(e);
        }
    }
}