package com.yst.sms.multithreadproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;


public class SampleBootReceiver extends BroadcastReceiver {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Log.d("ALARM SET BEGIN", "onReceive");
            alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent  intentToCall = new Intent(context, AlarmReceiver.class);
            alarmIntent = PendingIntent.getBroadcast(context, 0, intentToCall, 0);

            alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() +
                            60 * 1000, alarmIntent);
            Log.d("ALARM SET END", "onReceive");
        }
    }
}