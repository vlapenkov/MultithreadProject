package com.yst.sms.multithreadproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void Button3Click(View v){
        // Запускаем свой IntentService
        Intent intentMyIntentService = new Intent(this, MyIntentService.class);

        startService(intentMyIntentService.putExtra("time", 10).putExtra("task",
                "Погладить кота"));
        startService(intentMyIntentService.putExtra("time", 5).putExtra("task",
                "Покормить кота"));
        startService(intentMyIntentService.putExtra("time", 20).putExtra("task",
                "Поиграть с котом"));
    }
}
