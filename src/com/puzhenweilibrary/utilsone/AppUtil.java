package com.puzhenweilibrary.utilsone;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

//import com.squareup.picasso.Picasso;
//import com.sts.teslayun.R;
//import com.sts.teslayun.commons.AppConstant;
//import com.sts.teslayun.db.beans.User;
//import com.sts.teslayun.db.daos.UserDao;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.squareup.picasso.Picasso;

/**
 * 工具类 Created by XiaoWei on 2015/7/14.
 */
public final class AppUtil {
    
    public static int dp2px(int dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }
    
    /**
     * Base64加密
     */
    public static String encodeWithBase64(String string) {
        return Base64.encodeToString(string.getBytes(Charset.forName("utf-8")), Base64.DEFAULT);
    }
    
    /**
     * Base64解密
     */
    public static String decodeWithBase64(String s) {
        return new String(Base64.decode(s, Base64.DEFAULT), Charset.forName("utf-8"));
    }
    
    /**
     * 获取账户Account
     */
    // public synchronized static User getUser(Context context) {
    // if (AppConstant.USER == null) {
    // AppConstant.USER = new UserDao(context, User.class).queryForFirst();
    // }
    //
    // return AppConstant.USER;
    // }
    
    /**
     * 设定Account
     */
    // public synchronized static void setUser(Context context, User user) {
    // UserDao userDao = new UserDao(context, User.class);
    // userDao.deleteAll();
    // userDao.createOrUpdate(user);
    // AppConstant.USER = user;
    // }
    
    /**
     * 验证用户是否登录
     */
    // public static boolean userHasLogined(Context context) {
    // return UserDao.getInstance(context).checkIsLogin();
    // }
    
    /**
     * 设置SharedPreferences
     */
    public static void setSharedPreferences(Context context, String key, String info) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putString(key, info).apply();
    }
    
    /**
     * 获取SharedPreferences
     */
    public static String getSharedPreferences(Context context, String key) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return defaultSharedPreferences.getString(key, "");
    }
    
    /**
     * 设置布尔型SharedPreferences
     */
    public static void setSharedPreferencesByBoolean(Context context, String key, boolean isState) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putBoolean(key, isState).apply();
        
    }
    
    /**
     * 获取布尔型SharedPreferences,默认返回false
     */
    public static boolean getSharedPreferencesByBoolean(Context context, String key) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return defaultSharedPreferences.getBoolean(key, false);
    }
    
    /**
     * 设置Integer型SharedPreferences
     */
    public static void setSharedPreferencesWithInt(Context context, String key, int intArg) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putInt(key, intArg).apply();
    }
    
    /**
     * 获取Integer型SharedPreferences
     */
    public static int getSharedPreferencesWithInt(Context context, String key) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return defaultSharedPreferences.getInt(key, 0);
    }
    
    /**
     * 获取屏幕区域
     */
    private static Rect getScreenRect() {
        DisplayMetrics displayMetric = Resources.getSystem().getDisplayMetrics();
        return new Rect(0, 0, displayMetric.widthPixels, displayMetric.heightPixels);
    }
    
    /**
     * 获取屏幕宽度（像素）
     */
    public static int getScreenWidth() {
        DisplayMetrics displayMetric = Resources.getSystem().getDisplayMetrics();
        return displayMetric.widthPixels;
    }
    
    /**
     * 获取屏幕高度（像素）
     */
    public static int getScreenHeight() {
        DisplayMetrics displayMetric = Resources.getSystem().getDisplayMetrics();
        return displayMetric.heightPixels;
    }
    
    /**
     * 验证电话号码
     */
    public static boolean isMobileNumberAvailable(String mobileNo) {
        // String regPattern = "(^(\\d{3,4}-)?\\d{7,8})$|([00[34578][0-9]{9})";
        String regPattern = "^[1]([3][0-9]{1}|50|51|52|53|55|56|59|58|70|71|80|83|85|86|87|88|89)[0-9]{8}$";
        Pattern p = Pattern.compile(regPattern);
        Matcher m = p.matcher(mobileNo);
        return m.matches();
    }
    
    /**
     * 验证密码的正则表达式，要求同时有数字和字母，长度最小6，最大16
     */
    public static boolean notAvailablePassword(String password) {
        // String regPattern = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        String regPattern = "^[0-9a-zA-Z]{6,16}$";
        Pattern p = Pattern.compile(regPattern);
        Matcher m = p.matcher(password);
        
        return !m.matches();
    }
    
    /**
     * 打开输入法
     */
    public static void showInputMethod(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        
        InputMethodManager inputManager = (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(editText, 0);
    }
    
    /**
     * 关闭输入法
     */
    public static void hideInputMethod(EditText editText) {
        InputMethodManager inputManager = (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
    
    /**
     * 拼接图片的完整服务器路径
     */
    public static String getImageUrl(Context context, String url) {
        if (url != null && url.contains("http:")) // 网络图片
            return url;
        if (url != null /* && url.contains(AppConstant.CACHE_PHOTO_PATH) */) // 本地图片
            return new StringBuilder().append("file://").append(url).toString();
        return new StringBuilder().append(context.getString(/* R.string.server_address */0)).append("/").append(url).toString();
    }
    
    /**
     * double类型如果小数点后为零则显示整数否则保留
     */
    public static String doubleTrim(double num) {
        if (Math.round(num) - num == 0) {
            return String.valueOf((long)num);
        }
        return String.valueOf(num);
    }
    
    /**
     * 时间格式化
     *
     * @param dateString yyyy-MM-dd
     * @return Date
     */
    public static Date formatDate(String dateString) {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return date;
    }
    
    public static void showToast(Handler handler, String message) {
        if (handler != null) {
            Message msg = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(/* AppConstant.HANDLER_MSG */"", message);
            msg.setData(bundle);
            msg.what = /* AppConstant.HANDLER_MSG_WHAT */0;
            handler.sendMessage(msg);
        }
    }
    
    public static String getText(String str) {
        if (str == null)
            return "";
        return str;
    }
    
    public static void picassoHandleImageView(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(AppUtil.getImageUrl(context, url)).placeholder(/* R.color.gray_light */0).error(/*
                                                                                                                    * R.
                                                                                                                    * color
                                                                                                                    * .
                                                                                                                    * gray_light
                                                                                                                    */0).into(imageView);
    }
    
    public static void picassoHandleImageView(Context context, String url, ImageView imageView, int defaultImg) {
        Picasso.with(context).load(AppUtil.getImageUrl(context, url)).placeholder(defaultImg).error(defaultImg).into(imageView);
    }
    
    /**
     * 判断是否是数字
     * 
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
    
}
