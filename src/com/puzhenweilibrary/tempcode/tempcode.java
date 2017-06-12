package com.puzhenweilibrary.tempcode;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.puzhenweilibrary.R;
import com.puzhenweilibrary.activity.MainActivity;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2017-4-17.
 */
public class tempcode {
    private static final String TAG = "tempcode";
    private Context mContext;

    // Display the topbar notification
    private void showNotification(String text) {
        Log.i(TAG, "showNotification");
        /**
         * older API
         */
        Notification n = new Notification();
        n.flags |= Notification.FLAG_SHOW_LIGHTS;
        n.flags |= Notification.FLAG_AUTO_CANCEL;
        n.defaults = Notification.DEFAULT_ALL;
        // n.icon = R.drawable.logo;
        n.when = System.currentTimeMillis();
        // Simply open the parent activity
        // PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(mContext, MainActivity.class), 0);
        // Change the name of the notification here
        // n.setLatestEventInfo(this, NOTIF_TITLE, text, pi);
        // mNotifMan.notify(NOTIF_CONNECTED, n);

        /**
         * new API
         */
        // NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        // 必需的通知内容
        // builder.setContentTitle("content title").setContentText("content describe");
        // Intent notifyIntent = new Intent(this, AtyService.class);
        // PendingIntent notifyPendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // builder.setContentIntent(notifyPendingIntent);
        // Notification notification = builder.build();
        // NotificationManager manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        // manager.notify(1, notification);
        // service's method
        // startForeground(1, notification);
    }

    public static String getMapKey(Map<String, Object> map) {
        Set<String> keys = map.keySet();// 得到全部的key
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            return str;
        }
        return "";
    }
}
