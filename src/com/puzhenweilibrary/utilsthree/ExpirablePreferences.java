package com.puzhenweilibrary.utilsthree;

import android.content.Context;

/**
 * Created by munix on 25/01/2017.
 */
public class ExpirablePreferences {
    
    private static DiskCache getSharedPreferenceManager(Context context) {
        try {
            return DiskCache.get(context);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Elimina una preferencia
     *
     * @param context
     * @param key
     */
    public static void delete(Context context, String key) {
        try {
            getSharedPreferenceManager(context).remove(key);
        } catch (Exception e) {
        }
    }
    
    /**
     * Guardar una preferencia de tipo String
     *
     * @param context
     * @param key
     * @param value
     */
    public static void write(Context context, String key, String value, int expireTime) {
        try {
            getSharedPreferenceManager(context).put(key, value, expireTime);
        } catch (Exception e) {
        }
    }
    
    /**
     * Guarda una preferencia de tipo String durante un año
     *
     * @param context
     * @param key
     * @param value
     */
    public static void write(Context context, String key, String value) {
        write(context, key, value, DiskCache.TIME_YEAR);
    }
    
    /**
     * Guardar una preferencia de tipo Boolean
     *
     * @param context
     * @param key
     * @param value
     */
    public static void write(Context context, String key, Boolean value, int expireTime) {
        try {
            getSharedPreferenceManager(context).put(key, value, expireTime);
        } catch (Exception e) {
        }
    }
    
    /**
     * Guarda una preferencia de tipo Boolean durante un año
     *
     * @param context
     * @param key
     * @param value
     */
    public static void write(Context context, String key, Boolean value) {
        write(context, key, value, DiskCache.TIME_YEAR);
    }
    
    /**
     * Guardar una preferencia de tipo long
     *
     * @param context
     * @param key
     * @param value
     */
    public static void write(Context context, String key, long value, int expireTime) {
        try {
            getSharedPreferenceManager(context).put(key, String.valueOf(value), expireTime);
        } catch (Exception e) {
        }
    }
    
    /**
     * Guardar una preferencia de tipo long durante un año
     *
     * @param context
     * @param key
     * @param value
     */
    public static void write(Context context, String key, long value) {
        write(context, key, value, DiskCache.TIME_YEAR);
    }
    
    /**
     * Guarda una preferencia de tipo int
     *
     * @param context
     * @param key
     * @param value
     * @param expireTime
     */
    public static void write(Context context, String key, int value, int expireTime) {
        try {
            getSharedPreferenceManager(context).put(key, String.valueOf(value), expireTime);
        } catch (Exception e) {
        }
    }
    
    /**
     * Guarda una preferencia de tipo int durante un año
     *
     * @param context
     * @param key
     * @param value
     */
    public static void write(Context context, String key, int value) {
        write(context, key, value, DiskCache.TIME_YEAR);
    }
    
    /**
     * Lee una preferencia de tipo Boolean
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static Boolean read(Context context, String key, Boolean defaultValue) {
        try {
            return getSharedPreferenceManager(context).getAsBoolean(key, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }
    
    /**
     * Lee una preferencia tipo long
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static long read(Context context, String key, long defaultValue) {
        try {
            return Long.parseLong(getSharedPreferenceManager(context).getAsString(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }
    
    /**
     * Lee una preferencia tipo int
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static int read(Context context, String key, int defaultValue) {
        try {
            return Integer.parseInt(getSharedPreferenceManager(context).getAsString(key));
        } catch (Exception e) {
            return defaultValue;
        }
    }
    
    /**
     * Lee una preferencia tipo String
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static String read(Context context, String key, String defaultValue) {
        try {
            return getSharedPreferenceManager(context).getAsString(key, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
