package com.yst.sms.multithreadproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivitySecond extends AppCompatActivity {

    final String TAG  = "States";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void ButtonClick(View v){
        // Запускаем свой IntentService
        Intent intentMyIntentService = new Intent(this, MyIntentService.class);

        startService(intentMyIntentService.putExtra("time", 10).putExtra("task",
                "Погладить кота"));
        startService(intentMyIntentService.putExtra("time", 5).putExtra("task",
                "Покормить кота"));
        startService(intentMyIntentService.putExtra("time", 20).putExtra("task",
                "Поиграть с котом"));
    }

    public void Button3Click(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivitySecond: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivitySecond: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivitySecond: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivitySecond: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ActivitySecond: onDestroy()");
    }
}
