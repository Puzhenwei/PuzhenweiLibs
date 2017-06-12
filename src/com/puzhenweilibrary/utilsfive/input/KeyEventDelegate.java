package com.puzhenweilibrary.utilsfive.input;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Rabe on 03/08/15.
 */
public enum KeyEventDelegate implements KeyListener {
    
    instance;
    
    public static boolean isLoggingEnabled() {
        return false;
    }
    
    public static void setLoggingEnabled(final boolean loggingEnabled) {
    }
    
    private static final String TAG = KeyEventDelegate.class.getSimpleName();
    private final List<KeyListener> keyListeners = new ArrayList<>();
    
    public static void addKeyListener(@Nullable
    final KeyListener listener) {
        if (listener != null && !instance.keyListeners.contains(listener))
            instance.keyListeners.add(listener);
    }
    
    public static void removeKeyListener(@Nullable
    final KeyListener listener) {
        if (listener != null)
            instance.keyListeners.remove(listener);
    }
    
    @Override
    public boolean onKeyUp(final int keyCode, final KeyEvent event) {
        boolean hasBeenHandled = false;
        for (final KeyListener listener : keyListeners)
            if (!hasBeenHandled)
                hasBeenHandled = listener.onKeyUp(keyCode, event);
        return hasBeenHandled;
    }
    
    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        Log.v(TAG, "[onKeyDown] " + keyCode + " event " + event);
        boolean hasBeenHandled = false;
        for (final KeyListener listener : keyListeners)
            if (!hasBeenHandled)
                hasBeenHandled = listener.onKeyDown(keyCode, event);
        return hasBeenHandled;
    }
}
