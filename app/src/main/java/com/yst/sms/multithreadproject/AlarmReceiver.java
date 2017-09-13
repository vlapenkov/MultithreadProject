package com.yst.sms.multithreadproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by user on 11.09.2017.
 */
public class AlarmReceiver extends BroadcastReceiver
{
    private final String TAG = "AlarmReceiver";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO Auto-generated method stub

        Log.d(TAG, "onReceive start: ");
        Intent intentMyIntentService = new Intent(context, MyIntentService.class);

        context.startService(intentMyIntentService.putExtra("time", 5).putExtra("task",
                "Покормить кота"));
        Log.d(TAG, "onReceive end: ");

    }

}
