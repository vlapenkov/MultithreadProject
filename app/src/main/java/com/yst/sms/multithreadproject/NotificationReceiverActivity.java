package com.yst.sms.multithreadproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
Куда попадаем при нажатии уведомления
 */

public class NotificationReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_receiver);
    }
}
