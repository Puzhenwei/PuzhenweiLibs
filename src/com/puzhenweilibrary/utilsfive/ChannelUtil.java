package com.puzhenweilibrary.utilsfive;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 多渠道打包工具类
 * <p>
 * 需配合Python脚本使用
 */
public class ChannelUtil {

    /**
     * 初始化渠道
     */
    public static void init(Context context, ChannelListener listener) {
        String channelId = getChannelFromApk(context, "channel-");
        if (TextUtils.isEmpty(channelId)) {
            channelId = "test";
        }
        Log.v("channel", "当前渠道:" + channelId);
        if (listener != null) {
            listener.onResult(channelId);
        }
    }

    /**
     * 从apk中获取渠道信息
     *
     * @param context
     * @param channelPrefix 渠道前缀
     * @return
     */
    private static String getChannelFromApk(Context context, String channelPrefix) {
        //从apk包中获取
        ApplicationInfo appinfo = context.getApplicationInfo();
        String sourceDir = appinfo.sourceDir;
        //默认放在meta-inf/里， 所以需要再拼接一下
        String key = "META-INF/" + channelPrefix;
        String ret = "";
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.startsWith(key)) {
                    ret = entryName;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String[] split = ret.split(channelPrefix);
        String channel = "";
        if (split != null && split.length >= 2) {
            channel = ret.substring(key.length());
        }
        return channel;
    }

    /**
     * 渠道回调
     */
    public interface ChannelListener {
        void onResult(String channelId);
    }

}
