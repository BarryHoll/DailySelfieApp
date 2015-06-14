package com.bchollywood.dailyselfieapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Barry on 14/06/2015.
 */
public class DailySelfieAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent dailySelfieActivityIntent = new Intent(context, DailySelfieActivity.class);
        dailySelfieActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, dailySelfieActivityIntent, 0);

        // Build notification
        Notification notification = new Notification.Builder(context)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentIntent(pendingIntent)
                .build();

        // Pass the Notification to the NotificationManager:
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, notification);

    }
}
