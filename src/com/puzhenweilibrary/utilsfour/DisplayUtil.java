package com.puzhenweilibrary.utilsfour;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author MaTianyu
 * @date 2015-04-19
 */
public class DisplayUtil {
    private static final String TAG = DisplayUtil.class.getSimpleName();
    
    /**
     * 获取 显示信息
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm;
    }
    
    /**
     * 打印 显示信息
     */
    public static DisplayMetrics printDisplayInfo(Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);
        return dm;
    }
}
