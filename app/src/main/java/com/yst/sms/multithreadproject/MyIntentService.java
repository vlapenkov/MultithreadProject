package com.yst.sms.multithreadproject;

/**
 * Created by user on 29.05.2017.
 */
import java.util.concurrent.TimeUnit;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyIntentService extends IntentService {
    public static final String ACTION_MYINTENTSERVICE = "ru.alexanderklimov.intentservice.RESPONSE";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
    private final String TAG = "IntentServiceLogs";

    public MyIntentService() {
        super("myname");
    }

    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int tm = intent.getIntExtra("time", 0);
        String label = intent.getStringExtra("task");
        Log.d(TAG, "onHandleIntent start: " + label);
        try {
            TimeUnit.SECONDS.sleep(tm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onHandleIntent end: " + label);


        Intent receiverIntent = new Intent(this, NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), receiverIntent, 0);

        NotificationManager mNotificationManager =          (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_account_circle_black_24dp)
                        .setContentIntent(pIntent)
                        .setContentTitle(label)
                        .setContentText("Что делать с котами");
                        //.addAction(R.drawable.ic_action_name, "Call", pIntent);

                mNotificationManager.notify(001, mBuilder.build());
    }
}


