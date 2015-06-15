package com.bchollywood.dailyselfieapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

/**
 * Created by Barry on 14/06/2015.
 */
public class DailySelfieAlarmReceiver extends BroadcastReceiver {

    private Intent mNotificationIntent;
    private PendingIntent mContentIntent;
    private static final int NOTIFICATION_ID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {

        mNotificationIntent = new Intent(context, DailySelfieActivity.class);
        mContentIntent = PendingIntent.getActivity(context, 0, mNotificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        // Build the Notification
        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification.Builder notificationBuilder = new Notification.Builder(context)
                .setTicker("Say cheese!")
                .setSmallIcon(android.R.drawable.stat_sys_warning) //TODO: Change the icon...
                .setAutoCancel(true)
                .setContentTitle("It's selfie time!")
                .setContentIntent(mContentIntent)
                .setSound(alarm);

        // Get the Notification Manager
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE
        );

        // Pass the Notification to the Notification Manager
        mNotificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    }
}
