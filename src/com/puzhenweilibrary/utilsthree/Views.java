package com.puzhenweilibrary.utilsthree;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Views {
    
    public static void appear(View v, int duration) {
        if (v.getVisibility() != View.VISIBLE) {
            ObjectAnimator.ofFloat(v, "alpha", 0, 1).setDuration(duration).start();
            v.setVisibility(View.VISIBLE);
        }
    }
    
    public static void disappear(View v, int duration) {
        if (v.getVisibility() == View.VISIBLE) {
            Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_out);
            fadeInAnimation.setDuration(duration);
            v.startAnimation(fadeInAnimation);
            v.setVisibility(View.GONE);
        }
    }
    
    public static int getPixels(int dipValue) {
        return getPixels(MunixUtilities.context, dipValue);
    }
    
    public static int getPixels(Context mContext, int dipValue) {
        if (mContext != null && dipValue > 0) {
            Resources r = mContext.getResources();
            int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
            return px;
        } else
            return 0;
    }
    
    /**
     * Obtiene un drawable por su nombre representado en un String
     *
     * @param context
     * @param name nombre del recurso drawable
     * @return
     */
    public static int getDrawableByString(Context context, String name) {
        return getResourceByString(context, "drawable", name);
    }
    
    /**
     * Obtiene un recurso por su nombre en string y su tipo en string. El "mipmap" "ic_launcher"
     *
     * @param context
     * @param resourceType
     * @param name
     * @return
     */
    public static int getResourceByString(Context context, String resourceType, String name) {
        int resource = 0;
        
        try {
            resource = context.getResources().getIdentifier(name, resourceType, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resource;
    }
}
